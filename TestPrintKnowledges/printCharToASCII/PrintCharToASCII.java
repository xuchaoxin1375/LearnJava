package TestPrintKnowledges.printCharToASCII;
/*java_��ѯ�ӿ���̨������ַ���ASCII��ֵ(ÿ��һ��,-1����)*/
import java.util.Scanner;

public class PrintCharToASCII {
    public static void main(String[] args) {
              /*  Scanner scanner = new Scanner(System.in);
                System.out.println("����һ���ַ�");
                char chr= (char) scanner.nextByte();//������.
                System.out.println((int)chr);*/
        /*����ݴ�:*/
        Scanner input = new Scanner(System.in);
        System.out.println("������һ���ַ���");
        String s = input.nextLine();
        /*        if (!s.equals("-1")) {
                    System.out.println((int) s.charAt(0));//char ch = s.charAt(0);//'-'��ascii=45;
                }*/
        while (!s.equals("-1")) {
            //�����������������������Ҫ�Ķ�������鷳.
            System.out.println((int) s.charAt(0));
            s = input.nextLine();
        }
        input.close();
//        System.out.println('?');//��ӡ:?
        //  System.out.println((int)'?');//��ӡASCII��63.
    }
}
