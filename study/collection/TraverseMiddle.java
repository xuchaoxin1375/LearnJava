package study.collection;
/*坚持使用迭代器Iterator来访问List
Iterator本身也是一中类，但它的实例化对象是由List的实例调用iterator()方法的时候创建的对象。Iterator(类的)对象知道如何遍历一个List，并且不同的List类型，返回的Iterator对象实现也是不同的，但总是具有最高的访问效率。

Iterator对象有两个方法：boolean hasNext()判断是否有下一个元素，E next()返回下一个元素。因此，使用Iterator遍历List代码如下：*/

import java.util.Iterator;
import java.util.List;

/*Control+r , r  */
public class TraverseMiddle {

    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        /*An iterator over a collection集合上的迭代器
        * java.util public interface Iterator<E>(这是一个泛型类,标志位<E>)
        *   对比String类:
        *   java.lang
        *   public final class String
        *   String就不是一个泛型类
        */
        /*这里你需要一个String的迭代器:Iterator<String>
        * Iterator<String> it = list.iterator();实例化出了需要的迭代器对象it;
        * 用it对象所具有的方法来处理遍历:
        * public abstract boolean hasNext()
            Returns true if the iteration has more elements;
            * 迭代器对象的hasNext()方法可以用来作为循环的出口条件判断
            * java.util.List<E>
            public abstract java.util.Iterator<E> iterator()
Returns an iterator over <the elements in this list> (in proper sequence).
* 以正确的顺序返回此列表中元素的迭代器。手动获取迭代器进行遍历集合*/
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {//这个时候的for就退化为while了)
            String s = it.next();/*next()方法访问下一个元素public abstract E next(); Returns the next element in the iteration.*/
            System.out.println(s);
        }
    }
}





