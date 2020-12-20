package study.genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("zjgsu");
        coll.add(5);//由于集合没有做任何限定，任何类型都可以给其中存放
        Iterator it = coll.iterator();
        while (it.hasNext()) {
//需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
            String str = (String) it.next();/*在处理第三个元素(是整形数5),不能够转换为String;会引发java.lang.ClassCastException*/
            System.out.println(str+":"+str.length());
        }
    }
}
/*Exception(意外/例外;expectation) in thread "main" java.lang.ClassCastException:
class java.lang.Integer (cannot be cast to class java.lang.String不能转换到类java.lang.String中;cast计算;投射)  (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')	at experiment4.study.GenericDemo.main(GenericDemo.java:16)*/
