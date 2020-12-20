//package map_and_hash;
//
//import java.util.Comparator;
//import java.util.Map;
//import java.util.SortedMap;/**/
//import java.util.TreeMap;/*TreeMap是extends java.util.AbstractMap<K, V>;AbstractMap又implements Map<K, V>
//另一方面,TreeMap是implements NavigableMap<K,V>,而Navigable<K,v>又extends SortedMap<K, V>*/
///*HashMap是一种以空间换时间的映射表，它的实现原理决定了内部的Key是无序的，即遍历HashMap的Key时，其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）。
//还有一另一种Map的实现:SortedMap，它在内部会对Key进行排序，这种Map就是SortedMap。注意到SortedMap是接口，它的实现类是TreeMap,即Map->SortedMap->TreeMap(具体实现类是TreeMap类)。
//
//       ┌───┐
//       │Map│
//       └───┘
//         ▲
//    ┌────┴─────┐
//    │          │
//┌───────┐ ┌─────────┐
//│HashMap│ │SortedMap│
//└───────┘ └─────────┘
//               ▲
//          ┌──────-----───┐
//          │ NavigableMap │
//          └───-----──────┘
//               │
//          ┌─────────┐
//          │ TreeMap │
//          └─────────┘
//SortedMap保证遍历时以Key的顺序来进行排序。例如，放入的Key是"apple"、"pear"、"orange"，遍历的顺序一定是"apple"、"orange"、"pear"，因为String默认按字母排序：*/
//public class TreeMapDemo {
//    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>();
//        SortedMap<String,Integer> mapTree=new TreeMap<>();//用SortedMap<>类型的引用变量来引用TreeMap<>()所实例化出来的对象也是多态到的体现;
//        map.put("orange", 1);
//        map.put("apple", 2);
//        map.put("pear", 3);
//        for (String key : map.keySet()) {/*对map取key集合的方法keySet()返回map的key组成的集合(Set)*/
//            System.out.println(key);
//        }
//        // apple, orange, pear
//
//        /*使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。
//        作为Value的对象则没有任何要求。*/
//        Map<Person3, Integer> map2 = new TreeMap<>(
//                new Comparator<Person3>() {
//                    public int compare(Person p1, Person p2) {
//                        return p1.name.compareTo(p2.name);
//                    }
//                }
//        );
//        map2.put(new Person3("Tom"), 1);
//        map2.put(new Person3("Bob"), 2);
//        map2.put(new Person3("Lily"), 3);
//        for (Person3 key : map2.keySet()) {
//            System.out.println(key);
//        }
//        // {Person: Bob}, {Person: Lily}, {Person: Tom}
//        System.out.println(map2.get(new Person("Bob"))); // 2
//    }//main
//
//}//class TreeMapDemo
/////
//class Person3 {
//    public String name;
//    //constructor
//    public Person3(String name) {
//        this.name = name;
//    }
//    public String toString() {
//        return "{Person: " + name + "}";
//    }
//}