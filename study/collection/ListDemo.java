package study.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
//创建List集合对象
        List<String> list = new ArrayList<String>();
// 往尾部添加指定元素
        list.add("小李");
        list.add("小王");
        list.add("小张");
        System.out.println("list初始内容:"+list);
// add(int index,String s) 往指定位置添加(add就是插入(insert)啦);
        list.add(1, "小赵");
        System.out.println("插入效果:"+list);
// String remove(int index) 删除指定位置元素返回被删除元素
// 删除索引位置为2的元素
        System.out.println("删除索引位置为2的元素");
        System.out.println(list.remove(2)+"被删除");
        System.out.println("删除效果:"+list);
        //String set(int index, String s);// 在指定位置 进行 元素替代（改）(覆盖)]// 修改指定位置元素
        list.set(0,"三毛");
        System.out.println("修改/覆盖的效果:"+list);
// String get(int index) 获取指定位置元素
// 用size() 方法获取长度来遍历的list
        System.out.println("用size() 方法获取长度来遍历的list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
//还可以使用增强for
        System.out.println("还可以使用增强for遍历:");
        for (String string : list) {
            System.out.println(string);
        }

    }

}