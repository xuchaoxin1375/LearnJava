package study.collection;
/*List转换为Array(方法2)*/
import java.util.List;

public class ListToArray2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(12, 34, 56);/*这里创建了一个包含三个元素的列表list(里头的元素都是Integer)*/
        /*java.util.List<E> @NotNull
public abstract <T> T[] toArray(@NotNull T[] a) ;可见,toArray是一个普通类(非泛型类)里定义的泛型方法*/
        /*Integer类:
        java.lang public final 类 Integer extends Number*/
        /*给toArray(T[])传入一个类型(和list中的元素类型)相同的Array(数组大小自然要生成(new)数组对象时规定好,可以是，List内部自动把元素复制到传入的Array中：*/
        //Integer[] array = list.toArray(new Integer[3]);
        /*这里的LHS部分并没有分配空间,array引用变量只是接收toArray()的处理结果,只是做了声明工作而已RHS的new操作申请了空间(new Integer[3],匿名的数组空间),*/
        /*更为合适的方式：（即，将具体数字3用list。size（）来代替）*/
        Integer[] array = list.toArray(new Integer[list.size()]);
        for (Integer n : array) {
            System.out.println(n);
        }
        /*被继承的类一般称为“超类”，也有叫做父类
        * The abstract class Number is the superclass of platform classes representing numeric values that are convertible可转换的 to the primitive types byte, double, float, int, long, and short. The specific semantics of the conversion from the numeric value of a particular Number implementation to a given primitive type is defined by the Number implementation in question. For platform classes, the conversion is often analogous to a narrowing primitive conversion or a widening primitive conversion as defined in The Java Language Specification for converting between primitive types. Therefore, conversions may lose information about the overall magnitude of a numeric value, may lose precision, and may even return a result of a different sign than the input. See the documentation of a given Number implementation for conversion details.
抽象类Number是平台类的超类，代表可转换为原始类型byte，double，float，int，long和short的数值的平台值。 从特定Number实现的数值到给定原始类型的转换的特定语义由所讨论的Number实现定义。 对于平台类，转换通常类似于Java语言规范中定义的在原始类型之间进行转换的变窄基元转换或变宽基元转换。 因此，转换可能会丢失有关数值总大小的信息，可能会丢失精度，甚至可能返回与输入不同的符号结果。 有关转换的详细信息，请参见给定Number实现的文档。*/
        /*这里用Integer的父类Number类也可以:*/
        Number[] array1 = list.toArray(new Number[3]);
        for (Number n : array1) {
            System.out.println(n);
        }
    }
}
/*如果我们传入的数组大小和List实际的元素个数不一致怎么办？根据List接口的文档，我们可以知道：

如果传入的数组不够大，那么List内部会创建一个新的刚好够大的数组，填充后返回；如果传入的数组比List元素还要多，那么填充完元素后，剩下的数组元素一律填充null。

实际上，最常用的是传入一个“恰好”大小的数组：*/