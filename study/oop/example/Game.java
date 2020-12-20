package study.oop.example;
/*一个代码单元应该负责一个聚合的任务（也就是说，一个任务可以被看作是 一个逻辑单元）。一个方法应该实现一个逻辑操作，而一个类应该代表一定类型的实体。聚合 理论背后的要点是重用：如果一个方法或类是只负责一件定义明确的事情，那么就很有可能在 另外不同的上下文环境中使用。遵循这个理论的一个额外的好处是，当程序某部分的代码需要 改变时，在某个代码单元中很可能会找到所有需要改变的相关代码段。
从程序中识别出框架和数据，以代码实现框架，将部分功能以数据的方式加载，这样能在很大程度上实现可扩展性。*/
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    /*成员域有一个Room引用类,一个HashMap容器,存储功能映射*/
    private Room currentRoom;
    private HashMap<String, Handlerr> handlers = new HashMap<>();
/*Game主公共类的构造器constructor*/
    public Game() {
        /*这里用到的this是当前这个Game对象的引用(会在main(args)时实例化出一个游戏game对象.*/
       // System.out.println(this.getClass().getName());//查看一下this所指对象是啥类型(Game)
        //该构造器将 功能字符串和对应的功能类(Handler的若干子类)建立映射关系放入handlers容器中
        /*从程序中识别出框架和数据，以代码实现框架，
        将部分功能以数据的方式加载，(比如下面的操作)这样能在很大程度上实现可扩展性。*/
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("go", new HandlerGo(this));
        createRooms();

    }
/*创建房间以及内置出口信息*/
    public void createRooms() {
        Room outside, lobby, pub, study, bedroom;/*多余的逗号导致会错误全线变量混乱*/
        //创建房间
        lobby = new Room("大堂");
        study = new Room("书房");
        outside = new Room("城堡外");
        pub = new Room("酒吧");
        bedroom = new Room("卧室");
        //初始化出口(同一个方间可以设置多个出口.(出口方向所通向的房间)
        /*然而,这里的通路需要小心,每个房间都应该有去有回,如果进入到一个新地方后没有提供通路,那就困死在里面啦.*/
        lobby.setExit("south", outside);
        lobby.setExit("west", bedroom);

        pub.setExit("west", outside);
        study.setExit("south", lobby);
        outside.setExit("east", pub);
        outside.setExit("north", lobby);
        bedroom.setExit("east", lobby);
/*初始化当前所在房间(位置)为outside(城堡外面)*/
        currentRoom = outside;
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("欢迎！");
        System.out.println();
        System.out.println("这是一个超级无聊的城堡游戏");
        System.out.println();
        System.out.println("如果你需要帮助请输入:help");
        System.out.println();
        System.out.println("那么现在开始吧！");
        System.out.println();
        //System.out.println("你现在在" + currentRoom + " " + currentRoom.getExitDesc());
        showPrompt();
        System.out.println();
    }

    //以下为提供用户(玩家)的命令(操作):
    /*不过此前应给创建好各个房间以及内置存储了各个房间可走的方向-下个位置房间键值对的信息.*/
    public void goRoom(String dir) {
        Room nextRoom = currentRoom.getExit(dir);
        if (nextRoom == null) {
            System.out.println("那里没有门");
        } else {
            currentRoom = nextRoom;//更新currentRoom.
            /*System.out.println("你现在在" + currentRoom + " " + currentRoom.getExitDesc());
            System.out.println();*/
            showPrompt();
        }
    }
/*showPrompt附属个goRoom()方法,以便反馈操作的结果*/
    public void showPrompt() {
        System.out.println("你在" + currentRoom);
        System.out.print("出口有: ");
        System.out.println(currentRoom.getExitDesc());
        System.out.println();
    }
/*开始游戏:*/
    public void play() {
        Scanner in = new Scanner(System.in);//创建一个Scanner对象;
        while (true) {
            System.out.println("输入您的指令:");
            String line = in.nextLine();//读入玩家的操作字符串
            String[] words = line.split(" ");//预备解析玩家的操作,将处理的结果存入到一个String 数组中
            Handlerr handler;//声明一个功能类对象的引用(对象管理者)
            //handlers容器是装载着功能类的对象(handlers容器对象属于Game对象)
            handler = handlers.get(words[0]);/* 执行处理第一个词语解析:查询word[0]动作将对用什么操作(功能);
                                            返回一个功能类即Handlerr类的对象(到这里,handler已经指定好了功能对象(可能是
                                            HandlerGo/HandlerHelp/HandlerBye中的某一个*/
            /*为了提高健壮性,设置一个过渡字符串变量value*/
            String value = " ";
            if (words.length >= 2) {
                /*有两个词语的合法操作中,第二个词一定是方向*/
                value = words[1];
            }
            /*如果上头返回的handler功能存在(即handler!=null):*/
            if (handler != null) {

                handler.doCmd(value);/*通过功能类对象调用对应的功能(当然,现在提供的操作中有第二个词的只有go dir,ye也就是说,value如果非空且合法的话,应该是east/west/north/south中的某个*/
            /*游戏是否终止的检查阶段:*/
                if(!currentRoom.isSave()){break;}//当前是否落入死胡同.//此外,如果isSave()的具体实现在Room中发生变化,只要功能还是一样,就不会影响当前代码;
                /*bye操作比较特殊,在所有的玩家可执行的操作功能的功能对象中都从handlerr父类那里继承过了isBye()方法,只不过,
                仅在通过HandlerBye功能对象调用isBye()方法判断结果是才返回true,默认情况下继承过来的都是return false的操作
                即特地地判断一下是否终止游戏.(通过检查handler是否发出终止的信号(return true)*/
                if (handler.isBye()) {
                    break;
                }
            }

        }
        in.close();//结束从Console的输入需求
    }

    public static void main(String[] args) {
        Game game=new Game();
        game.printWelcome();
        game.play();
        System.out.println("感谢您的光临。再见！");
    }
}
