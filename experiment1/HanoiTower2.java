package experiment1;

/*这种方法在改变问题规模的时候的扩充性不好*/
public class HanoiTower2 {
    public static int count = 0;

    public static void main(String[] args) {
        char[] current = {'A', 'A', 'A', 'A'};//各个圆盘当前的所处的位置(在那个杆子上面),刚开始的时候,各个圆盘都在A上面,圆盘数目为数组维数.其中,盘从小到大排列.
        int n = current.length;//圆盘数目.
        char A = 'A', B = 'B', C = 'C';//三个杆子的名称

        hanoi(current, n, A, B, C);
        System.out.println(String.format("总共移动次数为%d次", count));
    }

    //核心方法:hanoi:
    public static void hanoi(char[] current/*杆子数组.*/, int n,/*杆的数目*/
                             char A, char B, char C) {
        //本方法中,移动圆盘这一操作通过current[i]=C或者current[n-1]=C来体系;
        if (n == 1) {//递归出口
            int i = pickTopDisk(current, A); //返回x杆顶部圆盘编号
            current[i] = C;//将i号圆盘所处的杆置为C杆(表示将i号盘移到C号杆上)
            count++;
            System.out.println("move " + count + " disk" + (i + 1) + ":" + A + "->" + C);//注意,这里的A,C都是变量
            return;
        }

        hanoi(current, n - 1, A, C, B);//分支递归1
        current[n - 1] = C;//current[n-1]即最大盘所处的杆号,此处要将其移动到C杆上,体现为对current[n-1]的赋值修改.
        count++;
        System.out.println("move " + count + "disk " + n + ":" + A + "→" + C);
        hanoi(current, n - 1, B, A, C);//分支递归2
    }

    public static int pickTopDisk(char[] current, char x) {
        int i = 0;
        /*//返回x(当然这里一共就三个杆子,x的取值范围(A/B/C)杆  顶部圆盘(顶部体现在最先被x匹配到(小盘号一定在上面(在数组中体现在索引考前) 编号i(即第几个圆盘:i号圆盘.);而且i的取值范围为[0,1,2,...,n].;在索引越界前一定能够找到X杆的*/
        while (current[i] != x)

            i++;
        return i;
    }
}

