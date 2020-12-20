package map_and_hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        ////
        String key1 = "a";
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 123);
/*通过new实例化一个不同于key1的新的字符串对象(尽管这个对象里内容是一样的)*/
        String key2 = new String("a");
        map.get(key2); // 123
        System.out.println(key1 == key2); // false
        /*而,在Map的内部，对key做比较是通过equals()实现的，这一点和List查找元素需要正确覆写equals()是一样的，即正确使用Map必须保证：作为key的对象必须正确覆写equals()方法。
        * 我们经常使用String作为key，因为String已经正确覆写了equals()方法。但如果我们放入的key是一个自己写的类，就必须保证正确覆写了equals()方法。
        * 我们再思考一下HashMap为什么能通过key直接计算出value存储的索引。相同的key对象（使用equals()判断时返回true）必须要计算出相同的索引，否则，相同的key每次取出的value就不一定对。
通过key计算索引的方式就是调用key对象的hashCode()方法，它返回一个int整数。HashMap正是通过这个方法直接定位key对应的value的索引，继而直接返回value。(当然,String类中已经实现了hashCode方法了:返回次字符串的hash码;而任何对象都有hashCode码方法(因为Object根类中就有hashCode()方法)
* 因此，正确使用Map必须保证：
1.作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
2.作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
    如果两个对象相等，则两个对象的hashCode()必须相等；
    如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
    即对应两个实例a和b：
如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。
上述第一条规范是正确性，必须保证实现，否则HashMap不能正常工作。
而第二条如果尽量满足，则可以保证查询效率，因为不同的对象，如果返回相同的hashCode()，会造成Map内部存储冲突，使存取的效率下降。

*/
        System.out.println(key1.equals(key2)); // true

        ///自定义类型作为key的类型
        Map<Person2,Integer> map2=new HashMap<>();
        //定义三个key的实例（令第三个实例和第一个实例在内容上相等）
        Person2 t1=new Person2("Xiao","rr",55),
        t2=new Person2("Xiao","Hong",66),
        t3=new Person2("Xiao", "rr", 55);
       // System.out.println("t1==t3:"+t1.equals(t3));
        //Object obj=new Object();obj.equals(5);//说明基本类型也可以传递个Object类（或许是先提升为Integer，然后在执行？）
        map2.put(t1 ,77);
        map2.put(t2 ,88);
        //map2.put(t3,879);

        System.out.println(map2.get(t1));/*map2.get("a")返回一个Person2类型的对象;然而为了打印出对象里的信息,应当重写toString方法*/
        System.out.println(map2.get(t2));
        System.out.println(map2.get(t3));//可以验证，在t3实例不放入map2映射中时，用t3也可以取得key为t1实例时所对应的value值（77）
        /*此外，就算我们插入的实例都时不一样的，我们，key类中的hashCode方法计算的hash值也任然有可能是一样的（作为key的实例相同的时候那肯定是相同的），总之两个key实例的hash
        * 相同，那么就会产生hash冲突，引发List的隐式创建来存储这些映射值。
        * 如果不重写eauals方法，那么使用t3就无法取得有t2映射的value值了;
        */
        //尝试更新某对key-value:
        map2.put(t3,314);
        System.out.println("用t3去影响t1所映射的value:" + map2.get(t1));//成功用t3去更新了t1->value;
        /*使用Map的时候，只要key不相同，它们映射的value就互不干扰。
但是，在HashMap内部，确实可能存在不同的key，映射到相同的hashCode()，即相同的数组索引上

假设情况:"a"和"b"这两个key最终计算出的索引都是 5，那么，在HashMap的数组中，实际存储的不是一个Person实例，而是一个List，它包含两个Entry，一个是"a"的映射，一个是"b"的映射：

┌───┐
0 │   │
  ├───┤
1 │   │
  ├───┤
2 │   │
  ├───┤
3 │   │
  ├───┤
4 │   │
  ├───┤
5 │ ●─┼───> List<Entry<String, Person>>//这是说,这两个list存储的元素是都是Entry<String,Person>类型的(对于List<>而言,这是泛型的二重嵌套了;Entry<K,V>(记录的类型是包含字段类型情况:K->String和V->Person)其中public static 接口 Map.Entry<K, V>
详细API:
https://www.apiref.com/java11-zh/java.base/java/util/Map.Entry.html
  ├───┤
6 │   │
  ├───┤
7 │   │
  └───┘
在查找的时候，例如：
Person p = map.get("a");
HashMap 内部通过"a"找到的实际上是List<Entry<String, Person>>，它还需要遍历这个List，并找到一个Entry(记录/元素)，它的key字段是"a"，才能返回对应的Person实例。
我们把不同的key具有相同的hashCode()的情况称之为哈希冲突。
在冲突的时候，一种最简单的解决办法是用List存储hashCode()相同的key-value。显然，如果冲突的概率越大，这个List就越长，Map的get()方法效率就越低，这就是为什么要尽量满足条件:如果两个对象不相等，则两个对象的 hashCode() 尽量不要相等。
hashCode()方法编写得越好，HashMap工作的效率就越高。
小结
要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；

一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：

如果equals()返回true，则hashCode()返回值必须相等；
技巧:实现equals()方法可以通过Objects.equals()辅助方法来实现;
如果equals()返回false，则hashCode()返回值尽量不要相等。
技巧:实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。

Note: java.util.Objects
public final class Objects
extends Object
此类包含static实用程序方法，用于操作对象或在操作前检查某些条件。 这些实用程序包括null或null方法，用于计算对象的哈希代码，返回对象的字符串，比较两个对象，以及检查索引或子范围值是否超出范围。
*/
    }
}
class Person2 {
    String firstName;
    String lastName;
    int age;
    public Person2(String firstName,String lastName,int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }
/*    @Override
    public int hashCode() {
        int h = 0;
        h = 31 * h + firstName.hashCode();
        //实现equals()方法遇到的问题类似，如果firstName或lastName为null，上述代码工作起来就会抛NullPointerException。
        h = 31 * h + lastName.hashCode();
        h = 31 * h + age;
        return h;
    }*/
    /*注意到String类已经正确实现了hashCode()方法，我们在计算Person的hashCode()时，反复使用31*h，这样做的目的是为了尽量把不同的Person实例的hashCode()均匀分布到整个int范围。

和实现equals()方法遇到的问题类似，如果firstName或lastName为null，上述代码工作起来就会抛NullPointerException。
为了解决这个问题，我们在计算hashCode()的时候，经常借助Objects.hash()来计算：
public static int hash(Object... values)
为一系列输入值生成哈希码。 生成哈希码，如同所有输入值都放在一个数组中，并通过调用Arrays.hashCode(Object[])对该数组进行哈希处理 。此方法对于在包含多个字段的对象上实现Object.hashCode()非常有用。
例如，如果有三个字段，对象x ， y ，和z ，一个可以这样写：
 @Override
 public int hashCode() {
     return Objects.hash(x, y, z);
 }
*/
/*
作为key的对象的类必须正确覆写equals()方法。
回顾下:HashMap为什么能通过key直接计算出value存储的索引。相同的key对象（使用equals()判断时返回true）必须要计算出相同的索引，
否则，相同的key每次取出的value就不一定对。
通过key计算索引的方式就是调用key对象的hashCode()方法，它返回一个int整数。(注意我们是为充当key的对象的对应类编写hashCode()方法,而key选用String对象时,由于String内部已经实现了正确的hashCode(),所以不需要我们在重写的.而当key的类型是我们自己编写的时候,就务必重写hashCode()乃至equals()这两个方法;
HashMap正是通过这个方法直接定位key对应的value的索引，继而直接返回value。*/
    @Override//借助.hash()方法类重写hashCode(); 通过调试可以观察到,执行put()函数的时候回调用hashCode函数
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age &&
                Objects.equals(firstName, person2.firstName) &&
                Objects.equals(lastName, person2.lastName);/*在比较这两个String类型字段大的时候，遗憾的无法看到String中的eauals()是zen‘me怎么运行的；吃了不少苦头；
                不过在另一个类中（equals3.java）的调试中，确实成功步入到String的equals（）方法的运行；到底在什么情况下可以步入呢？*/
        /*发现:
        *  public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));//如果a和b是两个String,那(a==b为false);而或上后面那一部分(a!=null&&a.equals(b))引发object.equals()方法的调用:
                *    public boolean equals(Object obj) {
        return (this == obj);//函数体就这一个语句;(虽然如此,但考虑到 多态,equals的具体实现未必就是(往往)不是调用根类的那个比较地址的equals()方法;比如传入的obj可能是Object的子类对象String,那这个时候equals就看String类是怎么实现它的了(String中的equals()用到某些宏和属性(coder);
    }
                *  public boolean equals(Object obj)
        指示某个其他对象是否“等于”此对象。
        equals方法在非null对象引用上实现等价关系：

        自反性 ：对于任何非空的参考值x ， x.equals(x)应该返回true 。
        它是对称的 ：对于任何非空引用值x和y ， x.equals(y)应该返回true当且仅当y.equals(x)回报true 。
        传递性 ：对于任何非空引用值x ， y和z ，如果x.equals(y)回报true个y.equals(z)回报true ，然后x.equals(z)应该返回true 。
        *
        它是一致的 ：对于任何非空引用值x和y ，多次调用x.equals(y)始终返回true或始终返回false ，前提是未修改对象上的equals比较中使用的信息。
        对于任何非空的参考值x ， x.equals(null)应该返回false 。
        类Object的equals方法实现了对象上最具区别的可能等价关系; 也就是说，对于任何非空引用值x和y ，当且仅当x和y引用同一对象（ x == y具有值true ）时，此方法返回true 。

        请注意，通常需要在重写此方法时覆盖hashCode方法，以便维护hashCode方法的常规协定，该方法声明相等对象必须具有相等的哈希代码。

        参数
        obj - 要与之比较的参考对象。
        结果
        true如果此对象与obj参数相同; 否则为false 。
            }*/
    }

    @Override
    public String toString() {
        return "Person2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

}
/*编写 equals 和 hashCode - 廖雪峰的官方网站
小白的零基础 Java 教程，从入门到顶级架构师！
我们知道 Map 是一种键 - 值（key-value）映射表，可以通过 key 快速查找对应的 value。

以 HashMap 为例，观察下面的代码：

Map<String, Person> map = new HashMap<>();
map.put("a", new Person("Xiao Ming"));
map.put("b", new Person("Xiao Hong"));
map.put("c", new Person("Xiao Jun"));

map.get("a");
map.get("x");
HashMap之所以能根据key直接拿到value，原因是它内部通过空间换时间的方法，用一个大数组存储所有value，并根据 key 直接计算出value应该存储在哪个索引：

┌───┐
0 │   │
  ├───┤
1 │ ●─┼───> Person("Xiao Ming")
  ├───┤
2 │   │
  ├───┤
3 │   │
  ├───┤
4 │   │
  ├───┤
5 │ ●─┼───> Person("Xiao Hong")
  ├───┤
6 │ ●─┼───> Person("Xiao Jun")
  ├───┤
7 │   │
  └───┘
如果key的值为"a"，计算得到的索引总是1，因此返回value为Person("Xiao Ming")，如果key的值为"b"，计算得到的索引总是5，因此返回value为Person("Xiao Hong")，这样，就不必遍历整个数组，即可直接读取key对应的value。

    当我们使用key存取value的时候，就会引出一个问题：
我们放入Map的key是字符串"a"，但是，当我们获取Map的value时，传入的变量不一定就是放入的那个key对象。
换句话讲，两个key应该是内容相同，但不一定是同一个对象。测试代码如下：

因为在Map的内部，对key做比较是通过equals()实现的，这一点和List查找元素需要正确覆写equals()是一样的，即正确使用Map必须保证：作为key的对象必须正确覆写equals()方法。

我们经常使用String作为key，因为String已经正确覆写了equals()方法。但如果我们放入的key是一个自己写的类，就必须保证正确覆写了equals()方法。

我们再思考一下HashMap为什么能通过key直接计算出value存储的索引。相同的key对象（使用equals()判断时返回true）必须要计算出相同的索引，否则，相同的key每次取出的value就不一定对。

通过key计算索引的方式就是调用key对象的hashCode()方法，它返回一个int整数。HashMap正是通过这个方法直接定位key对应的value的索引，继而直接返回value。

因此，正确使用Map必须保证：

1.作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
2.作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：
    如果两个对象相等，则两个对象的hashCode()必须相等；
    如果两个对象不相等，则两个对象的hashCode()尽量不要相等。
    即对应两个实例a和b：
如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。
上述第一条规范是正确性，必须保证实现，否则HashMap不能正常工作。
而第二条如果尽量满足，则可以保证查询效率，因为不同的对象，如果返回相同的hashCode()，会造成Map内部存储冲突，使存取的效率下降。
我们还需要正确实现hashCode()，即上述 3 个字段分别相同的实例，hashCode()返回的int必须相同：
编写equals()和hashCode()遵循的原则是：
equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；equals()中没有使用到的字段，绝不可放在hashCode()中计算。
另外注意，对于放入HashMap的value对象，没有任何要求。

延伸阅读
既然HashMap内部使用了数组，通过计算key的hashCode()直接定位value所在的索引，那么第一个问题来了：hashCode() 返回的int范围高达 ±21 亿，先不考虑负数，HashMap内部使用的数组得有多大？

实际上HashMap初始化时默认的数组大小只有 16，任何key，无论它的hashCode()有多大，都可以简单地通过：

int index = key.hashCode() & 0xf;
把索引确定在 0～15，即永远不会超出数组范围，上述算法只是一种最简单的实现。

第二个问题：如果添加超过 16 个key-value到HashMap，数组不够用了怎么办？
添加超过一定数量的key-value时，HashMap会在内部自动扩容，每次扩容一倍，即长度为 16 的数组扩展为长度 32，相应地，需要重新确定hashCode()计算的索引位置。例如，对长度为 32 的数组计算hashCode()对应的索引，计算方式要改为：
int index = key.hashCode() & 0x1f;
由于扩容会导致重新分布已有的key-value，所以，频繁扩容对HashMap的性能影响很大。如果我们确定要使用一个容量为10000个key-value的HashMap，更好的方式是创建HashMap时就指定容量：
Map<String, Integer> map = new HashMap<>(10000);
虽然指定容量是10000，但HashMap内部的数组长度总是 2n，因此，实际数组长度被初始化为比10000大的16384（214）。

最后一个问题：如果不同的两个key，例如"a"和"b"，它们的hashCode()恰好是相同的（这种情况是完全可能的，因为不相等的两个实例，只要求hashCode()尽量不相等），那么，当我们放入：

map.put("a", new Person("Xiao Ming"));
map.put("b", new Person("Xiao Hong"));
时，由于计算出的数组索引相同，后面放入的"Xiao Hong"会不会把"Xiao Ming"覆盖了？当然不会！

*/
