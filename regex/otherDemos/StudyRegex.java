package regex.otherDemos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xuchaoxin
 * @Date 12/19/2020 10:51 PM
 * @Version 1.0
 */
public class StudyRegex {
    public static void main(String[] args) {
        String testString="the quick brown fox jumps over the lazy dog";
        //Ҳ����һ�仰�õ�һ��ƥ����
        Matcher matcher=Pattern.compile("\\w+").matcher(testString);
//        while (matcher.find()){
//            System.out.println(matcher.group());
//        }
        //testString.replaceAll();

       /* String testString2="a      + b       cd d";
        String[] split = testString2.split("\\s+");
        List<String> list= new ArrayList<>();
        for (String x :
                split) {
            //System.out.println(x);
            list.add(x);
        }
        System.out.println(list);*/
    }
}
