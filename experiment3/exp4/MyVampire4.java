package experiment3.exp4;
/*
*吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到。
* 而这两位数字必须包含乘积的所有数字（顺序可以任意排序），(能够被100整除的数是不允许的
* */

/*
* 做全排列枚举(递归枚举)的话是比较复杂的,那由于这里的操作对象是数字,容易通过另一种方式:遍历来实现枚举
*   通过枚举所有两位数乘以两位数的情况,吸血鬼数的数字序列一定落在这些中情况中,
*
*  此外,比较两个由任意字符组成的序列中的字符种类及其相应的数目是否一致,可以先将序列中的字符排序,然后做相等性比较即可;这可比做全排列枚举比较序列的相等性要经济的多(至少简单了不少)
* 类型的算法:字母重排(序列)问题:https://blog.csdn.net/xuchaoxin1375/article/details/108568225
* */
import java.util.Arrays;
public class MyVampire4 {

    public static void main(String[] args) {
        for (int i = 10; i <100; i++) {
            //i表示第一个两位数a
            for (int j = 10; j < 100; j++) {
                //j表示第二个两位数b
                int product=i*j;
                //获得乘积v=ab
                if(product%100!=0&&product>999&&product<10000) {
                    /*调用String类中的静态方法:public static String valueOf(int i);
                    * 其参数为int类型;返回值为String类型*/
                    /*把数字转换为字符串，然后在以空格分割为数组(调用
                     public String[] split(@NotNull String regex)):(调用方法链)*/
                    String[] value1=String.valueOf(product).split("");
                    String[] value2=(String.valueOf(i)+String.valueOf(j)).split("");
                    /*为两个带比较序列排序,以便对比原序列字符构成是否完全相同*/
                    Arrays.sort(value1);
                    Arrays.sort(value2);

                    if (Arrays.equals(value1, value2)) {
                        System.out.println(product+"="+i+"*"+j);
                        //打印吸血鬼数
                    }
                }
            }
        }
    }

}
