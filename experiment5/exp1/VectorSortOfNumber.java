package experiment5.exp1;

import java.util.*;

/*�Ӽ�����??����������?Vector�У��ٽ���ֱ��������С����������С�������ֵ��С�������С�(Ҫ��ʹ��Comparatorʵ��)*/
public class VectorSortOfNumber {
    public static void main(String[] args) {
        System.out.println("������һ������:");
        Scanner sc =new Scanner(System.in);
        Vector vector=new Vector();
        String tmp = sc.nextLine();
        String [] strings=tmp.split(" ");/*java.lang.String @NotNull @Contract(pure = true)
public String[] split(@NotNull String regex)
*/
        /* ���ַ��������е������ַ�������תΪ����,add��vector��*/
        for(String x:strings){
            vector.add(Integer.parseInt(x));
        }
        /*��ӡ����Ƿ�������ӵ�vector��:*/
/*        Iterator<Integer> it=vector.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }*/
        Collections.sort(vector,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("����������:\n"+vector);
        //����
        Collections.sort(vector, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println("����������:\n"+vector);
        Collections.sort(vector, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1)-Math.abs(o2);
            }
        });
        System.out.println("������ֵ��������:\n"+vector);
    }
}
/*��������:
-233 5627 -34 121 45 -3600

* */