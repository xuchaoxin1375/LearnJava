package study.collection;
/*List转换为Array(方法1)*/
import java.util.List;

public class ListToArray1 {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        /*调用toArray()方法直接返回一个Object[]数组：*/
        Object[] array = list.toArray();/*一定要求是Object[]数组的引用变量来接受toArray()返回的结果*/
        /*如果直接用System.out.println(打印数组引用,那么只能打印地址...)*/
        //System.out.println(array);
        /*所以想要遍历数组只能用循环来(推荐用迭代器的增强型for()*/
        for (Object s : array) {
            System.out.println(s);
        }
    }
}

