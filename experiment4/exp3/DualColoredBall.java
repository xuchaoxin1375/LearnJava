package experiment4.exp3;

import java.text.DecimalFormat;
import java.util.*;

/*模拟33选6双色球，
彩票号码从小到大排序，(注意到set是无序的,宜用列表)
可以用ArrayList存储双色球模拟33选6双色球，
*/
public class DualColoredBall {
    public static void main(String[] args) {
        /*instantiate a Random object*/
        Random r = new Random();
        Set<Integer> set = new HashSet<>();
        /*read in input(a integer) form console :*/
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机选柱数:");
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

            System.out.print("红球:");
            for (int x : list) {
                System.out.print(new DecimalFormat("00 ").format(x));

            }
            System.out.println(" 蓝球:" + new DecimalFormat("00").format(r.nextInt(16) + 1));
            System.out.println();

            set.clear();
        }

    }
}
