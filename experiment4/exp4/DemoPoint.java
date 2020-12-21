package experiment4.exp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*初始化一个包含 5 个点的数组，
重写compareTo(E)方法对数组元素根据到原点的距离进?排序。

List<Point> lst=new ArrayList<Point>();
Point p1=new Point(10, 5, 7);
Point p2=new Point(6, 15, 12);
Point p3=new Point(3, 7, 6);
Point p4=new Point(24, 15, 16);
Point p5=new Point(31, 17, 26);
*/
public class DemoPoint {
    public static void main(String []args){
        List<Point> lst=new ArrayList<Point>();
        Point p1=new Point(10, 5, 7);
        Point p2=new Point(6, 15, 12);
        Point p3=new Point(3, 7, 6);
        Point p4=new Point(24, 15, 16);
        Point p5=new Point(31, 17, 26);
        lst.add(p1);
        lst.add(p2);
        lst.add(p3);
        lst.add(p4);
        lst.add(p5);
        Collections.sort(lst);/*通过实现comparable<>中的compareTo方法,在调用Collections.sort()方法只需要传入lst这一个待被排序的集合即可(
        这也是在没有实现comparator接口的比较器对象时默认调用的方法(comparable<>中的comparaTo方法)*/
        for(int i = 0;i<5;i++){
            System.out.println(lst.get(i).distance());
        }
        /*System.out.println(lst);*/

    }

}
