package study.genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo2{
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();//������ȷ����ΪString
        coll.add("abc");
        coll.add("zjgsu");
        //coll.add(5);//��������ȷ���ͺ󣬴�����Ͳ�һ�¾ͻ���뱨��
// �����Ѿ���ȷ�����ŵ�Ԫ�����ͣ���ô��ʹ�õ�������ʱ��
// ������Ҳͬ����֪���������Ԫ������
        Iterator it = coll.iterator();//Iterator ������<����>Ҳ����;�����Ҫָ���Ļ�Ҳֻ��ָ��ΪString,��coll���Ԫ��������ƥ��;
        Iterator<String> ite=coll.iterator();
        while (ite.hasNext()) {
//��Ҫ��ӡÿ���ַ����ĳ���,��Ҫ�ѵ��������Ķ���ת��String����
            String str = (String) ite.next();
//��ʹ��Iterator<String>����Ԫ�����ͺ󣬾Ͳ���Ҫǿת�ˡ���ȡ����Ԫ��ֱ�Ӿ���String����
            System.out.println(str);
        }
    }
}
