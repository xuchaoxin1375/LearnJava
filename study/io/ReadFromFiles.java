package study.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.*;

public class ReadFromFiles {

    public static void main(String[] args){
        try{
            LineNumberReader file=new LineNumberReader(new FileReader("E:\\JAVA\\File_NumberSort\\num.txt"));
            //读取文件
            String s;
            ArrayList list=new ArrayList();
            for(s=file.readLine();s!=null;s=file.readLine()){
                //System.out.println(s);
                list.add(s);//文件内容增加到数组中
            }
            file.close();
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return new Double((String) o1).compareTo(new Double((String) o2));
                }
            });//字符串的排序

            BufferedWriter bw=new BufferedWriter(new FileWriter("num_sort.txt"));//写文件
            bw.write("排序后：");
            for(Iterator i=list.iterator();i.hasNext();)
            {
                //System.out.println(i.next());
                bw.write(i.next().toString());
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e){
            System.err.println("发生异常："+e);
            e.printStackTrace();
        }
    }
}
