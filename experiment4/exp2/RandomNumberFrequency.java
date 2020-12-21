package experiment4.exp2;
/*����һ��ά���飬���д洢����ɵ�1000��1~100���ڵ�������ͳ��ÿ���������ֵĴ���:*/
import java.util.*;

public class RandomNumberFrequency {
    public static void main(String[]args) {
        Random r = new Random();
        /**
         * Creates a new random number generator. This constructor sets the seed of the random number generator to a value very likely to be distinct from any other invocation of this constructor.
         *
         * ����һ���µ���������������˹��캯�������������������������Ϊһ��ֵ����ֵ�ܿ�����˹��캯�����κ��������ò�ͬ��*/
        int[]cnt=new int[101];
        int num;
        //Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            /*the Random object just need be instantiate once */
            num=r.nextInt(100) + 1;
            /**
             * java.util.Random public int nextInt(@Range(from = 1, to = Integer.MAX_VALUE) int bound)
             * */
            cnt[num]++;
        }
        for(int i=1;i<101;i++ ){
            System.out.println("����"+i+"���ִ���:"+cnt[i]);
        }
    }
}
