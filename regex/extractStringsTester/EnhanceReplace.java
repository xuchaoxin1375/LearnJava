package regex.extractStringsTester;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 9:33 AM
 * @Version 1.0
 */
public class EnhanceReplace {
    /**
     * @param ToAnalyzeString
     * @param regexString
     * @param separator
     * @return
     */
    static String optimizeTexts(String ToAnalyzeString, String regexString, String separator) {
        return ToAnalyzeString.replaceAll(regexString, separator);
        //System.out.println();
    }
    /*不难发现,这个中打印结果的函数一般就不要封装进来了,需要打印的话在主函数中打印optimizeText返回值即可*/
/*    static void printOptimizeTexts(String ToAnalyzeString,String regexString,String separator){
        System.out.println(optimizeTexts(ToAnalyzeString, regexString, separator));
    }*/

    public static void main(String[] args) {
        //demo0();
        //demo1();
        /*重复的代码写多了,就会去寻求并抽象出共同点,*/
        System.out.println(optimizeTexts(ToAnalyzeStrings.s0, RegexStrings.regex0, " "));
    }
}
