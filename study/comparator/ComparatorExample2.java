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
        System.out.println("排序前："+ lst);
        /*按绝对值排序:*/
        Collections.sort(lst, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2)-Math.abs(o1);
            }
        });
        System.out.println("按绝对值大小排序："+lst);

        ArrayList<Star2> lst2 = new ArrayList<>();
        lst2.add(new Star2("李连杰", 22));
        lst2.add(new Star2("甄子丹", 24));
        lst2.add(new Star2("赵文卓", 22));
        lst2.add(new Star2("成龙", 45));
        lst2.add(new Star2("杨丽青", 24));
        System.out.println("排序前:"+lst2);
//先按年龄，再按姓名的第一个字排序
        Collections.sort(lst2);/*通过实现comparable<>中的compareTo方法,在调用Collections.sort()方法只需要传入lst这一个待被排序的集合即可(
        这也是在没有实现comparator接口的比较器对象时默认调用的方法(comparable<>中的comparaTo方法)*/
        System.out.println("排序后："+lst2);
    }
}
/*java.lang public 接口 Comparable<T>*/
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
        return "明星{"+"姓名："+name+","+"年龄："+age+"}";
}

    @Override
    public int compareTo(Star2 o) {
//按年龄降序排
        int i = o.getAge() - this.getAge();
//如果年龄相同按姓名的第一个字升序排
        if (i==0){
            i=this.getName().charAt(0)-
                    o.getName().charAt(0);
        }

        return i;

    }

}