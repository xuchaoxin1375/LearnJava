package regex.extractStringsTester;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 11:11 AM
 * @Version 1.0
 */
public class ExtractString {
    /**
     * 在获取需要被分析并提取的字符串之后,将字符串参数传入到该函数中,同时,用户还需指定正则表达式形式的分割符
     * 该方法将返回一个处理结果构成的列表.
     * @param ToAnalyzeString
     * @param regexString
     * @return List<String> </String>
     */
    public static List<String> extract(String ToAnalyzeString, String regexString) {
        Matcher matcher = Pattern.compile(regexString).matcher(ToAnalyzeString);
        List<String> list=new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
            //System.out.println(matcher.group());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(extract(ToAnalyzeStrings.s2, RegexStrings.regex2));
    }
}
