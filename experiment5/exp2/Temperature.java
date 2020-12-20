package experiment5.exp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*�в�ͬ��ݵ��¶�����temperature.txt��Ҫ�����ڰ����������¶Ȱ����� ���¶��������г�����(ע��������,�ղ����ڱȽ�)
*�Ƚ����ڲ鿴:https://blog.csdn.net/xuchaoxin1375/article/details/109540645
* File file = new File("weather.txt");
Scanner scanner = new Scanner(file);
*/
public class Temperature {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        String s;
        File file = new File("D:\\OneDrive\\Java\\ProjectCodeInIDEA\\src\\experiment5\\exp2\\weather.txt");
        try {
            Scanner scanner = new Scanner(file);//��ȡ����
            //���岿��:
            /*����nextLine()����    :
            * ����:the line that was skipped
������ �׳�:
java.util.NoSuchElementException �C if no line was found
IllegalStateException �C if this scanner is closed*/
            for(s=scanner.nextLine();scanner.hasNextLine();s=scanner.nextLine()){
                list.add(s);//���ܳ��������й����г���,�����ܹ�ִ�еĲ��ֻ���ִ����
            }/*����,�ɹ��������ݵ�list��*/
            /*���濪ʼ�������ͱȽϴ���*/
            Comparator<String> comparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    /*��compareTo()�Ƚ���Ҫע�����ڵĸ�ʽҪ��.*/
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
            /*�����ӡЧ��*/
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");/*string_date_format*/
            for(String x:list){
                try {
                    Date sd=sdf.parse(x.substring(0,19));/*����sdf���ڸ�ʽ����������parse()����������ڵ��ַ���,����һ�����ڶ���sd(string->date)*/
                   // System.out.println(x.substring(0, 10)+" "+x.substring(20, 22)+".0");
                    System.out.println(sdf.format(sd)+"\t"+x.substring(20, 22)+".0");/*�������ڸ�ʽ����sdf��format()����(�÷����᷵��һ���ַ���)����ʽ�����ڶ���sd*/
                    /*java.text.DateFormat @NotNull
                    public final String format(java.util.Date date)
                    ����:
                    date �C the time value to be formatted into a date-time string.
                    ����:
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
