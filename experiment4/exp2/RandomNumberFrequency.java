package experiment4.exp2;
/*����һ��ά���飬���д洢����ɵ�1000��1~100���ڵ�������ͳ��ÿ���������ֵĴ���:*/
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
            System.out.println("����"+i+"���ִ���:"+cnt[i]);

        }
    }
}
