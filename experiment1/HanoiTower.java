package experiment1;

/*
hanoiTower塔
  有三个杆：A、B、C，将n个圆盘（编号1、2、…、n，圆盘按从小到大编号）
  从A杆移动到C杆，
  要求移动中不能把大盘放在小盘上，只能小盘放在大盘上。移动的次数要求最少。

*/
  /*
    HanoiTowerTower的关键过程在于使得A柱子上的n个圆盘,通过一系列移动后(记为f(n-1)次,f(n)表示的是使得最大盘浮现出来所需要的移动步骤数),让最底层的n号圆盘浮出水面;
         hanoi(n - 1, origin, destination, assist);//传入描述问题的参数给hanoi方法.
    现在,你要再把圆盘n移到C柱子(而且此时的C柱子还得时空的状态才能允许n盘放下(n盘是最大盘,只能放在最下面)(放完之后这时的圆盘n可以认为是固化在C住上了,没有必要再移走它了(问题规模减小了一级)),
        move(origin, destination);
    此时B柱子上还是有n-1个圆盘(而且这n-1个盘还是有序的排在B柱子上,此时你需要将B柱子上的n-1个圆盘,在通过f(n-1)次移动,将这n-1个圆盘都移动到C柱子上(可以发现,这一目的和最初有n个圆盘时所做的事是几乎一样的,
        hanoi(n - 1, assist, origin, destination);
    完成这一工作后,C柱上有所有的圆盘了;


    将这个过程实现为递归:(此处的assist柱和destination柱在移动过程中是相对的角色;)
        hanoi(n - 1, origin, destination, assist);
            move(origin, destination);
            hanoi(n - 1, assist, origin, destination);

    */
public class HanoiTower {

    // /*
    // *  n 盘子的数目
    // *  origin 源座
    // *  assist 辅助座
    // * destination 目的座
    // */
    public int i;

    //n+1级规模需要分为三部分执行,需要执行两份n级规模的操作
    //一个递归函数的(高效)编写需要依赖于预先对该函数有清晰的功能和参数(含义)的描述),毕竟,在编写这个函数的过程中,你得要去调用它嘛.
    public void hanoi(int n/*盘子的数目*/, char origin, char assist, char destination) {//递归入口(相对外层:location_1)
        if (n == 1) {//递归出口(必要部分)
            printMovement(origin, destination,n);//执行之后开始"归的过程",不再else
        }
        else//核心部分
        {
            /* 递归过程中,两条语句的n-1是同一个值 */
            hanoi(n - 1, origin, destination, assist);/*相对内层(越进越深,n越小,深入的过程必定先进相对外层,再进入相对内层,可以发现这个过程中assist参数和destination参数发生了对调;
            这一部分的n减小至的时候,就可以调用到该深度的move方法,进而开始"归"的过程;)*/
            printMovement(origin, destination,n);//归的过程中调用,这里的origin和destination 与相对外层location_1是一致的
            hanoi(n - 1, assist, origin, destination);
        }//endElse
    }//endHanoi

    // move()方法;Print the route of the movement
    private void printMovement(char origin, char destination, int n) {
        //states[i]=origin;
        System.out.println("move"+ ++i +":"+" " +"disk "+ n+":"
                +origin + "->" + destination);

    }

    public static void main(String[] args) {
        HanoiTower objHanoi = new HanoiTower();//new一个HanoiTower对象,调用默认构造方法
        objHanoi.hanoi(4, 'A', 'B', 'C');//调用hanoihanoi方法
    }
}
