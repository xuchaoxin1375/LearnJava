package experiment4.exp3;

import java.text.DecimalFormat;
import java.util.*;

/*ģ��33ѡ6˫ɫ��
��Ʊ�����С��������(ע�⵽set�������,�����б�)
������ArrayList�洢˫ɫ��ģ��33ѡ6˫ɫ��
*/
public class DualColoredBall {
    public static void main(String[] args) {
        Random r=new Random();
        Set<Integer> set=new HashSet<>();

        Scanner sc=new Scanner(System.in);
        System.out.println("�������ѡ����:");
        int num=sc.nextInt();
        int k=0;
        for(int i = 0;i<num;i++){
            k=0;
            for(k=0;k<6;){
                if(set.add(r.nextInt(33)+1)){
                    k++;
                }

            }
            List<Integer> list=new ArrayList<>(set);
            Collections.sort(list);
            System.out.print("����:");
            for(int x:list){
                System.out.print(new DecimalFormat("00 ").format(x));

            }
            System.out.println(" ����:"+new DecimalFormat("00").format(r.nextInt(16) + 1));
            System.out.println();

            set.clear();
        }

    }
}
