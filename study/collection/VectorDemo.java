package study.collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        /*Vector����������<>����,������������������ָ��Vector��������Ԫ�ص�����;*/
        Vector strs = new Vector(10, 10);
        /*Vector�༸����ArrayList��һ��(������,��������ǲ��ò�������)*/
        strs.add("str1");
        strs.add("str2");
        strs.add("str3");
        strs.add("str4");
        strs.add("str5");
        System.out.println(strs.toString());
        String str = (String) strs.elementAt(0);
        strs.set(2, "new str2");
        strs.remove("str4");
        Iterator<String> it = strs.iterator();
        while (it.hasNext())
            System.out.print(it.next() + "  ");

    }

}
