package study.collection;
import java.util.LinkedList;/*同样是implements java.util.Link*/
import java.util.ArrayList;/*(基于数组实现的列表类)implements java.util.List->extends java.util.Collection->extends Iterable*/
import java.util.Collection;/*The root interface in the collection hierarchy n.[?ha??rɑ?ki]美 [?ha??rɑ?rki] 层级；等级制度.
Collecton包是爷爷级别的类*/

public class CollectionDemo {

    public static void main(String[] args) {
//创建集合对象
//使用多态形式
        Collection<String> coll=new ArrayList<String>();
// 添加元素
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        System.out.println(coll); //[小李广, 扫地僧, 石破天]

//boolean contains(E e) 判断o是否在集合中存在
        System.out.println("判断 扫地僧 是否在集合中: "+coll.contains("扫地僧"));
// 判断 扫地僧 是否在集合中: true

//boolean remove(E e) 删除集合中的e元素
                System.out.println("删除石破天："+coll.remove("石破天"));
// 删除石破天：true
                        System.out.println("删除后集合中的元素："+coll);
// 删除后集合中的元素：[小李广, 扫地僧]
//void clear() 清空集合
                                coll.clear();
        System.out.println("集合中元素为："+coll);
// 集合中元素为：[]

// boolean isEmpty() 判断是否为空
        System.out.println(coll.isEmpty());
// true

    }

}
