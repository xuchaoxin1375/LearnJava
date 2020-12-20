package experiment4.exp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class SortEachLine {
    public static void main(String [] args){

        /*建议列表来操作(往往使用泛型列表)<>*/
        List<String> list=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        /*
        for(int i = 0; !aString[i].equals("-1"); i++);
        Cannot invoke "String.equals(Object)" because "aString[i]" is null
	at SortEachLine.main(SortEachLine.java:10)
	*/
        //System.out.println("enter  data:");
        boolean b;
/*  */      do{

            String tmp=sc.nextLine();
            if(!tmp.equals("-1")){
                list.add(tmp);
            }
            else
                break;
        }while (true);
    /*    //不知为何,用for总是会陷入死循环
    for(int i = 0; !"-1".equals(aString[i]); i++){
            System.out.println("enter a data:");
            aString[i]=sc.nextLine();
        }*/
        /*使用大小不刚好的数组的话,在使用sort方法的时候出现错误:
        Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "a[runHi]" is null
	at java.base/java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
	at java.base/java.util.ComparableTimSort.sort(ComparableTimSort.java:202)
	at java.base/java.util.Arrays.sort(Arrays.java:1040)
	at SortEachLine.main(SortEachLine.java:27)*/

        Collections.sort( list);
        System.out.println(list);

/*  迭代逐行输出列表中元素;
    for(String x:list){
            System.out.println(x);
        }*/
    }
}


