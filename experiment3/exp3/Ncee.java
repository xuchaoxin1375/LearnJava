/*
����һ���˴ӳ������ڿ�ʼ�����μӸ߿���ʱ�����ж����죨������18��μӸ߿���
* */
package experiment3.exp3;
/*�㷨:Nceeday-Today*/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Ncee {
    public static void function() throws Exception {

        System.out.println("������������� ��ʽ YYYY-MM-dd��");

// ��ȡ��������,��������
        String birthdayString = new Scanner(System.in).next();

        /*��ȡ���:*/
        String year=birthdayString.substring(0,4);
        String partOfAfterYear=birthdayString.substring(4,birthdayString.length());
        int yearInt=Integer.parseInt(year);
        int yearNcee=yearInt+18;
       // System.out.println("yearInt="+yearInt);
        //System.out.println("partOfAfterYear="+partOfAfterYear);
        String NceedayString=yearNcee+"-06-07";
       // System.out.println(NceedayString);
// ���ַ�������,ת��Date����
// ����SimpleDateFormat����,д����ģʽ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// ���÷���parse,�ַ���ת�����ڶ���
        Date NceedayDate = sdf.parse(NceedayString);

// ��ȡ��������ڶ���
        Date todayDate = new Date();

// ����������NceedayDate,todayDateת�ɺ���ֵ,Date��ķ���getTime
        long NceedaySecond = NceedayDate.getTime();
        long todaySecond = todayDate.getTime();

        long second = NceedaySecond-todaySecond;
        if (second < 0){
            System.out.println("��û������");
        } else {
//            System.out.println();
            System.out.println("��߿�����"+second/1000/60/60/24+"��");
        }
    }

    public static void main(String[] args) {
        try {
            Ncee.function();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
