package acmInJava.climbStairs;

import java.util.Scanner;

/**
 * RedraimentСʱ����·ϲ���ı�����������ϲ����¥����������ȥ�� �����׵���һ��ֻ������һ�׻���һ���ӱ������ס� ����һ����N��̨�ף��������һ��Redraiment�ӵ�0�׵���N�׹��м����߷���
 * ����
 * ��������������ݡ� ÿ�����ݰ���һ��:N(1��N��40)�� ������0������
 * <p>
 * ���
 * ��Ӧÿ���������һ������� Ϊredraiment�����n�ײ�ͬ�߷���������
 * <p>
 * ��������
 * 1
 * 2
 * 0
 * �������
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

