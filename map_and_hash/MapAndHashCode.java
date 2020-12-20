package map_and_hash;

import java.util.HashMap;
import java.util.Map;

public class MapAndHashCode {
    public static void main(String[] args) {
        /*映射类型集合map到底put(些什么类型),关键是看Map<>定义时类型参数是怎么定义的*/
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