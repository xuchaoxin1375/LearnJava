package study.collection;
/*Listת��ΪArray(����2)*/
import java.util.List;

public class ListToArray2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 34, 56);/*���ﴴ����һ����������Ԫ�ص��б�list(��ͷ��Ԫ�ض���Integer)*/
        /*java.util.List<E> @NotNull
public abstract <T> T[] toArray(@NotNull T[] a) ;�ɼ�,toArray��һ����ͨ��(�Ƿ�����)�ﶨ��ķ��ͷ���*/
        /*Integer��:
        java.lang public final �� Integer extends Number*/
        /*��toArray(T[])����һ������(��list�е�Ԫ������)��ͬ��Array(�����С��ȻҪ����(new)�������ʱ�涨��,�����ǣ�List�ڲ��Զ���Ԫ�ظ��Ƶ������Array�У�*/
        //Integer[] array = list.toArray(new Integer[3]);
        /*�����LHS���ֲ�û�з���ռ�,array���ñ���ֻ�ǽ���toArray()�Ĵ�����,ֻ������������������RHS��new���������˿ռ�(new Integer[3],����������ռ�),*/
        /*��Ϊ���ʵķ�ʽ������������������3��list��size���������棩*/
        Integer[] array = list.toArray(new Integer[list.size()]);
        for (Integer n : array) {
            System.out.println(n);
        }
        /*���̳е���һ���Ϊ�����ࡱ��Ҳ�н�������
        * The abstract class Number is the superclass of platform classes representing numeric values that are convertible��ת���� to the primitive types byte, double, float, int, long, and short. The specific semantics of the conversion from the numeric value of a particular Number implementation to a given primitive type is defined by the Number implementation in question. For platform classes, the conversion is often analogous to a narrowing primitive conversion or a widening primitive conversion as defined in The Java Language Specification for converting between primitive types. Therefore, conversions may lose information about the overall magnitude of a numeric value, may lose precision, and may even return a result of a different sign than the input. See the documentation of a given Number implementation for conversion details.
������Number��ƽ̨��ĳ��࣬�����ת��Ϊԭʼ����byte��double��float��int��long��short����ֵ��ƽֵ̨�� ���ض�Numberʵ�ֵ���ֵ������ԭʼ���͵�ת�����ض������������۵�Numberʵ�ֶ��塣 ����ƽ̨�࣬ת��ͨ��������Java���Թ淶�ж������ԭʼ����֮�����ת���ı�խ��Ԫת�������Ԫת���� ��ˣ�ת�����ܻᶪʧ�й���ֵ�ܴ�С����Ϣ�����ܻᶪʧ���ȣ��������ܷ��������벻ͬ�ķ��Ž���� �й�ת������ϸ��Ϣ����μ�����Numberʵ�ֵ��ĵ���*/
        /*������Integer�ĸ���Number��Ҳ����:*/
        Number[] array1 = list.toArray(new Number[3]);
        for (Number n : array1) {
            System.out.println(n);
        }
    }
}
/*������Ǵ���������С��Listʵ�ʵ�Ԫ�ظ�����һ����ô�죿����List�ӿڵ��ĵ������ǿ���֪����

�����������鲻������ôList�ڲ��ᴴ��һ���µĸպù�������飬���󷵻أ��������������ListԪ�ػ�Ҫ�࣬��ô�����Ԫ�غ�ʣ�µ�����Ԫ��һ�����null��

ʵ���ϣ���õ��Ǵ���һ����ǡ�á���С�����飺*/