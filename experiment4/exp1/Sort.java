

/*
* .�Ӽ�����?����ַ���������Щ�ַ������ֵ������������ʽ�����֣�
��ʽһ�������ַ�����һ�У��м��ÿո�������磺
could not find or load main class hadoop
*
��ʽ����ÿ������һ���ַ����������-1��ʾ����������磺
could
not
find
or
load
main
class
Hadoop
-1
�����顢ArrayListʵ�־��ɡ��������ʹ��Collections.sort(List<T>
list)������List��������;*/
/*�ο��������ݵķ���:
JAVA����һ�пո����������
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //�Զ������һ��������split()����
        String ss[] = s.split(" ");

        for (String x : ss) {
            System.out.println(x);
        }
    }
}
*/
package experiment4.exp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String[] aString = new String[100];
        String tmp = sc.nextLine();/*���������е������ַ�������*/
        String[] aString = tmp.split(" ");/*tmp.split(" ")������һЩ�е�Ԫ��,װ������aString,����Ĵ�СΪsplit�������Ԫ����Ŀ*/
        /*ʹ����ǿ��for�鿴�Ƿ�ɹ�split*/
   /*     for (String i : aString) {
            System.out.println(i);
        }*/
        /*Additionally  IDEA support the traverse in reverse :Forr*/

//Arrays.stream(aString).sorted();
        Arrays.sort(aString);
        /**
         * java.util.Arrays @Contract(mutates = "param1")
         * public static void sort(@NotNull Object[] a)
         * Sorts the specified array of objects into ascending order, according to the natural ordering of its elements. All elements in the array must implement the Comparable interface. Furthermore, all elements in the array must be mutually comparable (that is, e1.compareTo(e2) must not throw a ClassCastException for any elements e1 and e2 in the array).
         * This sort is guaranteed to be stable: equal elements will not be reordered as a result of the sort.*/

        List<String> list=new ArrayList<>();

       for(String x:aString){
            list.add(x);
        }
        //for (String i : aString) System.out.println(i);
        System.out.println(list);
    }
}
