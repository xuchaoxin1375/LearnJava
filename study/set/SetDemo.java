package study.set;

import java.util.HashSet;
import java.util.Set;
/*集合Set不是随便就能用的(尤其是在处理自定义类型的对象的时候,务必要编写
合适的equals方法和hashCode方法(好在用IDEA可以快速自动生成),Set是基于HashMap实现的一种集合,所以需要这两个函数重写
当然处理String这样对对象就不需要手动编写那两个方法啦*/
public class SetDemo {
    public static void main(String[] args) {
        java.util.Set<String> set = new HashSet<>();
        System.out.println(set.add("abc")); // true
        System.out.println(set.add("xyz")); // true

        System.out.println(set.add("xyz")); // false，添加失败，因为元素已存在

        System.out.println(set.contains("xyz")); // true，元素存在
        System.out.println(set.contains("XYZ")); // false，元素不存在
        System.out.println(set.remove("hello")); // false，删除失败，因为元素不存在
        System.out.println(set.size()); // 2，一共两个元素
        String []testStr={"1","str2"};
        System.out.println(testStr);
       /*
       Object testCast=(Object)testStr;
        int a=0;
        Object test2=(Object)a;
        System.out.println(testCast);*/

        /*collections下的集合的大小用.size()方法返回;
        * 普通(大小不可变的)数组的大小记录在length成员变量中;*/
    }
}
