package experiment4.exp2;
/*定义一个维数组，其中存储随机成的1000个1~100以内的整数，统计每个整数出现的次数:*/
import java.util.*;

public class RandomNumberFrequency {
    public static void main(String[]args) {
        Random r = new Random();
        int[]cnt=new int[101];
        int num;
        //Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            num=r.nextInt(100) + 1;
            cnt[num]++;

        }
        for(int i=1;i<101;i++ ){
            System.out.println("整数"+i+"出现次数:"+cnt[i]);

        }
    }
}
