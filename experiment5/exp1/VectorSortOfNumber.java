package experiment5.exp1;

import java.util.*;

/*从键盘输??串整数，存?Vector中，再将其分别按升序排列、按降序排列、按绝对值大小升序排列。(要求使用Comparator实现)*/
public class VectorSortOfNumber {
    public static void main(String[] args) {
        System.out.println("请输入一串整数:");
        Scanner sc =new Scanner(System.in);
        Vector vector=new Vector();
        String tmp = sc.nextLine();
        String [] strings=tmp.split(" ");/*java.lang.String @NotNull @Contract(pure = true)
public String[] split(@NotNull String regex)
*/
        /* 将字符串数组中的数字字符串挨个转为数字,add到vector中*/
        for(String x:strings){
            vector.add(Integer.parseInt(x));
        }
        /*打印检查是否将数字添加到vector中:*/
/*        Iterator<Integer> it=vector.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }*/
        Collections.sort(vector,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("按升序排列:\n"+vector);
        //降序
        Collections.sort(vector, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("按降序排列:\n"+vector);
        Collections.sort(vector, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1)-Math.abs(o2);
            }
        });
        System.out.println("按绝对值升序排列:\n"+vector);
    }
}
/*测试数据:
-233 5627 -34 121 45 -3600

* */