package acmInJava.horseRace;

/**
 * @Author xuchaoxin
 * @Date 2020/12/23 23:24
 * @Version 1.0
 */
import java.util.*;
public class Main {
//ѡ������:
    public static int[] selectionSort(int[] array, int len) {
        if ( len <= 1) {
            return array;
        }
        for (int i = 0; i < len - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < len; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = tmp;
            }
        }
        return array;
    }

    public static void getSC(Scanner scanner,int s[],int count){
        String line = scanner.nextLine();
        String[] s1 = line.split(" ");
        for (int j = 0; j < count; j++) {
            s[j] = Integer.valueOf(s1[j]);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        count = Integer.valueOf(scanner.nextLine());

        int temp = 0;
        int[] s = new int[1000];
        int[] d = new int[1000];

        while (count != 0) {
            getSC(scanner,s,count);
            getSC(scanner,d,count);

            s = selectionSort(s, count);
            d = selectionSort(d, count);

            if (count % 2 == 0) {
                /*�м���ʼ��*/
                for (int i = count / 2 - 1; i < count; i++) {
                    if (s[i] <= d[temp]) {
                        //һ��һ���ϵ�������������������.
                        System.out.println("NO");
                        break;
                    } else {
                        temp++;
                    }
                }
                if (temp == count / 2 + 1) {
                    System.out.println("YES");
                }
            } else {/*�������������*/
                for (int i = count / 2; i < count; i++) {
                    if (s[i] <= d[temp]) {
                        System.out.println("NO");
                        break;
                    } else {
                        temp++;
                    }
                }
                if (temp == count / 2 + 1) {
                    System.out.println("YES");
                }
            }
            temp = 0;
            count = Integer.valueOf(scanner.nextLine());
        }
    }
}
