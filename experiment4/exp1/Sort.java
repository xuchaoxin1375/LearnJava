

/*
* .从键盘输?多个字符串，对这些字符串按字典序排序。输入格式有两种：
格式一：输入字符串在一行，中间用空格隔开，如：
could not find or load main class hadoop
*
格式二：每行输入一个字符串，最后用-1表示输入结束，如：
could
not
find
or
load
main
class
Hadoop
-1
用数组、ArrayList实现均可。排序可以使用Collections.sort(List<T>
list)方法对List进行排序;*/
/*参考读入数据的方法:
JAVA读入一行空格隔开的数据
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //对读入的那一整行在作split()操作
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
        String tmp = sc.nextLine();/*读入数据行到缓冲字符串区中*/
        String[] aString = tmp.split(" ");/*tmp.split(" ")将产生一些列的元素,装入数组aString,数组的大小为split后产生的元素数目*/
        /*使用增强型for查看是否成功split*/
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
