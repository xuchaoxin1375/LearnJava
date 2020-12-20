package study.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample2 {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(8);
        lst.add(-12);
        lst.add(5);
        System.out.println("����ǰ��"+ lst);
        /*������ֵ����:*/
        Collections.sort(lst, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2)-Math.abs(o1);
            }
        });
        System.out.println("������ֵ��С����"+lst);

        ArrayList<Star2> lst2 = new ArrayList<>();
        lst2.add(new Star2("������", 22));
        lst2.add(new Star2("���ӵ�", 24));
        lst2.add(new Star2("����׿", 22));
        lst2.add(new Star2("����", 45));
        lst2.add(new Star2("������", 24));
        System.out.println("����ǰ:"+lst2);
//�Ȱ����䣬�ٰ������ĵ�һ��������
        Collections.sort(lst2);/*ͨ��ʵ��comparable<>�е�compareTo����,�ڵ���Collections.sort()����ֻ��Ҫ����lst��һ����������ļ��ϼ���(
        ��Ҳ����û��ʵ��comparator�ӿڵıȽ�������ʱĬ�ϵ��õķ���(comparable<>�е�comparaTo����)*/
        System.out.println("�����"+lst2);
    }
}
/*java.lang public �ӿ� Comparable<T>*/
class Star2 implements Comparable<Star2>{
    private String name;
    private int age;

    public Star2(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "����{"+"������"+name+","+"���䣺"+age+"}";
}

    @Override
    public int compareTo(Star2 o) {
//�����併����
        int i = o.getAge() - this.getAge();
//���������ͬ�������ĵ�һ����������
        if (i==0){
            i=this.getName().charAt(0)-
                    o.getName().charAt(0);
        }

        return i;

    }

}