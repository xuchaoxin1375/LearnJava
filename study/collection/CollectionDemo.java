package study.collection;
import java.util.LinkedList;/*ͬ����implements java.util.Link*/
import java.util.ArrayList;/*(��������ʵ�ֵ��б���)implements java.util.List->extends java.util.Collection->extends Iterable*/
import java.util.Collection;/*The root interface in the collection hierarchy n.[?ha??r��?ki]�� [?ha??r��?rki] �㼶���ȼ��ƶ�.
Collecton����үү�������*/

public class CollectionDemo {

    public static void main(String[] args) {
//�������϶���
//ʹ�ö�̬��ʽ
        Collection<String> coll=new ArrayList<String>();
// ���Ԫ��
        coll.add("С���");
        coll.add("ɨ��ɮ");
        coll.add("ʯ����");
        System.out.println(coll); //[С���, ɨ��ɮ, ʯ����]

//boolean contains(E e) �ж�o�Ƿ��ڼ����д���
        System.out.println("�ж� ɨ��ɮ �Ƿ��ڼ�����: "+coll.contains("ɨ��ɮ"));
// �ж� ɨ��ɮ �Ƿ��ڼ�����: true

//boolean remove(E e) ɾ�������е�eԪ��
                System.out.println("ɾ��ʯ���죺"+coll.remove("ʯ����"));
// ɾ��ʯ���죺true
                        System.out.println("ɾ���󼯺��е�Ԫ�أ�"+coll);
// ɾ���󼯺��е�Ԫ�أ�[С���, ɨ��ɮ]
//void clear() ��ռ���
                                coll.clear();
        System.out.println("������Ԫ��Ϊ��"+coll);
// ������Ԫ��Ϊ��[]

// boolean isEmpty() �ж��Ƿ�Ϊ��
        System.out.println(coll.isEmpty());
// true

    }

}
