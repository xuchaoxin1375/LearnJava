package map_and_hash;
/*https://blog.csdn.net/xuchaoxin1375/article/details/109496373*/


import java.util.HashMap;
import java.util.Map;//java.util��Ŀ¼��Map.java�ļ��ǽӿ��ļ�
import java.util.Set;

/*��->����(��)
* ֵ:�����Ե�ֵΪɶ*/
public class MapDemo {
    public static void main(String[] args) {
        /*ctrl+k+c�������//ע��;*/
        //ʵ������һ��Student��Ķ���s
        Student s = new Student("Xiao Ming", 99);
        /*����Map����:
        java.util public �ӿ� Map<K, V>(��Map<����,ֵ>�������˵:Map<Ԫ���¼������,����Ԫ��>*/
        Map<String, Student> map = new HashMap<>();

        map.put("Xiao Ming", s); // ��"Xiao Ming"��Studentʵ��ӳ�䲢����
        //target���ñ���������ҽ��(�Ķ���ĵ�ַ)
        Student target = map.get("Xiao Ming"); // ͨ��key���Ҳ�����ӳ���Studentʵ��

        System.out.println(target == s); // true��ͬһ��ʵ��
        System.out.println(target.score); // 99

        Student another = map.get("Bob"); // ͨ����һ��key����
        System.out.println(another); // δ�ҵ�����null

        /*
        �ظ�����key-value���������κ����⣬����һ��keyֻ�ܹ���һ��value��������Ĵ����У�
        һ��ʼ���ǰ�key����"apple"ӳ�䵽Integer����123��Ȼ���ٴε���put()������"apple"ӳ�䵽789����ʱ��ԭ��������value����123�ͱ���������ˡ�
        ʵ���ϣ�put()������ǩ����V put(K key, V value)����������key�Ѿ����ڣ�put()�����᷵�ر�ɾ���ľɵ�value�����򣬷���null��
 ʼ���μǣ�Map�в������ظ���key����Ϊ������ͬ��key��ֻ���ԭ�е�key-value��Ӧ��value���滻����*/
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("apple", 123);
        map2.put("pear", 456);
        map2.put("nut",777);
        System.out.println(map2.get("apple")); // 123
        map2.put("apple", 789); // �ٴη���apple��Ϊkey����value��Ϊ789
        System.out.println(map2.get("apple")); // 789
   /* ���⣬��һ��Map�У���Ȼkey�����ظ�����value�ǿ����ظ��ģ�*/

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("apple", 123);
        map3.put("pear", 123); // ok
        System.out.println(map3.get("apple")+"\n"+map3.get("pear"));
        /*map�ı���:(��Map��ȵ���Set��֪ʶ��)
        ��Map��˵��Ҫ����key����ʹ��for eachѭ��(for eachѭ��������ǿ��ѭ��)����Mapʵ����keySet()�������ص�Set���ϣ������ص�����������������ظ���key�ļ���
        * java.util.Map<K, V> @NotNull
        @Contract(pure = true)
        public abstract java.util.Set<K> keySet() ����������java.util�����Set<K>����
         Returns a Set view of the keys contained in this map. */

        /*IDEA����:
        ��ô��ĳ���������ص������㲻�ܹ�ȷ����ʱ��,���Կ���ʹ��IDEA���޸����������������д��
        (�Ȳ�д������,ֱ����һ����ʶ��xx���������İ�������ķ��ؽ��;,Ȼ�����޸���ѡ��create variable xx
        ����:*/
        Set<String> distinctSet = map2.keySet();
        System.out.println("for1:");
        /*������Ķ����˵Ĵ������õ��ķ���,for(String key : xx)�Ѿ�xx�Ǹ�StringΪԪ�صļ���(���������ļ��ϵı��ʽ)/*/
        for (String key : distinctSet) {/*���ֱ����map2����map2.keySet()�Ǵ����*/
            System.out.println(key+"="+map2.get(key));
            /*java.util.Map<K, V> public abstract V get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.*/
        }
        /*���:
        apple = 789
        pear = 456
         */
        /*����key��value����ʹ��for eachѭ������Map�����entrySet()����(һ��Set<>����)��
        ������ÿһ��key-valueӳ�䣺*/
        System.out.println("for2:");
        /*java.util.Map<K, V> @NotNull
@Contract(pure = true)
public abstract java.util.Set<Map.Entry<K, V>> entrySet()
Returns a Set view of the mappings contained in this map.
��һ����:
public static �ӿ� Map.Entry<K, V>
ͨ���ӿ���Map�����þ�̬���ͽӿ�Entry<>
    �۲�Map.java�ӿ��ļ�Դ������Կ���,Entry<>����Map�ӿ��ڲ����ڲ��ӿ�(�������ڲ���)��Ƕ�׶���;Entry<>�ڲ�ֻ���������ɸ����󷽷�(������̬�ͷǾ�̬��)����K getKey()������V getValue()����(�ֱ𷵻�K����ֵ��V����ֵ)*/
        Set<Map.Entry<String, Integer>> distinctSet2 = map2.entrySet();/*ֵ��ע�����set��Ϊ��׺���η�����ʱ��,һ����ָȡ��ĳ������������������ļ���(��Set�����������Ϊ����֮��˼);����set��Ϊ��������ǰ׺,�Ǿ��Ƕ���(����(ֵ))����˼.
        java.util public static �ӿ� Map.Entry<K, V>��һ����̬���ڲ��ӿ�,���ⲿ�ӿ���Map.Entry�����ʵ�;
        ��ô���������,��Ҫ��дMap.Entry<>�ӿ��е������󷽷���? ������Ҫ,
        ��Ϊ�����Map.Entry<>û������ʵ����(new)������,������Ϊһ��������ֻ��Set�е�Ԫ�ص�������;
        �����ͬ:Comparator<String> test;�����һ��,ֻ����һ����������,���ýӿ���ʵ���������ʱ���ǲ��ý��ӿ��г��󷽷�ʵ�ֳ�����;*/
        System.out.println(distinctSet2.getClass().getName());

        for (Map.Entry<String, Integer> entry : distinctSet2) {//entry:��¼/��Ŀ/���
            /*java.util public static �ӿ� Map.Entry<K, V>
            * IDEA��ʾ���,������Map�ļ���Entry�ڲ��ӿ�û����˵�Ǿ�̬�ӿ�
            * Ȼ���㷢��û��,Entry��ͨ���ӿ���Mapֱ�ӵ���,������ĳ����������õ�(��������һ���ڲ��ӿڵ�˵���ñ�Ť)*/
            //System.out.println("entry��������͵ĸ���:"+entry.getClass().getSuperclass().getName()+"\n entry���������:"+entry.getClass().getName());
            /*entry��������͵ĸ���:java.lang.Object
            entry���������:java.util.HashMap$Node*/
            //System.out.println(entry instanceof Map.Entry<String, Integer>);�޷��Ƚ�
            String key = entry.getKey();
            Integer value = entry.getValue();/*�˴����õ���HashMap���е�getValue()����,��Ϊmap2����HashMap()������ʵ�ֵ�,��HashMap implements��Map�ӿ�,���̬��?
            Map��java�еĽӿڣ�Map.Entry��Map��һ���ڲ��ӿڡ�
Map�ṩ��һЩ���÷�������keySet()��entrySet()�ȷ�����
keySet()��������ֵ��Map��keyֵ�ļ��ϣ�entrySet()�ķ���ֵҲ�Ƿ���һ��Set���ϣ��˼��ϵ�����ΪMap.Entry��
Map.Entry��Map������һ���ڲ��ӿڣ��˽ӿ�Ϊ���ͣ�����ΪEntry<K,V>������ʾMap�е�һ��ʵ�壨һ��key-value�ԣ����ӿ�����getKey(),getValue������
�˴����Բο�:https://www.cnblogs.com/zhusf/p/10572279.html*/
            System.out.println(key + " = " + value);
        }

        /*�Ա�KeySet()������entrySet()����:
        *ǰ�� Returns a Set view of the keys
        * ���� Return a Set view of the mappings */
/*Map��List��ͬ���ǣ�Map�洢����key-value��ӳ���ϵ�����ң�������֤˳���ڱ�����ʱ�򣬱�����˳��Ȳ�һ����put()ʱ�����key��˳��Ҳ��һ����key������˳��ʹ��Mapʱ���κ�����˳����߼����ǲ��ɿ��ġ���HashMapΪ�����������Ƿ���"A"��"B"��"C"��3��key��������ʱ��ÿ��key�ᱣ֤������һ���ҽ�����һ�Σ���˳����ȫû�б�֤���������ڲ�ͬ��JDK�汾����ͬ�Ĵ�����������˳���ǲ�ͬ�ģ�*/
    }//main()/psvm

}//class Demo

class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

