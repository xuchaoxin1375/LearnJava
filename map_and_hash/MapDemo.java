package map_and_hash;
/*https://blog.csdn.net/xuchaoxin1375/article/details/109496373*/


import java.util.HashMap;
import java.util.Map;//java.util包目录下Map.java文件是接口文件
import java.util.Set;

/*键->属性(组)
* 值:该属性的值为啥*/
public class MapDemo {
    public static void main(String[] args) {
        /*ctrl+k+c批量添加//注释;*/
        //实例化出一个Student类的对象s
        Student s = new Student("Xiao Ming", 99);
        /*创建Map对象:
        java.util public 接口 Map<K, V>(即Map<属性,值>更具体地说:Map<元组记录的属性,整个元组>*/
        Map<String, Student> map = new HashMap<>();

        map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
        //target引用变量保存查找结果(的对象的地址)
        Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例

        System.out.println(target == s); // true，同一个实例
        System.out.println(target.score); // 99

        Student another = map.get("Bob"); // 通过另一个key查找
        System.out.println(another); // 未找到返回null

        /*
        重复放入key-value并不会有任何问题，但是一个key只能关联一个value。在上面的代码中，
        一开始我们把key对象"apple"映射到Integer对象123，然后再次调用put()方法把"apple"映射到789，这时，原来关联的value对象123就被“冲掉”了。
        实际上，put()方法的签名是V put(K key, V value)，如果放入的key已经存在，put()方法会返回被删除的旧的value，否则，返回null。
 始终牢记：Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。*/
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        map2.put("nut",777);
        System.out.println(map2.get("apple")); // 123
        map2.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println(map2.get("apple")); // 789
   /* 此外，在一个Map中，虽然key不能重复，但value是可以重复的：*/

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("apple", 123);
        map3.put("pear", 123); // ok
        System.out.println(map3.get("apple")+"\n"+map3.get("pear"));
        /*map的遍历:(从Map跨度到了Set的知识了)
        对Map来说，要遍历key可以使用for each循环(for each循环就是增强型循环)遍历Map实例的keySet()方法返回的Set集合，被返回的这个集合它包含不重复的key的集合
        * java.util.Map<K, V> @NotNull
        @Contract(pure = true)
        public abstract java.util.Set<K> keySet() 返回类型是java.util包里的Set<K>类型
         Returns a Set view of the keys contained in this map. */

        /*IDEA技巧:
        那么当某个方法返回的类型你不能够确定的时候,可以考虑使用IDEA的修复功能来帮你把类型写上
        (先不写类型名,直接用一个标识符xx来接收这个陌生方法的返回结果;,然后在修复是选择create variable xx
        比如:*/
        Set<String> distinctSet = map2.keySet();
        System.out.println("for1:");
        /*如果是阅读别人的代码中用到的方法,for(String key : xx)已经xx是个String为元素的集合(返回这样的集合的表达式)/*/
        for (String key : distinctSet) {/*如果直接用map2代替map2.keySet()是错误的*/
            System.out.println(key+"="+map2.get(key));
            /*java.util.Map<K, V> public abstract V get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.*/
        }
        /*输出:
        apple = 789
        pear = 456
         */
        /*遍历key和value可以使用for each循环遍历Map对象的entrySet()集合(一种Set<>类型)，
        它包含每一个key-value映射：*/
        System.out.println("for2:");
        /*java.util.Map<K, V> @NotNull
@Contract(pure = true)
public abstract java.util.Set<Map.Entry<K, V>> entrySet()
Returns a Set view of the mappings contained in this map.
另一方面:
public static 接口 Map.Entry<K, V>
通过接口名Map来调用静态类型接口Entry<>
    观察Map.java接口文件源代码可以看到,Entry<>是在Map接口内部的内部接口(类似于内部类)的嵌套定义;Entry<>内部只声明了若干个抽象方法(包括静态和非静态的)比如K getKey()方法和V getValue()方法(分别返回K类型值和V类型值)*/
        Set<Map.Entry<String, Integer>> distinctSet2 = map2.entrySet();/*值得注意的是set作为后缀修饰方法的时候,一般是指取得某个被处理对象所产生的集合(即Set在这种情况下为集合之意思);而当set作为方法名的前缀,那就是动词(设置(值))的意思.
        java.util public static 接口 Map.Entry<K, V>是一个静态的内部接口,有外部接口名Map.Entry来访问到;
        那么这种情况下,需要重写Map.Entry<>接口中的诸多抽象方法吗? 并不需要,
        因为这里的Map.Entry<>没有用来实例化(new)出对象,而是作为一种类型来只是Set中的元素到的类型;
        这就如同:Comparator<String> test;该语句一样,只是作一个类型声明,不用接口来实例化对象的时候是不用讲接口中抽象方法实现出来的;*/
        System.out.println(distinctSet2.getClass().getName());

        for (Map.Entry<String, Integer> entry : distinctSet2) {//entry:记录/条目/入口
            /*java.util public static 接口 Map.Entry<K, V>
            * IDEA提示如此,尽管在Map文件中Entry内部接口没有明说是静态接口
            * 然而你发现没有,Entry是通过接口明Map直接调用,而不是某个对象类调用的(不过调用一个内部接口的说法好变扭)*/
            //System.out.println("entry对象的类型的父类:"+entry.getClass().getSuperclass().getName()+"\n entry对象的类型:"+entry.getClass().getName());
            /*entry对象的类型的父类:java.lang.Object
            entry对象的类型:java.util.HashMap$Node*/
            //System.out.println(entry instanceof Map.Entry<String, Integer>);无法比较
            String key = entry.getKey();
            Integer value = entry.getValue();/*此处调用的是HashMap类中的getValue()方法,因为map2是有HashMap()构造器实现的,而HashMap implements自Map接口,算多态吗?
            Map是java中的接口，Map.Entry是Map的一个内部接口。
Map提供了一些常用方法，如keySet()、entrySet()等方法。
keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
Map.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
此处可以参看:https://www.cnblogs.com/zhusf/p/10572279.html*/
            System.out.println(key + " = " + value);
        }

        /*对比KeySet()方法和entrySet()方法:
        *前者 Returns a Set view of the keys
        * 后者 Return a Set view of the mappings */
/*Map和List不同的是，Map存储的是key-value的映射关系，并且，它不保证顺序。在遍历的时候，遍历的顺序既不一定是put()时放入的key的顺序，也不一定是key的排序顺序。使用Map时，任何依赖顺序的逻辑都是不可靠的。以HashMap为例，假设我们放入"A"，"B"，"C"这3个key，遍历的时候，每个key会保证被遍历一次且仅遍历一次，但顺序完全没有保证，甚至对于不同的JDK版本，相同的代码遍历的输出顺序都是不同的！*/
    }//main()/psvm

}//class Demo

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

