package experiment6.exp2;


import java.util.Scanner;

/**
 * �����ܼ��쳣�� OddException����ʾ���������ʱ������Ϊ����ʱ���ֵ��쳣��
 * ������붨���������췽��:
 * Ĭ�Ϲ��췽���ʹ��ַ��������Ĺ��췽����
 * ��дMathDivide�࣬ʵ�ֳ�Ա����divide(double b,double c)���������ݵĳ�����
 * ������ܴӿ���̨��������������������������������̡��������ĳ�����������
 * ���׳�OddException�쳣������������������������̡�
 */
public class DivideTryCatch {
    public static void main(String[] args) {
        System.out.println("�����뱻�����ͳ������ö��Ÿ���,��������:");

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
