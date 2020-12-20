package study.collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        /*Vector不用像泛型类<>那样,定义对象对象是往往不指定Vector容器里面元素的类型;*/
        Vector strs = new Vector(10, 10);
        /*Vector类几乎和ArrayList类一样(就是慢,定义对象是不用参数类型)*/
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
