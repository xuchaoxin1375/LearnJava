package study.collection;

import java.util.List;
public  class TraversePrimitive {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);//����ͨ��get(int index)������list�е�Ԫ��;
            System.out.println(s);
        }
    }
}

