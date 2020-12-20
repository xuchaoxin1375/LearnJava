package study.comparator;
/*使用java.util.Comparator的一个好处是不需要让被排序对象的类额外的implements java.lang public 接口 Comparable<T>,即还需要在对象类中实现Comparable接口中的compareTo()方法.这对应于comparator接口中的compare()方法的重写;
* 当然,使用Comparator也得implements java.util @FunctionalInterface public 接口 Comparator<T>,一般加载public class下
* 当然还可以用lambada表达式改进匿名函数的写法,是十分简练的
*配合博客理解: https://blog.csdn.net/xuchaoxin1375/article/details/109536666*/
/*通过实现comparable<>中的compareTo方法,在调用Collections.sort()方法只需要传入lst这一个待被排序的集合即可(
        这也是在没有实现comparator接口的比较器对象时默认调用的方法(comparable<>中的comparaTo方法)*/
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
/*Comparator<>接口中的compare()也是一个泛型抽象方法(声明):public interface Comparator<T>{..;int compare(T o1, T o2);  boolean equals(Object obj);(共两个抽象方法)另一个抽象法实现估计是Object根类中已经有了这么一个equals()方法的实现了;当然如果是其他obecet只中不具有的,那还是的全部亲自重写..}*/
        Collections.sort(lst, new Comparator<Integer>() {
            //重写比较规则
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println("降序排类结果:"+lst);
        ArrayList<Star2> lst2 = new ArrayList<>();
        lst2.add(new Star2("llj", 28));
        lst2.add(new Star2("zzd", 24));
        lst2.add(new Star2("zwz", 24));
        /*lst2.add(new Star("成龙", 45));
        lst2.add(new Star("杨丽青", 24));*/
        lst2.add(new Star2("ylq", 25));
        lst2.add(new Star2("cl", 20));
        System.out.println(lst2);
        Collections.sort(lst2, new Comparator<Star2>() {
                    @Override
                    public int compare(Star2 o1, Star2 o2) {
//按年龄降序排序
                        int result = o2.getAge() - o1.getAge();
//如果年龄相同，再用姓名的第一个字升序排列
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

        System.out.println("指定排序规则:年龄降序+姓名首字符升序结果:"+lst2);

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