package study.equals;

import java.util.List;

/*��ˣ�Ҫ��ȷʹ��List��contains()��indexOf()��Щ�����������ʵ��������ȷ��дequals()���������򣬷Ž�ȥ��ʵ�������Ҳ���������֮��������������String��Integer��Щ��������ΪJava��׼�ⶨ�����Щ���Ѿ���ȷʵ����equals()������*/
public class equal2 {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao Ming"),
                new Person("Xiao Hong"),
                new Person("Bob")
        );
        /*�������⣬��Ȼ������new Person("Bob")����������һ��new Person("Bob")��ѯ������ԭ�����Person��û�и�дequals()������*/
        System.out.println(list.contains(new Person("Bob"))); // false
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
}

