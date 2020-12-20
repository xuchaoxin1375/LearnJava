package experiment3.exp3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Demo {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = "2019年10月11日";
        Date date = df.parse(str);
        System.out.println(date); // Fri Oct 11 00:00:00 CST 2019
    }
}
