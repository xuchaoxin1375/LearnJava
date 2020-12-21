package experiment4.exp2;
/*定义一个维数组，其中存储随机成的1000个1~100以内的整数，统计每个整数出现的次数:*/
import java.util.*;

public class RandomNumberFrequency {
    public static void main(String[]args) {
        Random r = new Random();
        /**
         * Creates a new random number generator. This constructor sets the seed of the random number generator to a value very likely to be distinct from any other invocation of this constructor.
         *
         * 创建一个新的随机数生成器。此构造函数将随机数生成器的种子设置为一个值，该值很可能与此构造函数的任何其他调用不同。*/
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
            System.out.println("整数"+i+"出现次数:"+cnt[i]);
        }
    }
}
