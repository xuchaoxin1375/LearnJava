package experiment3.exp3;

/*
        Date��
        ʹ������ʱ����ص�API�������һ�����Ѿ������˶���
        ��?
        ˼·��
        1.��ȡ��ǰʱ���Ӧ�ĺ���ֵ
        2.��ȡ�Լ��������ڶ�Ӧ�ĺ���ֵ
        3.����ʱ���������ǰʱ��C �������ڣ�
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class DemoParse {
    public static void function() throws Exception {

        System.out.println("������������� ��ʽ YYYY-MM-dd��");

// ��ȡ��������,��������
        String birthdayString = new Scanner(System.in).next();

// ���ַ�������,ת��Date����
// ����SimpleDateFormat����,д����ģʽ
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// ���÷���parse,�ַ���ת�����ڶ���
        Date birthdayDate = sdf.parse(birthdayString);

// ��ȡ��������ڶ���
        Date todayDate = new Date();
// ����������birthdayDate,todayDateת�ɺ���ֵ,Date��ķ���getTime
        long birthdaySecond = birthdayDate.getTime();
        long todaySecond = todayDate.getTime();

        long second = todaySecond-birthdaySecond;
        if (second < 0){
            System.out.println("��û������");
        } else {
            System.out.println(second/1000/60/60/24);
        }
    }

    public static void main(String[] args) {
        /*try..catch����Ƕ�ڷ�����ȥ�����쳣;*/
        try {
            DemoParse.function();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}