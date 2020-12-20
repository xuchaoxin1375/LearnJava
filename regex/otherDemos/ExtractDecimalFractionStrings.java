package regex.otherDemos;

import namesAndStrings.FileName;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDecimalFractionStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FileName.fileName3, Charset.forName("utf-8")));
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName.desktop));
        String line = "";

        line = (bufferedReader.readLine());
        /*获取匹配模式Pattern的实例对象：
        * 通过Pattern类的静态方法（传入regex字符串），由compile方法创建并返回一个Pattern实例
        * 这也是一种（间接）获取实例对象的方法*/
        Pattern pattern = Pattern.compile("(\\d+|)\\.\\d+");//注意，*不能单独使用（。*）可以;*要慎用，比如\\d* 不仅会匹配所有数，还包括空白符;匹配任何小数（包括省略了整数部分的小数）（用到了分组匹配)
        while (line != null) {
            /*匹配器对象：根据匹配模式类中的matcher方法，对传入的字符串进行处理，得到匹配器对象；
            该对象同样时通过调用方法来间接创建并获得。
            * 其类似于迭代器啦。*/
            Matcher matcher = pattern.matcher(line);
            /**
             * Creates a matcher that will match the given input against this pattern.
             *
             * @param  input
             *         The character sequence to be matched
             *
             * @return  A new matcher for this pattern
             *
             * public Matcher matcher(CharSequence input) {
             *                 if (!compiled) {
             *                     synchronized(this) {
             *                         if (!compiled)
             *                             compile();
             *                     }
             *                 }
             *                 Matcher m = new Matcher(this, input);
             *                 return m;
             *             }
             */

            /**
             * public java.util.regex.Matcher matcher(@NotNull CharSequence input)
             * Creates a matcher that will match the given input against this pattern.
             *
             * Params:
             * input – The character sequence to be matched
             * Returns:
             * A new matcher for this pattern
             */
            //System.out.println(line);
            /*根据生成的匹配器对象matcher，调用其find方法，扫描该对象*/
            while (matcher.find()) {
                /**
                 * java.util.regex.Matcher @Contract(mutates = "this")
                 * public boolean find()
                 * Attempts to find the next subsequence of the input sequence that matches the pattern.
                 * This method starts at the beginning of this matcher's region, or, if a previous invocation of the method was successful and the matcher has not since been reset, at the first character not matched by the previous match.
                 * If the match succeeds then more information can be obtained via the start, end, and group methods.
                 *
                 * Returns:
                 * true if, and only if, a subsequence of the input sequence matches this matcher's pattern
                 */
//                if(matcher.group().matches("\\S")){      }
                System.out.println(matcher.group());
                /**
                 * java.util.regex.Matcher @Contract(pure = true)
                 * public String group()
                 * Returns the input subsequence matched by the previous match.
                 * For a matcher m with input sequence s, the expressions m.group() and s.substring(m.start(), m. end()) are equivalent.
                 * Note that some patterns, for example a*, match the empty string. This method will return the empty string when the pattern successfully matches the empty string in the input.
                 *
                 * Specified by:
                 * group in interface MatchResult
                 * Returns:
                 * The (possibly empty) subsequence matched by the previous match, in string form
                 */
            }
            line = (bufferedReader.readLine());
        }//end while out
        bufferedReader.close();
    }//end main
}
