package experiment4.exp4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*��ʼ��һ������ 5 ��������飬
��дcompareTo(E)����������Ԫ�ظ��ݵ�ԭ��ľ����?����

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
        Collections.sort(lst);/*ͨ��ʵ��comparable<>�е�compareTo����,�ڵ���Collections.sort()����ֻ��Ҫ����lst��һ����������ļ��ϼ���(
        ��Ҳ����û��ʵ��comparator�ӿڵıȽ�������ʱĬ�ϵ��õķ���(comparable<>�е�comparaTo����)*/
        for(int i = 0;i<5;i++){
            System.out.println(lst.get(i).distance());
        }
        /*System.out.println(lst);*/

    }

}
