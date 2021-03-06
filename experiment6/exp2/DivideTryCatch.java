package experiment6.exp2;


import java.util.Scanner;

/**
 * 定义受检异常类 OddException，表示两个数相除时，除数为奇数时出现的异常。
 * 该类必须定义两个构造方法:
 * 默认构造方法和带字符串参数的构造方法。
 * 编写MathDivide类，实现成员方法divide(double b,double c)，两个数据的除法。
 * 程序接受从控制台输入的两个浮点数，计算这两个数的商。如果输入的除数是奇数，
 * 将抛出OddException异常并处理，否则输出这两个数的商。
 */
public class DivideTryCatch {
    public static void main(String[] args) {
        System.out.println("请输入被除数和除数并用逗号隔开,输入两组:");

       /* float a=sc.nextFloat();
        String tmp=sc.next();
        float b=sc.nextFloat();*/
        int cnt = 0; Scanner sc = new Scanner(System.in);
        while (cnt++ < 2) {

            String line = sc.nextLine();
            String[] arrayLine = line.split(",");
            double a = Double.parseDouble(arrayLine[0]);
            double b = Double.parseDouble(arrayLine[1]);
            /* instantiate an object for deal math division */
            MathDivide mathdivide = new MathDivide();
            //System.out.println(a+"/"+b+"=" +mathDivide.divide(a, b));
            try {
                mathdivide.divide(a, b);
            } catch (OddException e) {
                e.printStackTrace();
            }
        }
    }
}
