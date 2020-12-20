package study.comparator;
/*ʹ��java.util.Comparator��һ���ô��ǲ���Ҫ�ñ���������������implements java.lang public �ӿ� Comparable<T>,������Ҫ�ڶ�������ʵ��Comparable�ӿ��е�compareTo()����.���Ӧ��comparator�ӿ��е�compare()��������д;
* ��Ȼ,ʹ��ComparatorҲ��implements java.util @FunctionalInterface public �ӿ� Comparator<T>,һ�����public class��
* ��Ȼ��������lambada���ʽ�Ľ�����������д��,��ʮ�ּ�����
*��ϲ������: https://blog.csdn.net/xuchaoxin1375/article/details/109536666*/
/*ͨ��ʵ��comparable<>�е�compareTo����,�ڵ���Collections.sort()����ֻ��Ҫ����lst��һ����������ļ��ϼ���(
        ��Ҳ����û��ʵ��comparator�ӿڵıȽ�������ʱĬ�ϵ��õķ���(comparable<>�е�comparaTo����)*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(8);
        lst.add(-2);
        lst.add(5);
        System.out.println(lst);
/*Comparator<>�ӿ��е�compare()Ҳ��һ�����ͳ��󷽷�(����):public interface Comparator<T>{..;int compare(T o1, T o2);  boolean equals(Object obj);(���������󷽷�)��һ������ʵ�ֹ�����Object�������Ѿ�������ôһ��equals()������ʵ����;��Ȼ���������obecetֻ�в����е�,�ǻ��ǵ�ȫ��������д..}*/
        Collections.sort(lst, new Comparator<Integer>() {
            //��д�ȽϹ���
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println("����������:"+lst);
        ArrayList<Star2> lst2 = new ArrayList<>();
        lst2.add(new Star2("llj", 28));
        lst2.add(new Star2("zzd", 24));
        lst2.add(new Star2("zwz", 24));
        /*lst2.add(new Star("����", 45));
        lst2.add(new Star("������", 24));*/
        lst2.add(new Star2("ylq", 25));
        lst2.add(new Star2("cl", 20));
        System.out.println(lst2);
        Collections.sort(lst2, new Comparator<Star2>() {
                    @Override
                    public int compare(Star2 o1, Star2 o2) {
//�����併������
                        int result = o2.getAge() - o1.getAge();
//���������ͬ�����������ĵ�һ������������
                        /*java.lang.String @Contract(pure = true)
public char charAt(@Range(from = 0, to = Integer.MAX_VALUE) int index)
Returns the char value at the specified index. An index ranges from 0 to length() - 1.
 The first char value of the sequence is at index 0, the next at index 1, and so on, as for array indexing.*/
                        if (result == 0) {
                            result = o1.getName().charAt(0) -
                                    o2.getName().charAt(0);
                        }
                        return result;
                    }
                }

        );

        System.out.println("ָ���������:���併��+�������ַ�������:"+lst2);

    }

}

class Star {
    private String name;
    private int age;

    public Star(String name, int age) {
        this.name = name;
        this.age = age;

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

    public String toString() {
        return "{"+ "age="+age+ " name=" + name+"}" ;
    }

}