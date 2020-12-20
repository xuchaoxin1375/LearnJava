package study.equals;

import java.util.ArrayList;
import java.util.List;

public class equal1 {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        /*contains()方法
        * 我们传入的是new String("C")，所以一定是不同的实例。
        * 结果仍然符合预期，这是为什么呢？因为List内部并不是通过==判断两个元素是否相等(这样的话是比较两个实例的地址)
        * ，而是使用equals()方法判断(比较的是实例的内容)两个元素是否相等，*/
        System.out.println(list.contains(new String("C"))); // true
        System.out.println(list.indexOf(new String("C"))); // 2
        ArrayList sc=new ArrayList();/*ArrayList 是一个泛型类*/
    }
}
