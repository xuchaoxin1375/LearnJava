package TestPrintKnowledges.printCharToASCII;
/*java_查询从控制台输入的字符的ASCII码值(每行一个,-1结束)*/
import java.util.Scanner;

public class PrintCharToASCII {
    public static void main(String[] args) {
              /*  Scanner scanner = new Scanner(System.in);
                System.out.println("输入一个字符");
                char chr= (char) scanner.nextByte();//有问题.
                System.out.println((int)chr);*/
        /*提高容错:*/
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符：");
        String s = input.nextLine();
        /*        if (!s.equals("-1")) {
                    System.out.println((int) s.charAt(0));//char ch = s.charAt(0);//'-'的ascii=45;
                }*/
        while (!s.equals("-1")) {
            //调换以下两个语句会带来不必要的多余输出麻烦.
            System.out.println((int) s.charAt(0));
            s = input.nextLine();
        }
        input.close();
//        System.out.println('?');//打印:?
        //  System.out.println((int)'?');//打印ASCII码63.
    }
}
