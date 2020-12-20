/*
计算一个人从出生日期开始到他参加高考的时间间隔有多少天（假设是18岁参加高考）
* */
package experiment3.exp3;
/*算法:Nceeday-Today*/
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Ncee {
    public static void function() throws Exception {

        System.out.println("请输入出生日期 格式 YYYY-MM-dd：");

// 获取出生日期,键盘输入
        String birthdayString = new Scanner(System.in).next();

        /*截取年份:*/
        String year=birthdayString.substring(0,4);
        String partOfAfterYear=birthdayString.substring(4,birthdayString.length());
        int yearInt=Integer.parseInt(year);
        int yearNcee=yearInt+18;
       // System.out.println("yearInt="+yearInt);
        //System.out.println("partOfAfterYear="+partOfAfterYear);
        String NceedayString=yearNcee+"-06-07";
       // System.out.println(NceedayString);
// 将字符串日期,转成Date对象
// 创建SimpleDateFormat对象,写日期模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// 调用方法parse,字符串转成日期对象
        Date NceedayDate = sdf.parse(NceedayString);

// 获取今天的日期对象
        Date todayDate = new Date();

// 将两个日期NceedayDate,todayDate转成毫秒值,Date类的方法getTime
        long NceedaySecond = NceedayDate.getTime();
        long todaySecond = todayDate.getTime();

        long second = NceedaySecond-todaySecond;
        if (second < 0){
            System.out.println("还没出生呢");
        } else {
//            System.out.println();
            System.out.println("离高考还有"+second/1000/60/60/24+"天");
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
