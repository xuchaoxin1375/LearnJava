package map_and_hash;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomTreeMapKey {
    public static void main(String[] args) {

        Map<Person4, Integer> map = new TreeMap<>(new Comparator<Person4>() {
            public int compare(Person4 p1, Person4 p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map.put(new Person4("Tom"), 1);
        map.put(new Person4("Bob"), 2);
        map.put(new Person4("Lily"), 3);
        for (Person4 key : map.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(map.get(new Person4("Bob"))); // 2
    }
/*注意到Comparator接口要求实现一个比较方法，它负责比较传入的两个元素a和b，如果a<b，则返回负数，通常是-1，如果a==b，则返回0，如果a>b，则返回正数，通常是1。TreeMap内部根据比较结果对Key进行排序。

从上述代码执行结果可知，打印的Key确实是按照Comparator定义的顺序排序的。如果要根据Key查找Value，我们可以传入一个new Person("Bob")作为Key，它会返回对应的Integer值2。

另外，注意到Person类并未覆写equals()和hashCode()，因为TreeMap不使用equals()和hashCode()。*/

}

class Person4 {
    public String name;

    //constructor
    Person4(String name) {
        this.name = name;
    }

    public String toString() {
        return "{Person: " + name + "}";
    }
}