package study.collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
//���Ԫ��
        /*ͷ�巨���Ԫ��:*/
        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("eee");
        System.out.println("��ʼ�����б�:"+link);
// ��ȡԪ��
        System.out.println("��ͷԪ��"+link.getFirst());
        System.out.println("��βԪ��"+link.getLast());
// ɾ��Ԫ��
        System.out.println("ɾ����ͷ"+link.removeFirst());
        System.out.println("ɾ����β"+link.removeLast());
        while (!link.isEmpty()) { //�жϼ����Ƿ�Ϊ��
            System.out.println("���������е�ջ��Ԫ��"+link.pop()); //���������е�ջ��(����ͷ)Ԫ��
        }
        //System.out.println(link);
    }
}
