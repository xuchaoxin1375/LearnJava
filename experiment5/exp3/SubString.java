package experiment5.exp3;

import java.util.*;

/*从键盘输入一个任意的字符串（如：aaabbababaaaababababa），统计该字符串中长度为i的子串出现次数（i从1开始到上述字符串长度结束）。提示：可使用HashMap实现。*/
public class SubString {
    public static void main(String[] args) {

        String line = new Scanner(System.in).nextLine();
        /*自读取一次数据,可以用匿名的Scanner对象来读取数据,并直接将内容返回个line字符串*/
        /*定义个统计次数的静态方法*/
        count(line);

    }

    private static void count(String line) {
        Map<String, Integer> map = new HashMap<>();
        String tmp;
        //System.out.println("枚举所有子串:(包括重复出现的)");
        /*参看:https://blog.csdn.net/xuchaoxin1375/article/details/109545953*/
        for (int i = 0; i < line.length(); i++) {
            for (int j = i + 1; j <= line.length(); j++) {
                if (!map.containsKey(tmp = line.substring(i, j))) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);/*//不用map.get(tmp)++,因为这个自增操作值不允许的,也是不必要的,
                    通过+1这个基础算数表达式已经足够,不需要用赋值的.*/
                }
            }
        }
        //System.out.println(map);
        Set<String> set = map.keySet();
        for (String x : set) {
            System.out.println(x + "=" + map.get(x));
        }
    }
}

