package study.collection;

public class ArrayAndFor {

    public static void main(String[] args) {
        String[] str = new String[5];
        /*用迭代器(增强版的for()是无法修改对应的集合的元素的,最终str数组中任然没有内容;*/
        for (String myStr : str) {
            myStr = "好好学习，天天向上";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
/*

* 好好学习，天天向上
好好学习，天天向上
好好学习，天天向上
好好学习，天天向上
好好学习，天天向上
null
null
null
null
null*/