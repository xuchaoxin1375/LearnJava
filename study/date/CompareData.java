package study.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*�������ڵĴ�С�ȽϷ�ʽ����������һ�¼��ַ�����
  ���ӣ�


�����ں�string�Ļ�ת������
1  DateתString
Date d=new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String ds=df.format(d);
2 StringתDate
String ds=new String("2017-06-09 10:22:22");
Date sd=df.parse(ds);
*/
public class CompareData {
    public static void main(String[] args) {
        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-05-08 11:22:22");
        //1  ֱ����Date�Դ�����before()��after()�Ƚ�
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sd1= null;
        try {
            sd1 = df.parse(beginTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date sd2= null;
        try {
            sd2 = df.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("����1:");
        System.out.println(sd1.before(sd2)+"����true˵��sd1����sd2,����֮");
        //System.out.println(sd1.after(sd2));
       // 2  ��String��compareTo()������
        Integer i=beginTime.compareTo(endTime);
        System.out.println("����2:\n"+i+" ������ֵ�Ǵ���������ڴ��ڲ������ڣ���֮��Ȼ�����ڸ�ʽ����һ��.");
        //������ֵ�Ǵ���������ڴ��ڲ������ڣ���֮��Ȼ�����ڸ�ʽ����һ��
        //3  ת��date��ʽ���������Ƚ�������С��getTime()����

        try {
            sd1 = df.parse(beginTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            sd2 = df.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long long1 =sd1.getTime();
        long long2= sd2.getTime();
        System.out.println((long1>long2) +" ����trueΪǰ�ߴ�(��)");
    }
}
