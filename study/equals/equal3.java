package study.equals;

import java.util.List;
import java.util.Objects;

/*�Է���/�Գ��������ĳ��"��ϵ"����,������������˵��:��ϵR�����Է���*/
/*�����ȷ��д(��д)equals()������equals()����Ҫ�����Ǳ�����������������

�Է��ԣ�Reflexive�������ڷ�null��x��˵��x.equals(x)���뷵��true��
�Գ��ԣ�Symmetric�������ڷ�null��x��y��˵�����x.equals(y)Ϊtrue����y.equals(x)Ҳ����Ϊtrue��
�����ԣ�Transitive�������ڷ�null��x��y��z��˵�����x.equals(y)Ϊtrue��y.equals(z)ҲΪtrue����ôx.equals(z)Ҳ����Ϊtrue��
һ���ԣ�Consistent�������ڷ�null��x��y��˵��ֻҪx��y״̬���䣬��x.equals(y)����һ�µط���true����false��
��null�ıȽϣ���x.equals(null)��Զ����false��*/
public class equal3 {
    /*�ж���ȹ�ϵʱ,������:
     * ���������ֶαȽϣ�����ʹ��equals()��(��Ȼ�������ƵĴﵽ��cpp�������������Ч��,ֻ��cppֱ���÷���,��java����һ����ʶ��(��ʵcppҲ����ֻ�ñ�ʶ��,�÷���ֻ������Щ,��������)
     * ���ڻ��������ֶεıȽϣ�����ʹ��== ����������ж�*/
    /*java.lang.Object @Contract(value = "null -> false", pure = true)
public boolean equals(Object obj)
�ɼ�,equals()�Ǽ̳��Ը���Object�ķ���,����˵�κ��඼��equals����;��������������Ҫ�Լ���д�����Ҫ����:*/

    public static void main(String[] args) {
        List<Person1> list = List.of(
                new Person1("Xiao", "Ming", 18),
                new Person1("Xiao", "Hong", 25),
                new Person1("Bob", "Smith", 20)
        );


        boolean exist = list.contains(new Person1("Bob", "Smith", 20));
        System.out.println(exist ? "���Գɹ�!" : "����ʧ��!");
    }
}


class Person1 {
    String firstName;
    String lastName;
    int age;
    /*constructor*/
    public Person1(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    /*override equals*/
    /**/
    public boolean equals(Object o) {
        /*ע��equals()�Ĳ�������һ��Ҫ��Object(�������͵ĸ���),Ҳ����˵������equals���Ƚϻ�������;
        ���ڻ������͵ıȽ�,equals���Ƕ����,Ҳ�ǲ���Ҫ��,��"=="����;
        �ٴ�ǿ����,String�಻�ǻ�������,�������˾��Ķ���,������equals����������ж�*/
        if (o instanceof Person1) {
            /*�������Ķ�����Person1,��ô���ĵĽ�����oǿ��תΪPerson1,��ֵ��Person1*/
            Person1 p = (Person1) o;
            /*object���е�equals�Ѿ����������������String/Integer/��������..��(�Է���/�Գ���/..��Ҫ��)
            * ��,Ҫ���������͵ıȽϣ�����ʹ��Objects.equals()��̬������
            * java.util.Objects @Contract(value = "null, !null -> false; !null, null -> false", pure = true)
public static boolean equals(@Nullable Object a,Object b);
* ע�⾲̬�����ĵ��÷�ʽ(����.��̬������(��Ҫ�Ĳ���,(һ�����ͨ����Ҫ�ഫ��һ������))*/
            return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName) && this.age == p.age;
        }
        return false;
    }
}

/*equals()����nullʱ:
public class Person {
    public String name;
    public int age;
}
 public boolean equals(Object o) {
    if (o instanceof Person) {
        Person p = (Person) o;
        return this.name.equals(p.name) && this.age == p.age;
    }
    return false;
}
���this.nameΪnull����ôequals()�����ᱨ����ΪnullΪ������,��һ������ֵ,����ĳ�ֶ���(ʵ��),���Ӳ����ṩ/֧���κη���(ͨ��null���÷����ǻ�����),
Ӧ������this.name��null�����ж�;
��Ȼ,null������Ϊ�������������(����)�ķ���;

��ˣ���Ҫ������д���£�

public boolean equals(Object o) {
    if (o instanceof Person) {
        Person p = (Person) o;
        boolean nameEquals = false;
        //null��null�ĵ��벻��:
   //����A==nullͬʱ����B==null,��ônull��Ϊ����,��ӱ�ʾA��B���(��equals()��ʵ��������Ϊ����true)
        if (this.name == null && p.name == null) {
            nameEquals = true;
        }
        if (this.name != null) {
            nameEquals = this.name.equals(p.name);
        }
        return nameEquals && this.age == p.age;//����1
    }
    return false;//����2;
}*/