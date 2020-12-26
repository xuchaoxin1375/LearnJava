package acmInJava.climbStairs;

import java.util.Scanner;

/**
 * Redraiment小时候走路喜欢蹦蹦跳跳，他最喜欢在楼梯上跳来跳去。 但年幼的他一次只能走上一阶或者一下子蹦上两阶。 现在一共有N阶台阶，请你计算一下Redraiment从第0阶到第N阶共有几种走法。
 * 输入
 * 输入包括多组数据。 每组数据包括一行:N(1≤N≤40)。 输入以0结束。
 * <p>
 * 输出
 * 对应每个输入包括一个输出。 为redraiment到达第n阶不同走法的数量。
 * <p>
 * 样例输入
 * 1
 * 2
 * 0
 * 样例输出
 * 1
 * 2
 *
 * @Author xuchaoxin
 * @Date 2020/12/26 18:25
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*to deprecate the index 0 to make the corresponding arguments */

        //(new RecursionWithDictionary())
        /*through the specified object of certain class's static method is not good to read;
         * in the occasion, the IDEA doesn't easy to prompt you it has which
         * methods modified by static */
        // RecursionWithDictionary deal=new RecursionWithDictionary();
        /*only one Scanner stream is enough to read data*/
        Scanner scanner = new Scanner(System.in);
        int stairN;
        do {
            /*attention ! do {} not do()!*/

            stairN = scanner.nextInt();
            if(stairN==0){
                break;
            }
            System.out.println(RecursionWithDictionary.recursionWithDictionary(stairN));
        } while (stairN != 0);

        /*use while(true)..break structure is similar to do..while()'s simple/concise*/
        while (true) {
            stairN = scanner.nextInt();
            if (stairN == 0) {
                break;
            } else {
                System.out.println(RecursionWithDictionary.recursionWithDictionary(stairN));
            }
        }

    }
}

