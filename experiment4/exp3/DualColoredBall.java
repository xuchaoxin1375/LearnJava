package experiment4.exp3;

import java.text.DecimalFormat;
import java.util.*;

/*ģ��33ѡ6˫ɫ��
��Ʊ�����С��������(ע�⵽set�������,�����б�)
������ArrayList�洢˫ɫ��ģ��33ѡ6˫ɫ��
*/
public class DualColoredBall {
    public static void main(String[] args) {
        /*instantiate a Random object*/
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        /*read in input(a integer) form console :*/
        Scanner sc = new Scanner(System.in);
        System.out.println("�������ѡ����:");
        int num = sc.nextInt();

        int k ;
        for (int i = 0; i < num; i++) {
            /*This is a selective counting technique:
           for-loop with if
            * only need one variable we can make it .*/
            for (k = 0; k < 6; ) {
                if (set.add(r.nextInt(33) + 1)) {
                    k++;
                }
            }
            /**input a set to ArrayList() constructor.
             * make the set turn into a corresponding list */
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);

            System.out.print("����:");
            for (int x : list) {
                System.out.print(new DecimalFormat("00 ").format(x));

            }
            System.out.println(" ����:" + new DecimalFormat("00").format(r.nextInt(16) + 1));
            System.out.println();

            set.clear();
        }

    }
}
