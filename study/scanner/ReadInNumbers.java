package study.scanner;

import java.util.Scanner;

public class ReadInNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine())//判断是否有输入一行数据
        {
            String tmp = in.nextLine();//将一行数据读出
            if(tmp.equals("q"))//输入q退出程序
                break;
            String arr[] = tmp.split("\\s+");
            /*使用正则表达式将字符串分割 “\\s+”表示多个空格
            public String[] split(@NotNull String regex)；即split只能返回Stirng类型的数的引用*/
            int sum = 0;
            for(String a:arr)//遍历所有的字符串并转换成整数求和
            {
                sum+=Integer.parseInt(a);/*public static int parseInt(@NotNull String s)
throws NumberFormatException用Integer类中的解析方法(静态方法),通过类名Integer调用其中的静态方法;
java.lang public final 类 Integer
extends Number*/
            }
            System.out.println(sum);
        }

    }
}
