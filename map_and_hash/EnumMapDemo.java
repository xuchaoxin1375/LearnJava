package map_and_hash;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

/*如果作为key的对象是enum类型，那么，还可以使用Java集合库提供的一种EnumMap，它在内部以一个非常紧凑的数组存储value，并且根据enum类型的key直接定位到内部数组的索引，并不需要计算hashCode()，不但效率最高，而且没有额外的空间浪费。
* 如果Map的key是enum类型，推荐使用EnumMap，既保证速度，也不浪费空间。
使用EnumMap的时候，根据面向抽象编程的原则，应持有Map接口。*/
public class EnumMapDemo {
    public static void main(String[] args) {
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        /*使用EnumMap的时候，我们总是用Map接口来引用它，
        因此，实际上把HashMap和EnumMap互换，在客户端看来没有任何区别*/
        map.put(DayOfWeek.MONDAY, "星期一");
        map.put(DayOfWeek.TUESDAY, "星期二");
        map.put(DayOfWeek.WEDNESDAY, "星期三");
        map.put(DayOfWeek.THURSDAY, "星期四");
        map.put(DayOfWeek.FRIDAY, "星期五");
        map.put(DayOfWeek.SATURDAY, "星期六");
        map.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));
    }
}
