package study.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
//����List���϶���
        List<String> list = new ArrayList<String>();
// ��β�����ָ��Ԫ��
        list.add("С��");
        list.add("С��");
        list.add("С��");
        System.out.println("list��ʼ����:"+list);
// add(int index,String s) ��ָ��λ�����(add���ǲ���(insert)��);
        list.add(1, "С��");
        System.out.println("����Ч��:"+list);
// String remove(int index) ɾ��ָ��λ��Ԫ�ط��ر�ɾ��Ԫ��
// ɾ������λ��Ϊ2��Ԫ��
        System.out.println("ɾ������λ��Ϊ2��Ԫ��");
        System.out.println(list.remove(2)+"��ɾ��");
        System.out.println("ɾ��Ч��:"+list);
        //String set(int index, String s);// ��ָ��λ�� ���� Ԫ��������ģ�(����)]// �޸�ָ��λ��Ԫ��
        list.set(0,"��ë");
        System.out.println("�޸�/���ǵ�Ч��:"+list);
// String get(int index) ��ȡָ��λ��Ԫ��
// ��size() ������ȡ������������list
        System.out.println("��size() ������ȡ������������list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//������ʹ����ǿfor
        System.out.println("������ʹ����ǿfor����:");
        for (String string : list) {
            System.out.println(string);
        }

    }

}