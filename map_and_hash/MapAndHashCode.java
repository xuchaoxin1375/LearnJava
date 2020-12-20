package map_and_hash;

import java.util.HashMap;
import java.util.Map;

public class MapAndHashCode {
    public static void main(String[] args) {
        /*ӳ�����ͼ���map����put(Щʲô����),�ؼ��ǿ�Map<>����ʱ���Ͳ�������ô�����*/
        Map<String, Person4> map = new HashMap<>();
        map.put("a", new Person4("Xiao Ming"));
        map.put("b", new Person4("Xiao Hong"));
        map.put("c", new Person4("Xiao Jun"));

        map.get("a"); // Person("Xiao Ming")
        map.get("x"); // null
    }
}
class Person{
    String name;
    public Person(String name){
        this.name=name;
    }
}