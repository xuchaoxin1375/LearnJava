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
    /*���ѷ���,����д�ӡ����ĺ���һ��Ͳ�Ҫ��װ������,��Ҫ��ӡ�Ļ����������д�ӡoptimizeText����ֵ����*/
/*    static void printOptimizeTexts(String ToAnalyzeString,String regexString,String separator){
        System.out.println(optimizeTexts(ToAnalyzeString, regexString, separator));
    }*/

    public static void main(String[] args) {
        //demo0();
        //demo1();
        /*�ظ��Ĵ���д����,�ͻ�ȥѰ�󲢳������ͬ��,*/
        System.out.println(optimizeTexts(ToAnalyzeStrings.s0, RegexStrings.regex0, " "));
    }
}
