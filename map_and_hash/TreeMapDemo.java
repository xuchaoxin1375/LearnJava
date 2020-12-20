//package map_and_hash;
//
//import java.util.Comparator;
//import java.util.Map;
//import java.util.SortedMap;/**/
//import java.util.TreeMap;/*TreeMap��extends java.util.AbstractMap<K, V>;AbstractMap��implements Map<K, V>
//��һ����,TreeMap��implements NavigableMap<K,V>,��Navigable<K,v>��extends SortedMap<K, V>*/
///*HashMap��һ���Կռ任ʱ���ӳ�������ʵ��ԭ��������ڲ���Key������ģ�������HashMap��Keyʱ����˳���ǲ���Ԥ��ģ���ÿ��Key�������һ���ҽ�����һ�Σ���
//����һ��һ��Map��ʵ��:SortedMap�������ڲ����Key������������Map����SortedMap��ע�⵽SortedMap�ǽӿڣ�����ʵ������TreeMap,��Map->SortedMap->TreeMap(����ʵ������TreeMap��)��
//
//       ����������
//       ��Map��
//       ����������
//         ��
//    �����������ة�����������
//    ��          ��
//������������������ ����������������������
//��HashMap�� ��SortedMap��
//������������������ ����������������������
//               ��
//          ��������������-----��������
//          �� NavigableMap ��
//          ��������-----��������������
//               ��
//          ����������������������
//          �� TreeMap ��
//          ����������������������
//SortedMap��֤����ʱ��Key��˳���������������磬�����Key��"apple"��"pear"��"orange"��������˳��һ����"apple"��"orange"��"pear"����ΪStringĬ�ϰ���ĸ����*/
//public class TreeMapDemo {
//    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>();
//        SortedMap<String,Integer> mapTree=new TreeMap<>();//��SortedMap<>���͵����ñ���������TreeMap<>()��ʵ���������Ķ���Ҳ�Ƕ�̬��������;
//        map.put("orange", 1);
//        map.put("apple", 2);
//        map.put("pear", 3);
//        for (String key : map.keySet()) {/*��mapȡkey���ϵķ���keySet()����map��key��ɵļ���(Set)*/
//            System.out.println(key);
//        }
//        // apple, orange, pear
//
//        /*ʹ��TreeMapʱ�������Key����ʵ��Comparable�ӿڡ�String��Integer��Щ���Ѿ�ʵ����Comparable�ӿڣ���˿���ֱ����ΪKeyʹ�á�
//        ��ΪValue�Ķ�����û���κ�Ҫ��*/
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