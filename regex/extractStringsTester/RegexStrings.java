package regex.extractStringsTester;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 10:03 AM
 * @Version 1.0
 */
public class RegexStrings {
    static String regex0 ="\\s+";
    /**ƥ���ʾ��
     * C���Ե�:
     * (_|[a-zA-Z])\w+
     * _\w+|[a-zA-Z]\w+
     * java���Եı�ʾ��
     * (_|[a-zA-Z]|\$)\w+
     * */
    static  String  regex2 = "(_\\w|[a-zA-Z])+";/* (_|[a-zA-Z])\w+  or  */
    /**ƥ��java�ļ���*/
    static String regex3="(_|[a-zA-Z]|\\$)\\w+\\.java";
}
