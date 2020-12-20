package namesAndStrings;

public class FileName {
    /*当你需在多个.java中要用同一个变量(更多的是常量,比如文件名(路径名))
     * 那么就可以建立一个储存这些信息的静态成员,这样就可以通过类名.静态变量名来访问
     * 这样做的好处时可以降低含有读写文件的.java的耦合,即使项目移动到其他目录,也只需要做少量的修改.*/
    public static String prefix1 = "D:\\OneDrive - pop.zjgsu.edu.cn\\Java\\ProjectCodeInIDEA\\",
            prefix2 = "D:\\OneDrive - pop.zjgsu.edu.cn\\Java\\files\\experiment_doc\\",
            prefix3 = prefix2 + "dataExperiment9\\",
            prefix7 = prefix2 + "dataExperiment7\\",
            prefix10 = prefix2 + "dataExperiment10\\";
    //10表示第10次实验的用到的名字(缀)
    public static String fileName = prefix3 + "ReadText.txt";//英文测试文本
    /*个别特例,大不了针对性的写一个完整名*/
    public static String fileName2 = prefix2 + "dataExperiment8\\三国演义(罗贯中).txt";
    public static String fileName3 = prefix3 + "My.java";
    public static String fileName4 = prefix3 + "weibo.txt";
    public static String fileName5 = prefix3 + "weibo_data.txt";
    public static String fileName6 = prefix3 + "weibo_data_sub.txt";
    public static String fileName7_1 = prefix7 + "wiki-edges.txt";
    public static String fileName7_2 = prefix7 + "wiki-vertices.txt";
    public static String fileName7_3 = prefix7 + "pagerank.txt";
    public static String fileName10_1 = prefix10 + "倚天屠龙记.txt";
    public static String fileName10_2 = prefix10 + "鹿鼎记.txt";
    public static String fileName10_3 = prefix10 + "笑傲江湖.txt";
    public static String fileName11_1 = prefix1 + "src";
    public static String fileName11_2 = "D:\\驱动整合包\\Audio";//大文件.
    public static String fileName11_3 = prefix1 + "src\\experiment7";
    /**
     * binary files
     */
    public static String fileNamePicture1 = "D:\\ecloud\\Pictures\\shimatani hitomi\\working.jpg";

    /**
     * fileNames Out:
     */
    public static String desktopPath = "C:/users/xuchaoxin/desktop/";

    public static String fileNameOut = prefix1 + "src\\experiment9\\StudyRead\\FileName.java";
    public static String fileNameOut2 = prefix3 + "My2.java";
    public static String fileNameOut3 = prefix3 + "Counts.txt";
    public static String fileNameOut4 = prefix3 + "三国演义地名词频.txt";
    public static String fileNameOut7_1 = prefix7 + "wiki-adjacentnodes3.txt";
    public static String fileNameOut10_1 = prefix10 + "金庸武侠小说倒排索引.txt";
    /**
     * binary files out
     */
    public static String fileNameOutPicture1= desktopPath +"pictureBak.jpg";

}
