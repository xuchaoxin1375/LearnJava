package study.collection;
/*����ת��Ϊ�б�:list.of()*/
import java.util.List;

public class ArrayToList {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3};
        /*List.of()�������ص���һ��ֻ��List��*/
        List<Integer> list = List.of(array);
        List<Integer> list2 = List.of(12, 34, 56);
        /*list.add(999);//Exception in thread "main" java.lang.UnsupportedOperationException
        list2.add(999);*/ // UnsupportedOperationException���쳣�����������׳�
        /*Exception in thread "main" java.lang.UnsupportedOperationException(���й����б��Ĵ���:��һ�еĺ�����Ҫ��)
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:127)
	at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add  (�����$Ӧ�����ڲ���(������)�ı�־)
	at ArrayToList.main(ArrayToList.java:11)*/
    }
}

