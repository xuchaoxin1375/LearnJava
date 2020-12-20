package study.api;

import java.util.Arrays;
/*为Person类实现接口Comparable<T为Person>(先在类的头部声明一下接口)*/
class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    /*再在类Person内具体的实现Comparable<T>的具体实现*/
    public int compareTo(Person other) {
        /*java.lang.String public int compareTo(@NotNull String anotherString)
        * int	compareTo(String anotherString)
按字典顺序比较两个字符串。(类似于c的strcmp()函数的功能.*/
        return this.name.compareTo(other.name);
    }
    public String toString() {
        return this.name + "," + this.score;
    }
}
// main
public class ComparableCustom {
    public static void main(String[] args) {
        Person[] ps = new Person[] {
                new Person("Bob", 61),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));
    }
}