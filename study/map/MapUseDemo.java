package study.map;
/*计算一个字符串中每个字符出现次数
分析：
1. 获取一个字符串对象
2. 创建一个Map集合，键代表字符，值代表次数
3. 遍历字符串得到每个字符
4. 判断Map中是否有该键
5. 如果没有，第一次出现，存储次数为1；如果有，则说
明已经出现过，获取到对应的值进行++，再次存储
6. 打印最终结果*/
import java.util.HashMap;
import java.util.Scanner;
public class MapUseDemo {

    public static void main(String[] args) {
        System.out.println("请录入一个字符串:");
        String line = new Scanner(System.in).nextLine();/*读入该字符串行*/
// 调用所定义的统计每个字符出现次数的(静态)方法
        findChar(line);
    }
    /*在public class中 定义一个静态方法:findChar*/
    private static void findChar(String line) {
//1:创建一个映射集合map对象,存储字符以及其出现的次数
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//2:遍历字符串
        /*java.lang.String @Contract(pure = true)
public int length()
Returns the length of this string. The length is equal to the number of Unicode code units in the string.*/
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);//在for中定义char c;
//判断该字符是否在键集中
            if (!map.containsKey(c)) {//说明这个字符没有出现过,那就是第一次,那么就将它添加到键值对集合map中
                map.put(c, 1);
            } else {
/*//先获取之前的次数
                Integer count = map.get(c);
                count++;*/
//存入更新
                map.put(c, map.get(c)+1);
            }
        }
        System.out.println(map);
    }

}
/*
请录入一个字符串:
rwhithiwjroi0q3og-kgofksf
{f=3, g=3, h=3, i=5, j=1, k=3, -=1, o=5, 0=1, q=1, r=3, 3=1, s=1, t=1, w=3}
* */