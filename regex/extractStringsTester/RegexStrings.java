package regex.extractStringsTester;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 10:03 AM
 * @Version 1.0
 */
public class RegexStrings {
    static String regex0 ="\\s+";
    /**匹配表示符
     * C语言的:
     * (_|[a-zA-Z])\w+
     * _\w+|[a-zA-Z]\w+
     * java语言的表示符
     * (_|[a-zA-Z]|\$)\w+
     * */
    static  String  regex2 = "(_\\w|[a-zA-Z])+";/* (_|[a-zA-Z])\w+  or  */
    /**匹配java文件名*/
    static String regex3="(_|[a-zA-Z]|\\$)\\w+\\.java";
}
