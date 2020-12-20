package study.collection;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
//添加元素
        /*头插法添加元素:*/
        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("eee");
        System.out.println("初始链表列表:"+link);
// 获取元素
        System.out.println("表头元素"+link.getFirst());
        System.out.println("表尾元素"+link.getLast());
// 删除元素
        System.out.println("删除表头"+link.removeFirst());
        System.out.println("删除表尾"+link.removeLast());
        while (!link.isEmpty()) { //判断集合是否为空
            System.out.println("弹出集合中的栈顶元素"+link.pop()); //弹出集合中的栈顶(链表头)元素
        }
        //System.out.println(link);
    }
}
