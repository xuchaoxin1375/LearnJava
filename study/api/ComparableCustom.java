package study.api;

import java.util.Arrays;
/*ΪPerson��ʵ�ֽӿ�Comparable<TΪPerson>(�������ͷ������һ�½ӿ�)*/
class Person implements Comparable<Person> {
    String name;
    int score;
    Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    /*������Person�ھ����ʵ��Comparable<T>�ľ���ʵ��*/
    public int compareTo(Person other) {
        /*java.lang.String public int compareTo(@NotNull String anotherString)
        * int	compareTo(String anotherString)
���ֵ�˳��Ƚ������ַ�����(������c��strcmp()�����Ĺ���.*/
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