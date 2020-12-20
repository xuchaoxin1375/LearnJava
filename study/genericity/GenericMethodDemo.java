package study.genericity;

class MyGenericMethod {
    /*类型参数用MVP来代表
    * 普通类中定义泛型方法:(在返回类型前指定类型参数)(在泛型类中的泛型方法则不必特地说明类型参数)*/
    public <MVP> void show(MVP mvp) {

        System.out.println(mvp.getClass());//获取对象参数的类型名,并打印
    }

    public <MVP> MVP show2(MVP mvp) {
        return mvp;
    }

}

public class GenericMethodDemo {

    public static void main(String[]args) {
// 创建对象
        MyGenericMethod mm = new MyGenericMethod();/*泛型类实例化对象的时候可以不人为地指定类型参数是什么,那么会有java默认指定为object;
        但一般是要指定一种具体类型(这种类型往往还有其子类,比容动物类集合;即可以多态地存储多个不同子类的对象(猫/狗...)*/
// 演示看方法提示
        mm.show("aaa");
        mm.show(123);
        mm.show(12.45);
    }

}