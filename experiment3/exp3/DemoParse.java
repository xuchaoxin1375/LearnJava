package experiment3.exp3;

/*
        Date类
        使用日期时间相关的API，计算出一个人已经出生了多少
        天?
        思路：
        1.获取当前时间对应的毫秒值
        2.获取自己出生日期对应的毫秒值
        3.两个时间相减（当前时间– 出生日期）
*/

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class DemoParse {
    public static void function() throws Exception {

        System.out.println("请输入出生日期 格式 YYYY-MM-dd：");

// 获取出生日期,键盘输入
        String birthdayString = new Scanner(System.in).next();

// 将字符串日期,转成Date对象
// 创建SimpleDateFormat对象,写日期模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// 调用方法parse,字符串转成日期对象
        Date birthdayDate = sdf.parse(birthdayString);

// 获取今天的日期对象
        Date todayDate = new Date();
// 将两个日期birthdayDate,todayDate转成毫秒值,Date类的方法getTime
        long birthdaySecond = birthdayDate.getTime();
        long todaySecond = todayDate.getTime();

        long second = todaySecond-birthdaySecond;
        if (second < 0){
            System.out.println("还没出生呢");
        } else {
            System.out.println(second/1000/60/60/24);
        }
    }

    public static void main(String[] args) {
        /*try..catch机制嵌在方法里去捕获异常;*/
        try {
            DemoParse.function();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}