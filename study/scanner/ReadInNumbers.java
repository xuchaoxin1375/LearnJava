package study.scanner;

import java.util.Scanner;

public class ReadInNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine())//�ж��Ƿ�������һ������
        {
            String tmp = in.nextLine();//��һ�����ݶ���
            if(tmp.equals("q"))//����q�˳�����
                break;
            String arr[] = tmp.split("\\s+");
            /*ʹ��������ʽ���ַ����ָ� ��\\s+����ʾ����ո�
            public String[] split(@NotNull String regex)����splitֻ�ܷ���Stirng���͵���������*/
            int sum = 0;
            for(String a:arr)//�������е��ַ�����ת�����������
            {
                sum+=Integer.parseInt(a);/*public static int parseInt(@NotNull String s)
throws NumberFormatException��Integer���еĽ�������(��̬����),ͨ������Integer�������еľ�̬����;
java.lang public final �� Integer
extends Number*/
            }
            System.out.println(sum);
        }

    }
}
