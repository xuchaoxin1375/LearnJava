package acmInJava.climbStairs;

/**
 * @Author xuchaoxin
 * @Date 2020/12/26 18:41
 * @Version 1.0
 */
public class RecursionWithDictionary {
    static int[] recursionWithDictionary(){
        int[] dictionary = new int[41];
        dictionary[1] = 1;
        dictionary[2] = 2;
        for (int i = 3; i < 41; i++) {
            dictionary[i]=dictionary[i-1]+dictionary[i-2];
        }
        return dictionary;
    }
    static  int recursionWithDictionary(int stair){
        return recursionWithDictionary()[stair];
    }
}
