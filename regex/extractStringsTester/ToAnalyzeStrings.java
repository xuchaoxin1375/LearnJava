package regex.extractStringsTester;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 9:53 AM
 * @Version 1.0
 */
public class ToAnalyzeStrings {
    /*字符串中的\t字符也会被识别为空白字符(制表符)*/
    static String s0 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
    static String s1 = "the quick brown fox 6ox jumps over the lazy dog.";
    static String s2 = "the _quick bro44wn fox 6ox jumps over the lazy __dog.";
}
