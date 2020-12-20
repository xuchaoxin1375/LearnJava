package study.collections;

import java.util.ArrayList;
import java.util.Collections;
/*
Collection和Collections有什么区别？
Collection是集合体系的最顶层，包含了集合体系的共性(java.lang.Collection 不需要导入);
Collections是一个工具类，方法都是用于操作Collection(java.util.Collections 需要导入*/
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

//采用工具类完成往集合中添加元素
        Collections.addAll(lst,111,222,333,7,5,88);
        System.out.println(lst);

        Collections.sort(lst);
        System.out.println(lst);

    }
}
