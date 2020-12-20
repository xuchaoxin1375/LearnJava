package map_and_hash;

public class ArrayAndObject {
  /*  //1     在test1()中已经测试得到以下结论: 数组也是对象, 数组的顶层父类是Object, 所以可以向上转型
    int[] a = new int[8];
    Object obj = a; //数组的父类也是Object,可以将a向上转型到Object
    int[] b = (int[]) obj;  //可以进行向下转型*/
  /*  if(obj instanceof Object )//少年,这里定义类成员的地方,不是成员方法内部代码该出现的地方:(当出现莫名的错误时要记起来这一点);
    {  //可以用instanceof关键字进行类型判定 (对象 instanceof 类)
        System.out.println("obj的真实类型是int[]");
    }*/

    /*psvm快捷键:*/
  public static void main(String[] args) {
      //1     在test1()中已经测试得到以下结论: 数组也是对象, 数组的顶层父类是Object, 所以可以向上转型
      int[] a = new int[8];
      Object obj = a ; //数组的父类也是Object,可以将a向上转型到Object

      //2     那么能向下转型吗?
      int[] b = (int[])obj;  //可以进行向下转型

      //3     能使用instanceof关键字判定吗?
      if(obj instanceof int[]&&a instanceof  int[] ){  //可以用instanceof关键字进行类型判定
          System.out.println("obj的真实类型是int[]");
          /*Java中数组的另一种“继承”关系*/

          /*如下代码是正确的，却很容易让我们疑惑：*/
          String[] s = new String[5];
          Object[] obja = s;   //成立,说明可以用Object[]的引用来接收String[]的对象
          /*Object[]类型的引用可以指向String[]类型的数组对象？ 由上文的验证可以得知数组类型的顶层父类一定是Object，那么上面代码中s的直接父类是谁呢？难道说String[]继承自Object[]，而Object[]又继承自Object? 让我们通过反射的方式来验证这个问题：*/
          //那么String[] 的直接父类是Object[] 还是 Object?;我们打印父类看一下
          System.out.println(s.getClass().getSuperclass().getName());//结果:java.lang.Object

      }
  }
}
