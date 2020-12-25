package myUtils;

/**
 * @Author xuchaoxin
 * @Date 2020/12/23 17:46
 * @Version 1.0
 */
public class IntStringsToInts {
    public static int[] intStringsToInts(String intStrings) {
        /*universal read integer data method:*/
        String[] speedOfHorsesStrs = intStrings.split("\\s+");
        int lengthOfIntString = speedOfHorsesStrs.length;
        int[] ints = new int[lengthOfIntString];
        int indexOfInts = 0;
        for (String intStr : speedOfHorsesStrs) {
            ints[indexOfInts++] = Integer.parseInt(intStr);
        }
        return ints;
    }//intStringToINts()
}
