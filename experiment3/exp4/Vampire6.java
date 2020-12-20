package experiment3.exp4;

import java.util.Arrays;

public class Vampire6 {
    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {
            //i表示第一个两位数a
            for (int j = 100; j < 1000; j++) {
                //j表示第二个两位数b
                int product = i * j;
                //获得乘积v=ab
                if (product % 100 != 0 && product >= 100000 && product <= 999999) {
                    /*调用String类中的静态方法:public static String valueOf(int i);
                     * 其参数为int类型;返回值为String类型*/
                    /*把数字转换为字符串，然后在以空格分割为数组(调用
                     public String[] split(@NotNull String regex)):(调用方法链)*/
                    String[] value1 = String.valueOf(product).split("");
                    String[] value2 = (String.valueOf(i) + String.valueOf(j)).split("");
                    /*为两个带比较序列排序,以便对比原序列字符构成是否完全相同*/
                    Arrays.sort(value1);
                    Arrays.sort(value2);

                    if (Arrays.equals(value1, value2)) {
                        System.out.println(product + "=" + i + "*" + j);
                        //打印吸血鬼数
                    }
                }
            }
        }
    }

}

