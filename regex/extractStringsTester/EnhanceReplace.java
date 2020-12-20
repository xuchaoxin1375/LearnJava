package regex.extractStringsTester;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 9:33 AM
 * @Version 1.0
 */
public class EnhanceReplace {

    static void demo0() {
        String r = ToAnalyzeStrings.s0.replaceAll("\\s+", " ");
        System.out.println(r);
    }

    static void demo1() {

        String regex1 = "(-\\\\w|[a-z])+";/* _\\w+|[a-z]+  or  (-\\w|[a-z])+  or [[a-z]|_]\w+ */
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(ToAnalyzeStrings.s1);
        while (m.find()) {
            String sub = ToAnalyzeStrings.s1.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }

    /**
     * @param ToAnalyzeString
     * @param regexString
     */
    public static void testExtract(String ToAnalyzeString, String regexString) {
        Matcher matcher = Pattern.compile(regexString).matcher(ToAnalyzeString);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        //demo0();
        //demo1();
        testExtract(ToAnalyzeStrings.s2, RegexString.regex2);
    }
}
