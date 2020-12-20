package study.set;

import java.util.HashSet;
import java.util.Set;
/*����Set�����������õ�(�������ڴ����Զ������͵Ķ����ʱ��,���Ҫ��д
���ʵ�equals������hashCode����(������IDEA���Կ����Զ�����),Set�ǻ���HashMapʵ�ֵ�һ�ּ���,������Ҫ������������д
��Ȼ����String�����Զ���Ͳ���Ҫ�ֶ���д������������*/
public class SetDemo {
    public static void main(String[] args) {
        java.util.Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true

        System.out.println(set.add("xyz")); // false�����ʧ�ܣ���ΪԪ���Ѵ���

        System.out.println(set.contains("xyz")); // true��Ԫ�ش���
        System.out.println(set.contains("XYZ")); // false��Ԫ�ز�����
        System.out.println(set.remove("hello")); // false��ɾ��ʧ�ܣ���ΪԪ�ز�����
        System.out.println(set.size()); // 2��һ������Ԫ��
        String []testStr={"1","str2"};
        System.out.println(testStr);
       /*
       Object testCast=(Object)testStr;
        int a=0;
        Object test2=(Object)a;
        System.out.println(testCast);*/

        /*collections�µļ��ϵĴ�С��.size()��������;
        * ��ͨ(��С���ɱ��)����Ĵ�С��¼��length��Ա������;*/
    }
}
