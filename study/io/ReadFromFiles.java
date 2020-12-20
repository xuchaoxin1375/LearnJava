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
            //��ȡ�ļ�
            String s;
            ArrayList list=new ArrayList();
            for(s=file.readLine();s!=null;s=file.readLine()){
                //System.out.println(s);
                list.add(s);//�ļ��������ӵ�������
            }
            file.close();
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return new Double((String) o1).compareTo(new Double((String) o2));
                }
            });//�ַ���������

            BufferedWriter bw=new BufferedWriter(new FileWriter("num_sort.txt"));//д�ļ�
            bw.write("�����");
            for(Iterator i=list.iterator();i.hasNext();)
            {
                //System.out.println(i.next());
                bw.write(i.next().toString());
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e){
            System.err.println("�����쳣��"+e);
            e.printStackTrace();
        }
    }
}
