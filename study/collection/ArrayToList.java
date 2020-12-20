package study.collection;
/*数组转换为列表:list.of()*/
import java.util.List;

public class ArrayToList {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        /*List.of()，它返回的是一个只读List：*/
        List<Integer> list = List.of(array);
        List<Integer> list2 = List.of(12, 34, 56);
        /*list.add(999);//Exception in thread "main" java.lang.UnsupportedOperationException
        list2.add(999);*/ // UnsupportedOperationException的异常会在运行是抛出
        /*Exception in thread "main" java.lang.UnsupportedOperationException(运行过程中报的错误:第一行的黑子是要点)
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:127)
	at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add  (这里的$应该是内部类(类中类)的标志)
	at ArrayToList.main(ArrayToList.java:11)*/
    }
}

