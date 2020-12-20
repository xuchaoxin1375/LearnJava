package experiment2;

/*
定义：
计算机类：
包含开机功能、关机功能，
实现计算机通过 显卡、声卡的PCI接口使用PCI设备功能，
实现播放视频和声频的方法
显卡类：要实现PCI接口，具备打开显卡、关闭显卡和播放视频的功能。
声卡类：要实现PCI接口，具备打开声卡、关闭声卡和播放音频的功能。
eg/\
interface J_Shape
{
public abstract void mb_draw(Graphics2D g);
} // 接口J_Shape结束
*/
/* default:*/
interface PCI {
    void use();

    void open();

    void close();
}

class Video implements PCI {
    /*尚未使用的方法在IDEA中显示为浅色系的*/
    public void specialTest(){
        System.out.println("test Video overed, bye!");
    }
    public void use() {
        System.out.println("使用显卡");
    }

    public void open() {
        System.out.println("视频播放");
    }

    public void close() {
        System.out.println("关闭显卡");
    }
}

class Voice implements PCI {
    public void specialTest(){
        System.out.println("test voice overed,bye!");
    }
    public void use() {
        System.out.println("使用声卡");
    }

    public void open() {
        System.out.println("播放音频");
    }

    public void close() {
        System.out.println("关闭声卡");
    }
}

class Computer {
    // 不写static的话静态的main()无法直接访问方法:
    public void open() {
        System.out.println("电脑开机");
    }

    public void close() {

        System.out.println("电脑关机");
    }

    /*使用PCI;这个方法需要完成的功能:输入某个PCI设备(对象参数),能够启用,播放,以及关闭着一些列完整操作
   使用if-esle结构可对相应设备指定更加精细的操作;*/
    public void usePCIDevice(PCI device) {
        device.use();// 打开设备
        device.open();
        device.close();// 关闭设备
        if(device instanceof Video){
            ((Video) device).specialTest();//IDEA2020专业的真是强大,调用子类的特有函数时,能够将父类(应该说是接口类的引用变量)自动强制类型转换为子类(但是需要if里的instanceof 比较);

        }
        else{
            //方法一:
            ((Voice)device).specialTest();
            //方法二:(有局限性,当某些操作需要访问某些值的时候就不适宜,仅在打印某些提示性字符串的时候可用)
            System.out.println("in another way to invoke the methods that are unique to subclasses:");
            Voice voice = new Voice();
            voice.specialTest();
        }
    }
}

public class Demo{
    // main()
    public static void main(String[] args) {
        Computer Pc = new Computer();
        Video video = new Video();
        Voice voice=new Voice();

        Pc.open();
        Pc.usePCIDevice(video);
        Pc.usePCIDevice(voice);



        Pc.close();
    }
}
