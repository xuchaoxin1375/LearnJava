package study.genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("abc");
        coll.add("zjgsu");
        coll.add(5);//���ڼ���û�����κ��޶����κ����Ͷ����Ը����д��
        Iterator it = coll.iterator();
        while (it.hasNext()) {
//��Ҫ��ӡÿ���ַ����ĳ���,��Ҫ�ѵ��������Ķ���ת��String����
            String str = (String) it.next();/*�ڴ��������Ԫ��(��������5),���ܹ�ת��ΪString;������java.lang.ClassCastException*/
            System.out.println(str+":"+str.length());
        }
    }
}
/*Exception(����/����;expectation) in thread "main" java.lang.ClassCastException:
class java.lang.Integer (cannot be cast to class java.lang.String����ת������java.lang.String��;cast����;Ͷ��)  (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')	at experiment4.study.GenericDemo.main(GenericDemo.java:16)*/
