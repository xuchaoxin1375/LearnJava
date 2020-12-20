package study.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*两个日期的大小比较方式，现在整理一下几种方法。
  例子：


另附日期和string的互转方法：
1  Date转String
Date d=new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String ds=df.format(d);
2 String转Date
String ds=new String("2017-06-09 10:22:22");
Date sd=df.parse(ds);
*/
public class CompareData {
    public static void main(String[] args) {
        String beginTime=new String("2017-06-09 10:22:22");
        String endTime=new String("2017-05-08 11:22:22");
        //1  直接用Date自带方法before()和after()比较
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
        System.out.println("方法1:");
        System.out.println(sd1.before(sd2)+"返回true说明sd1早于sd2,否则反之");
        //System.out.println(sd1.after(sd2));
       // 2  用String的compareTo()方法：
        Integer i=beginTime.compareTo(endTime);
        System.out.println("方法2:\n"+i+" 返回正值是代表左侧日期大于参数日期，反之亦然，日期格式必须一致.");
        //返回正值是代表左侧日期大于参数日期，反之亦然，日期格式必须一致
        //3  转成date格式换成秒数比较秒数大小，getTime()方法

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
        System.out.println((long1>long2) +" 返回true为前者大(晚)");
    }
}
