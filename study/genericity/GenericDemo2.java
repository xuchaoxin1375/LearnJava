package study.genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo2{
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();//集合明确类型为String
        coll.add("abc");
        coll.add("zjgsu");
        //coll.add(5);//当集合明确类型后，存放类型不一致就会编译报错
// 集合已经明确具体存放的元素类型，那么在使用迭代器的时候，
// 迭代器也同样会知道具体遍历元素类型
        Iterator it = coll.iterator();//Iterator 不传入<参数>也可行;而如果要指定的话也只能指定为String,和coll里的元素类型相匹配;
        Iterator<String> ite=coll.iterator();
        while (ite.hasNext()) {
//需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
            String str = (String) ite.next();
//当使用Iterator<String>控制元素类型后，就不需要强转了。获取到的元素直接就是String类型
            System.out.println(str);
        }
    }
}
