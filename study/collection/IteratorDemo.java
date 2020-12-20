package study.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;//导入迭代器接口

public class IteratorDemo {
    public static void main(String[] args) {
//使用多态方式创建对象
        Collection<String> coll=new ArrayList<String>();

//添加元素到集合
        coll.add("隔壁老王");
        coll.add("隔壁老李");
        coll.add("隔壁小李");
        coll.add("隔壁小赵");

//遍历，使用迭代器，每个集合对象都有自己的迭代器
        Iterator<String> it=coll.iterator();
/*java.util.Collection<E>
public abstract java.util.Iterator<E> iterator()
Returns an iterator over the elements in this collection. There are no guarantees concerning the order in which the elements are returned (unless this collection is an instance of some class that provides a guarantee).*/

//泛型指的是迭代出的元素的数据类型
        while (it.hasNext()){ //判断是否有迭代元素
            String s=it.next(); //获取迭代出的元素
            System.out.println(s);

        }

    }

}
