package map_and_hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsAndHashCode {
    public static void main(String[] args) {
        ////
        String key1 = "a";
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 123);
/*ͨ��newʵ����һ����ͬ��key1���µ��ַ�������(�������������������һ����)*/
        String key2 = new String("a");
        map.get(key2); // 123
        System.out.println(key1 == key2); // false
        /*��,��Map���ڲ�����key���Ƚ���ͨ��equals()ʵ�ֵģ���һ���List����Ԫ����Ҫ��ȷ��дequals()��һ���ģ�����ȷʹ��Map���뱣֤����Ϊkey�Ķ��������ȷ��дequals()������
        * ���Ǿ���ʹ��String��Ϊkey����ΪString�Ѿ���ȷ��д��equals()��������������Ƿ����key��һ���Լ�д���࣬�ͱ��뱣֤��ȷ��д��equals()������
        * ������˼��һ��HashMapΪʲô��ͨ��keyֱ�Ӽ����value�洢����������ͬ��key����ʹ��equals()�ж�ʱ����true������Ҫ�������ͬ��������������ͬ��keyÿ��ȡ����value�Ͳ�һ���ԡ�
ͨ��key���������ķ�ʽ���ǵ���key�����hashCode()������������һ��int������HashMap����ͨ���������ֱ�Ӷ�λkey��Ӧ��value���������̶�ֱ�ӷ���value��(��Ȼ,String�����Ѿ�ʵ����hashCode������:���ش��ַ�����hash��;���κζ�����hashCode�뷽��(��ΪObject�����о���hashCode()����)
* ��ˣ���ȷʹ��Map���뱣֤��
1.��Ϊkey�Ķ��������ȷ��дequals()��������ȵ�����keyʵ������equals()���뷵��true��
2.��Ϊkey�Ķ��󻹱�����ȷ��дhashCode()��������hashCode()����Ҫ�ϸ���ѭ���¹淶��
    �������������ȣ������������hashCode()������ȣ�
    �������������ȣ������������hashCode()������Ҫ��ȡ�
    ����Ӧ����ʵ��a��b��
���a��b��ȣ���ôa.equals(b)һ��Ϊtrue����a.hashCode()�������b.hashCode()��
���a��b����ȣ���ôa.equals(b)һ��Ϊfalse����a.hashCode()��b.hashCode()������Ҫ��ȡ�
������һ���淶����ȷ�ԣ����뱣֤ʵ�֣�����HashMap��������������
���ڶ�������������㣬����Ա�֤��ѯЧ�ʣ���Ϊ��ͬ�Ķ������������ͬ��hashCode()�������Map�ڲ��洢��ͻ��ʹ��ȡ��Ч���½���

*/
        System.out.println(key1.equals(key2)); // true

        ///�Զ���������Ϊkey������
        Map<Person2,Integer> map2=new HashMap<>();
        //��������key��ʵ�����������ʵ���͵�һ��ʵ������������ȣ�
        Person2 t1=new Person2("Xiao","rr",55),
        t2=new Person2("Xiao","Hong",66),
        t3=new Person2("Xiao", "rr", 55);
       // System.out.println("t1==t3:"+t1.equals(t3));
        //Object obj=new Object();obj.equals(5);//˵����������Ҳ���Դ��ݸ�Object�ࣨ������������ΪInteger��Ȼ����ִ�У���
        map2.put(t1 ,77);
        map2.put(t2 ,88);
        //map2.put(t3,879);

        System.out.println(map2.get(t1));/*map2.get("a")����һ��Person2���͵Ķ���;Ȼ��Ϊ�˴�ӡ�����������Ϣ,Ӧ����дtoString����*/
        System.out.println(map2.get(t2));
        System.out.println(map2.get(t3));//������֤����t3ʵ��������map2ӳ����ʱ����t3Ҳ����ȡ��keyΪt1ʵ��ʱ����Ӧ��valueֵ��77��
        /*���⣬�������ǲ����ʵ����ʱ��һ���ģ����ǣ�key���е�hashCode���������hashֵҲ��Ȼ�п�����һ���ģ���Ϊkey��ʵ����ͬ��ʱ���ǿ϶�����ͬ�ģ�����֮����keyʵ����hash
        * ��ͬ����ô�ͻ����hash��ͻ������List����ʽ�������洢��Щӳ��ֵ��
        * �������дeauals��������ôʹ��t3���޷�ȡ����t2ӳ���valueֵ��;
        */
        //���Ը���ĳ��key-value:
        map2.put(t3,314);
        System.out.println("��t3ȥӰ��t1��ӳ���value:" + map2.get(t1));//�ɹ���t3ȥ������t1->value;
        /*ʹ��Map��ʱ��ֻҪkey����ͬ������ӳ���value�ͻ������š�
���ǣ���HashMap�ڲ���ȷʵ���ܴ��ڲ�ͬ��key��ӳ�䵽��ͬ��hashCode()������ͬ������������

�������:"a"��"b"������key���ռ�������������� 5����ô����HashMap�������У�ʵ�ʴ洢�Ĳ���һ��Personʵ��������һ��List������������Entry��һ����"a"��ӳ�䣬һ����"b"��ӳ�䣺

����������
0 ��   ��
  ����������
1 ��   ��
  ����������
2 ��   ��
  ����������
3 ��   ��
  ����������
4 ��   ��
  ����������
5 �� �񩤩੤����> List<Entry<String, Person>>//����˵,������list�洢��Ԫ���Ƕ���Entry<String,Person>���͵�(����List<>����,���Ƿ��͵Ķ���Ƕ����;Entry<K,V>(��¼�������ǰ����ֶ��������:K->String��V->Person)����public static �ӿ� Map.Entry<K, V>
��ϸAPI:
https://www.apiref.com/java11-zh/java.base/java/util/Map.Entry.html
  ����������
6 ��   ��
  ����������
7 ��   ��
  ����������
�ڲ��ҵ�ʱ�����磺
Person p = map.get("a");
HashMap �ڲ�ͨ��"a"�ҵ���ʵ������List<Entry<String, Person>>��������Ҫ�������List�����ҵ�һ��Entry(��¼/Ԫ��)������key�ֶ���"a"�����ܷ��ض�Ӧ��Personʵ����
���ǰѲ�ͬ��key������ͬ��hashCode()�������֮Ϊ��ϣ��ͻ��
�ڳ�ͻ��ʱ��һ����򵥵Ľ���취����List�洢hashCode()��ͬ��key-value����Ȼ�������ͻ�ĸ���Խ�����List��Խ����Map��get()����Ч�ʾ�Խ�ͣ������ΪʲôҪ������������:�������������ȣ������������ hashCode() ������Ҫ��ȡ�
hashCode()������д��Խ�ã�HashMap������Ч�ʾ�Խ�ߡ�
С��
Ҫ��ȷʹ��HashMap����Ϊkey���������ȷ��дequals()��hashCode()������

һ���������д��equals()���ͱ��븲дhashCode()�����Ҹ�д�����ǣ�

���equals()����true����hashCode()����ֵ������ȣ�
����:ʵ��equals()��������ͨ��Objects.equals()����������ʵ��;
���equals()����false����hashCode()����ֵ������Ҫ��ȡ�
����:ʵ��hashCode()��������ͨ��Objects.hashCode()��������ʵ�֡�

Note: java.util.Objects
public final class Objects
extends Object
�������staticʵ�ó��򷽷������ڲ���������ڲ���ǰ���ĳЩ������ ��Щʵ�ó������null��null���������ڼ������Ĺ�ϣ���룬���ض�����ַ������Ƚ����������Լ�����������ӷ�Χֵ�Ƿ񳬳���Χ��
*/
    }
}
class Person2 {
    String firstName;
    String lastName;
    int age;
    public Person2(String firstName,String lastName,int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }
/*    @Override
    public int hashCode() {
        int h = 0;
        h = 31 * h + firstName.hashCode();
        //ʵ��equals()�����������������ƣ����firstName��lastNameΪnull���������빤�������ͻ���NullPointerException��
        h = 31 * h + lastName.hashCode();
        h = 31 * h + age;
        return h;
    }*/
    /*ע�⵽String���Ѿ���ȷʵ����hashCode()�����������ڼ���Person��hashCode()ʱ������ʹ��31*h����������Ŀ����Ϊ�˾����Ѳ�ͬ��Personʵ����hashCode()���ȷֲ�������int��Χ��

��ʵ��equals()�����������������ƣ����firstName��lastNameΪnull���������빤�������ͻ���NullPointerException��
Ϊ�˽��������⣬�����ڼ���hashCode()��ʱ�򣬾�������Objects.hash()�����㣺
public static int hash(Object... values)
Ϊһϵ������ֵ���ɹ�ϣ�롣 ���ɹ�ϣ�룬��ͬ��������ֵ������һ�������У���ͨ������Arrays.hashCode(Object[])�Ը�������й�ϣ���� ���˷��������ڰ�������ֶεĶ�����ʵ��Object.hashCode()�ǳ����á�
���磬����������ֶΣ�����x �� y ����z ��һ����������д��
 @Override
 public int hashCode() {
     return Objects.hash(x, y, z);
 }
*/
/*
��Ϊkey�Ķ�����������ȷ��дequals()������
�ع���:HashMapΪʲô��ͨ��keyֱ�Ӽ����value�洢����������ͬ��key����ʹ��equals()�ж�ʱ����true������Ҫ�������ͬ��������
������ͬ��keyÿ��ȡ����value�Ͳ�һ���ԡ�
ͨ��key���������ķ�ʽ���ǵ���key�����hashCode()������������һ��int������(ע��������Ϊ�䵱key�Ķ���Ķ�Ӧ���дhashCode()����,��keyѡ��String����ʱ,����String�ڲ��Ѿ�ʵ������ȷ��hashCode(),���Բ���Ҫ��������д��.����key�������������Լ���д��ʱ��,�������дhashCode()����equals()����������;
HashMap����ͨ���������ֱ�Ӷ�λkey��Ӧ��value���������̶�ֱ�ӷ���value��*/
    @Override//����.hash()��������дhashCode(); ͨ�����Կ��Թ۲쵽,ִ��put()������ʱ��ص���hashCode����
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age &&
                Objects.equals(firstName, person2.firstName) &&
                Objects.equals(lastName, person2.lastName);/*�ڱȽ�������String�����ֶδ��ʱ���ź����޷�����String�е�eauals()��zen��me��ô���еģ����˲��ٿ�ͷ��
                ��������һ�����У�equals3.java���ĵ����У�ȷʵ�ɹ����뵽String��equals�������������У�������ʲô����¿��Բ����أ�*/
        /*����:
        *  public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));//���a��b������String,��(a==bΪfalse);�����Ϻ�����һ����(a!=null&&a.equals(b))����object.equals()�����ĵ���:
                *    public boolean equals(Object obj) {
        return (this == obj);//���������һ�����;(��Ȼ���,�����ǵ� ��̬,equals�ľ���ʵ��δ�ؾ���(����)���ǵ��ø�����Ǹ��Ƚϵ�ַ��equals()����;���紫���obj������Object���������String,�����ʱ��equals�Ϳ�String������ôʵ��������(String�е�equals()�õ�ĳЩ�������(coder);
    }
                *  public boolean equals(Object obj)
        ָʾĳ�����������Ƿ񡰵��ڡ��˶���
        equals�����ڷ�null����������ʵ�ֵȼ۹�ϵ��

        �Է��� �������κηǿյĲο�ֵx �� x.equals(x)Ӧ�÷���true ��
        ���ǶԳƵ� �������κηǿ�����ֵx��y �� x.equals(y)Ӧ�÷���true���ҽ���y.equals(x)�ر�true ��
        ������ �������κηǿ�����ֵx �� y��z �����x.equals(y)�ر�true��y.equals(z)�ر�true ��Ȼ��x.equals(z)Ӧ�÷���true ��
        *
        ����һ�µ� �������κηǿ�����ֵx��y ����ε���x.equals(y)ʼ�շ���true��ʼ�շ���false ��ǰ����δ�޸Ķ����ϵ�equals�Ƚ���ʹ�õ���Ϣ��
        �����κηǿյĲο�ֵx �� x.equals(null)Ӧ�÷���false ��
        ��Object��equals����ʵ���˶������������Ŀ��ܵȼ۹�ϵ; Ҳ����˵�������κηǿ�����ֵx��y �����ҽ���x��y����ͬһ���� x == y����ֵtrue ��ʱ���˷�������true ��

        ��ע�⣬ͨ����Ҫ����д�˷���ʱ����hashCode�������Ա�ά��hashCode�����ĳ���Э�����÷���������ȶ�����������ȵĹ�ϣ���롣

        ����
        obj - Ҫ��֮�ȽϵĲο�����
        ���
        true����˶�����obj������ͬ; ����Ϊfalse ��
            }*/
    }

    @Override
    public String toString() {
        return "Person2{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

}
/*��д equals �� hashCode - ��ѩ��Ĺٷ���վ
С�׵������ Java �̳̣������ŵ������ܹ�ʦ��
����֪�� Map ��һ�ּ� - ֵ��key-value��ӳ�������ͨ�� key ���ٲ��Ҷ�Ӧ�� value��

�� HashMap Ϊ�����۲�����Ĵ��룺

Map<String, Person> map = new HashMap<>();
map.put("a", new Person("Xiao Ming"));
map.put("b", new Person("Xiao Hong"));
map.put("c", new Person("Xiao Jun"));

map.get("a");
map.get("x");
HashMap֮�����ܸ���keyֱ���õ�value��ԭ�������ڲ�ͨ���ռ任ʱ��ķ�������һ��������洢����value�������� key ֱ�Ӽ����valueӦ�ô洢���ĸ�������

����������
0 ��   ��
  ����������
1 �� �񩤩੤����> Person("Xiao Ming")
  ����������
2 ��   ��
  ����������
3 ��   ��
  ����������
4 ��   ��
  ����������
5 �� �񩤩੤����> Person("Xiao Hong")
  ����������
6 �� �񩤩੤����> Person("Xiao Jun")
  ����������
7 ��   ��
  ����������
���key��ֵΪ"a"������õ�����������1����˷���valueΪPerson("Xiao Ming")�����key��ֵΪ"b"������õ�����������5����˷���valueΪPerson("Xiao Hong")���������Ͳ��ر����������飬����ֱ�Ӷ�ȡkey��Ӧ��value��

    ������ʹ��key��ȡvalue��ʱ�򣬾ͻ�����һ�����⣺
���Ƿ���Map��key���ַ���"a"�����ǣ������ǻ�ȡMap��valueʱ������ı�����һ�����Ƿ�����Ǹ�key����
���仰��������keyӦ����������ͬ������һ����ͬһ�����󡣲��Դ������£�

��Ϊ��Map���ڲ�����key���Ƚ���ͨ��equals()ʵ�ֵģ���һ���List����Ԫ����Ҫ��ȷ��дequals()��һ���ģ�����ȷʹ��Map���뱣֤����Ϊkey�Ķ��������ȷ��дequals()������

���Ǿ���ʹ��String��Ϊkey����ΪString�Ѿ���ȷ��д��equals()��������������Ƿ����key��һ���Լ�д���࣬�ͱ��뱣֤��ȷ��д��equals()������

������˼��һ��HashMapΪʲô��ͨ��keyֱ�Ӽ����value�洢����������ͬ��key����ʹ��equals()�ж�ʱ����true������Ҫ�������ͬ��������������ͬ��keyÿ��ȡ����value�Ͳ�һ���ԡ�

ͨ��key���������ķ�ʽ���ǵ���key�����hashCode()������������һ��int������HashMap����ͨ���������ֱ�Ӷ�λkey��Ӧ��value���������̶�ֱ�ӷ���value��

��ˣ���ȷʹ��Map���뱣֤��

1.��Ϊkey�Ķ��������ȷ��дequals()��������ȵ�����keyʵ������equals()���뷵��true��
2.��Ϊkey�Ķ��󻹱�����ȷ��дhashCode()��������hashCode()����Ҫ�ϸ���ѭ���¹淶��
    �������������ȣ������������hashCode()������ȣ�
    �������������ȣ������������hashCode()������Ҫ��ȡ�
    ����Ӧ����ʵ��a��b��
���a��b��ȣ���ôa.equals(b)һ��Ϊtrue����a.hashCode()�������b.hashCode()��
���a��b����ȣ���ôa.equals(b)һ��Ϊfalse����a.hashCode()��b.hashCode()������Ҫ��ȡ�
������һ���淶����ȷ�ԣ����뱣֤ʵ�֣�����HashMap��������������
���ڶ�������������㣬����Ա�֤��ѯЧ�ʣ���Ϊ��ͬ�Ķ������������ͬ��hashCode()�������Map�ڲ��洢��ͻ��ʹ��ȡ��Ч���½���
���ǻ���Ҫ��ȷʵ��hashCode()�������� 3 ���ֶηֱ���ͬ��ʵ����hashCode()���ص�int������ͬ��
��дequals()��hashCode()��ѭ��ԭ���ǣ�
equals()�õ������ڱȽϵ�ÿһ���ֶΣ���������hashCode()�����ڼ��㣻equals()��û��ʹ�õ����ֶΣ������ɷ���hashCode()�м��㡣
����ע�⣬���ڷ���HashMap��value����û���κ�Ҫ��

�����Ķ�
��ȻHashMap�ڲ�ʹ�������飬ͨ������key��hashCode()ֱ�Ӷ�λvalue���ڵ���������ô��һ���������ˣ�hashCode() ���ص�int��Χ�ߴ� ��21 �ڣ��Ȳ����Ǹ�����HashMap�ڲ�ʹ�õ�������ж��

ʵ����HashMap��ʼ��ʱĬ�ϵ������Сֻ�� 16���κ�key����������hashCode()�ж�󣬶����Լ򵥵�ͨ����

int index = key.hashCode() & 0xf;
������ȷ���� 0��15������Զ���ᳬ�����鷶Χ�������㷨ֻ��һ����򵥵�ʵ�֡�

�ڶ������⣺�����ӳ��� 16 ��key-value��HashMap�����鲻��������ô�죿
��ӳ���һ��������key-valueʱ��HashMap�����ڲ��Զ����ݣ�ÿ������һ����������Ϊ 16 ��������չΪ���� 32����Ӧ�أ���Ҫ����ȷ��hashCode()���������λ�á����磬�Գ���Ϊ 32 ���������hashCode()��Ӧ�����������㷽ʽҪ��Ϊ��
int index = key.hashCode() & 0x1f;
�������ݻᵼ�����·ֲ����е�key-value�����ԣ�Ƶ�����ݶ�HashMap������Ӱ��ܴ��������ȷ��Ҫʹ��һ������Ϊ10000��key-value��HashMap�����õķ�ʽ�Ǵ���HashMapʱ��ָ��������
Map<String, Integer> map = new HashMap<>(10000);
��Ȼָ��������10000����HashMap�ڲ������鳤������ 2n����ˣ�ʵ�����鳤�ȱ���ʼ��Ϊ��10000���16384��214����

���һ�����⣺�����ͬ������key������"a"��"b"�����ǵ�hashCode()ǡ������ͬ�ģ������������ȫ���ܵģ���Ϊ����ȵ�����ʵ����ֻҪ��hashCode()��������ȣ�����ô�������Ƿ��룺

map.put("a", new Person("Xiao Ming"));
map.put("b", new Person("Xiao Hong"));
ʱ�����ڼ����������������ͬ����������"Xiao Hong"�᲻���"Xiao Ming"�����ˣ���Ȼ���ᣡ

*/
