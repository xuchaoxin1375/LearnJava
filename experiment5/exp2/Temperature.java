package experiment5.exp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*有不同年份的温度数据temperature.txt，要求日期按年月升序、温度按降序 将温度数据排列出来。(注意是年月,日不参于比较)
*比较日期查看:https://blog.csdn.net/xuchaoxin1375/article/details/109540645
* File file = new File("weather.txt");
Scanner scanner = new Scanner(file);
*/
public class Temperature {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        String s;
        File file = new File("D:\\OneDrive\\Java\\ProjectCodeInIDEA\\src\\experiment5\\exp2\\weather.txt");
        try {
            Scanner scanner = new Scanner(file);//读取数据
            //主体部分:
            /*对于nextLine()方法    :
            * 返回:the line that was skipped
遇错误 抛出:
java.util.NoSuchElementException – if no line was found
IllegalStateException – if this scanner is closed*/
            for(s=scanner.nextLine();scanner.hasNextLine();s=scanner.nextLine()){
                list.add(s);//尽管程序在运行过程中出错,但是能够执行的部分还是执行了
            }/*至此,成功读入数据到list中*/
            /*下面开始做解析和比较处理*/
            Comparator<String> comparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    /*用compareTo()比较需要注意日期的格式要求.*/
                    int ret=(o1.substring(0, 7)+"-00").compareTo(o2.substring(0, 7)+"-00");
                    if(ret==0){
                        return Integer.parseInt(o2.substring(20, 22))-Integer.parseInt(o1.substring(20, 22));
                    }
                    return ret;
                }

             /*   @Override
                public boolean equals(Object obj) {
                    return false;
                }*/
            };
            Collections.sort(list,comparator);
            /*处理打印效果*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");/*string_date_format*/
            for(String x:list){
                try {
                    Date sd=sdf.parse(x.substring(0,19));/*根据sdf日期格式对象来调用parse()解析表达日期的字符串,返回一个日期对象sd(string->date)*/
                   // System.out.println(x.substring(0, 10)+" "+x.substring(20, 22)+".0");
                    System.out.println(sdf.format(sd)+"\t"+x.substring(20, 22)+".0");/*调用日期格式对象sdf的format()方法(该方法会返回一个字符串)来格式化日期对象sd*/
                    /*java.text.DateFormat @NotNull
                    public final String format(java.util.Date date)
                    参数:
                    date – the time value to be formatted into a date-time string.
                    返回:
                    the formatted date-time string.
*/
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
