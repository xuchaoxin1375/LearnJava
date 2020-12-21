package experiment4.exp4.studyCompareTo;

import java.util.*;

/**
 * @Author xuchaoxin
 * @Date 12/21/2020 8:31 PM
 * @Version 1.0
 */
public class StudyCompareTo {
    static List<DoubleNumber> generateRandomDoubleList(Random random, int lenth) {
        List<DoubleNumber> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            list.add(new DoubleNumber(random.nextDouble() * 10));
        }
        return list;
    }

    public static void main(String[] args) {

        Random random = new Random();

        List<DoubleNumber> list = new ArrayList<>();
        List<DoubleNumber> list1=new ArrayList<>();
        Collections.sort(list=generateRandomDoubleList(random, 8));
        /*so,it couldn't just return (int) difference to compare double numbers */
        Collections.sort(list1=generateRandomDoubleList(random, 8), new Comparator<DoubleNumber>() {
            @Override
            public int compare(DoubleNumber o1, DoubleNumber o2) {
                return (int) (o1.number - o2.number);
            }
        });
        System.out.println(list);
        System.out.println(list1);
/*        for (DoubleNumber obj :
                list) {
            System.out.println(obj);
        }*/
    }
}
