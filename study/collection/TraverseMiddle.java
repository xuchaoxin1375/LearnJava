package study.collection;
/*���ʹ�õ�����Iterator������List
Iterator����Ҳ��һ���࣬������ʵ������������List��ʵ������iterator()������ʱ�򴴽��Ķ���Iterator(���)����֪����α���һ��List�����Ҳ�ͬ��List���ͣ����ص�Iterator����ʵ��Ҳ�ǲ�ͬ�ģ������Ǿ�����ߵķ���Ч�ʡ�

Iterator����������������boolean hasNext()�ж��Ƿ�����һ��Ԫ�أ�E next()������һ��Ԫ�ء���ˣ�ʹ��Iterator����List�������£�*/

import java.util.Iterator;
import java.util.List;

/*Control+r , r  */
public class TraverseMiddle {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        /*An iterator over a collection�����ϵĵ�����
        * java.util public interface Iterator<E>(����һ��������,��־λ<E>)
        *   �Ա�String��:
        *   java.lang
        *   public final class String
        *   String�Ͳ���һ��������
        */
        /*��������Ҫһ��String�ĵ�����:Iterator<String>
        * Iterator<String> it = list.iterator();ʵ����������Ҫ�ĵ���������it;
        * ��it���������еķ������������:
        * public abstract boolean hasNext()
            Returns true if the iteration has more elements;
            * �����������hasNext()��������������Ϊѭ���ĳ��������ж�
            * java.util.List<E>
            public abstract java.util.Iterator<E> iterator()
Returns an iterator over <the elements in this list> (in proper sequence).
* ����ȷ��˳�򷵻ش��б���Ԫ�صĵ��������ֶ���ȡ���������б�������*/
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {//���ʱ���for���˻�Ϊwhile��)
            String s = it.next();/*next()����������һ��Ԫ��public abstract E next(); Returns the next element in the iteration.*/
            System.out.println(s);
        }
    }
}





