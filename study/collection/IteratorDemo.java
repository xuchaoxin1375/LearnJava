package study.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;//����������ӿ�

public class IteratorDemo {
    public static void main(String[] args) {
//ʹ�ö�̬��ʽ��������
        Collection<String> coll=new ArrayList<String>();

//���Ԫ�ص�����
        coll.add("��������");
        coll.add("��������");
        coll.add("����С��");
        coll.add("����С��");

//������ʹ�õ�������ÿ�����϶������Լ��ĵ�����
        Iterator<String> it=coll.iterator();
/*java.util.Collection<E>
public abstract java.util.Iterator<E> iterator()
Returns an iterator over the elements in this collection. There are no guarantees concerning the order in which the elements are returned (unless this collection is an instance of some class that provides a guarantee).*/

//����ָ���ǵ�������Ԫ�ص���������
        while (it.hasNext()){ //�ж��Ƿ��е���Ԫ��
            String s=it.next(); //��ȡ��������Ԫ��
            System.out.println(s);

        }

    }

}
