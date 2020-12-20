package study.equals;

import java.util.List;
import java.util.Objects;

/*自反性/对称性是针对某种"关系"而言,比如像这样的说法:关系R具有自反性*/
/*如何正确编写(重写)equals()方法？equals()方法要求我们必须满足以下条件：

自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
对null的比较：即x.equals(null)永远返回false。*/
public class equal3 {
    /*判断相等关系时,有两类:
     * 对于引用字段比较，我们使用equals()，(当然可以类似的达到像cpp的重载运算符的效果,只是cpp直接用符号,而java是用一个标识符(其实cpp也可以只用标识符,用符号只是形象些,但不必须)
     * 对于基本类型字段的比较，我们使用== 来做相等性判断*/
    /*java.lang.Object @Contract(value = "null -> false", pure = true)
public boolean equals(Object obj)
可见,equals()是继承自根类Object的方法,就是说任何类都有equals方法;但是我们往往需要自己重写这个重要方法:*/

    public static void main(String[] args) {
        List<Person1> list = List.of(
                new Person1("Xiao", "Ming", 18),
                new Person1("Xiao", "Hong", 25),
                new Person1("Bob", "Smith", 20)
        );


        boolean exist = list.contains(new Person1("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
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
        /*注意equals()的参数类型一定要是Object(引用类型的根类),也就是说不能用equals来比较基础类型;
        对于基础类型的比较,equals这是多余的,也是不必要的,用"=="足矣;
        再次强调下,String类不是基础类型,是正儿八经的对象,尽量用equals来做相等性判断*/
        if (o instanceof Person1) {
            /*如果传入的对象是Person1,那么放心的将对象o强制转为Person1,赋值给Person1*/
            Person1 p = (Person1) o;
            /*object类中的equals已经处理好在引用类型String/Integer/基础类型..的(自反性/对称性/..等要求)
            * 即,要简化引用类型的比较，我们使用Objects.equals()静态方法：
            * java.util.Objects @Contract(value = "null, !null -> false; !null, null -> false", pure = true)
public static boolean equals(@Nullable Object a,Object b);
* 注意静态方法的调用方式(类名.静态方法名(必要的参数,(一般比普通方法要多传入一个参数))*/
            return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName) && this.age == p.age;
        }
        return false;
    }
}

/*equals()遇到null时:
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
如果this.name为null，那么equals()方法会报错，因为null为空引用,是一个特殊值,不是某种对象(实例),更加不会提供/支持任何方法(通过null调用方法是荒谬的),
应该先让this.name和null先做判断;
当然,null可以作为参数传入个其他(对象)的方法;

因此，需要继续改写如下：

public boolean equals(Object o) {
    if (o instanceof Person) {
        Person p = (Person) o;
        boolean nameEquals = false;
        //null和null的等与不等:
   //对象A==null同时对象B==null,那么null作为桥梁,间接表示A和B相等(在equals()的实现中体现为返回true)
        if (this.name == null && p.name == null) {
            nameEquals = true;
        }
        if (this.name != null) {
            nameEquals = this.name.equals(p.name);
        }
        return nameEquals && this.age == p.age;//出口1
    }
    return false;//出口2;
}*/