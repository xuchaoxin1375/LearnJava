package acmInJava.horseRace;

import myUtils.IntStringsToInts;

import java.util.Arrays;
import java.util.Scanner;

public class HorseRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            //
            //int numberHorseN = scanner.nextInt();
            int numberHorseN = Integer.parseInt(scanner.nextLine());
            if (numberHorseN == 0) {
                break;
            }

            int[] YuanziHorseSpeeds = IntStringsToInts.intStringsToInts(scanner.nextLine());

            int[] KingHorseSpeeds = IntStringsToInts.intStringsToInts(scanner.nextLine());

            Arrays.sort(YuanziHorseSpeeds);
            Arrays.sort(KingHorseSpeeds);

            /*the algorithm */
            int winCounts = 0;

            for (int i = 0; i < numberHorseN; i++) {//king
                for (int i1 = 0; i1 < numberHorseN; i1++) {//yuanzi
                    if (YuanziHorseSpeeds[i1] > KingHorseSpeeds[i]) {
                        winCounts++;
                        YuanziHorseSpeeds[i1] = -1;//to ensure that the horse would never to win for YuanZi once more.
                        KingHorseSpeeds[i] = -1;
                        break;
                    }
                }
            }
            int loseCounts = 0;
            int j = 0;
            for (int i = 0; i < numberHorseN; i++) {//yuanzi
                int indexOfYuanzi = numberHorseN - 1 - i;
                if (YuanziHorseSpeeds[indexOfYuanzi] == -1) {
                    continue;
                }
                /*it's hard to solve the problem by means of only one for_loop
                 * we introduce a second for_loop*/
                for (; j < numberHorseN; j++) {//king
                    // boolean bool=KingHorseSpeeds[i]!=-1&&YuanziHorseSpeeds[indexOfYuanzi]!=-1;
                    if (KingHorseSpeeds[j] == -1) {
                        continue;
                    }
                    if(YuanziHorseSpeeds[indexOfYuanzi]<KingHorseSpeeds[j]){
                        loseCounts++;
                    }
                    YuanziHorseSpeeds[indexOfYuanzi]=-1;
                    KingHorseSpeeds[j]=-1;
                    break;
                }
            }//for
            if (winCounts>loseCounts) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }//while

    }

}

