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
/*ע�⵽Comparator�ӿ�Ҫ��ʵ��һ���ȽϷ�����������Ƚϴ��������Ԫ��a��b�����a<b���򷵻ظ�����ͨ����-1�����a==b���򷵻�0�����a>b���򷵻�������ͨ����1��TreeMap�ڲ����ݱȽϽ����Key��������

����������ִ�н����֪����ӡ��Keyȷʵ�ǰ���Comparator�����˳������ġ����Ҫ����Key����Value�����ǿ��Դ���һ��new Person("Bob")��ΪKey�����᷵�ض�Ӧ��Integerֵ2��

���⣬ע�⵽Person�ಢδ��дequals()��hashCode()����ΪTreeMap��ʹ��equals()��hashCode()��*/

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