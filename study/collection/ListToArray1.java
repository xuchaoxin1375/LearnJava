package study.collection;
/*Listת��ΪArray(����1)*/
import java.util.List;

public class ListToArray1 {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        /*����toArray()����ֱ�ӷ���һ��Object[]���飺*/
        Object[] array = list.toArray();/*һ��Ҫ����Object[]��������ñ���������toArray()���صĽ��*/
        /*���ֱ����System.out.println(��ӡ��������,��ôֻ�ܴ�ӡ��ַ...)*/
        //System.out.println(array);
        /*������Ҫ��������ֻ����ѭ����(�Ƽ��õ���������ǿ��for()*/
        for (Object s : array) {
            System.out.println(s);
        }
    }
}

