package study.collections;

import java.util.ArrayList;
import java.util.Collections;
/*
Collection��Collections��ʲô����
Collection�Ǽ�����ϵ����㣬�����˼�����ϵ�Ĺ���(java.lang.Collection ����Ҫ����);
Collections��һ�������࣬�����������ڲ���Collection(java.util.Collections ��Ҫ����*/
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

//���ù�������������������Ԫ��
        Collections.addAll(lst,111,222,333,7,5,88);
        System.out.println(lst);

        Collections.sort(lst);
        System.out.println(lst);

    }
}
