package namesAndStrings;

public class FileName {
    /*当你需在多个.java中要用同一个变量(更多的是常量,比如文件名(路径名))
     * 那么就可以建立一个储存这些信息的静态成员,这样就可以通过类名.静态变量名来访问
     * 这样做的好处时可以降低含有读写文件的.java的耦合,即使项目移动到其他目录,也只需要做少量的修改.*/
    /**
     * please notice  the separator '/'in every path .
     */
    public static String desktopPath = "C:/users/xuchaoxin/desktop/";

    public static String prefixPathThisProject = "D:/OneDrive - pop.zjgsu.edu.cn/Java/ProjectCodeInIDEA/",
            prefixPathDocx = "D:/OneDrive - pop.zjgsu.edu.cn/Java/files/experiment_doc/",
    /* dataExperiments    */
    prefixPath5 = prefixPathDocx + "dataExperiment5/",
            prefixPath3 = prefixPathDocx + "dataExperiment9/",
            prefixPath7 = prefixPathDocx + "dataExperiment7/",
            prefixPath8 = prefixPathDocx + "dataExperiment8/",
            prefixPath10 = prefixPathDocx + "dataExperiment10/";
    //10表示第10次实验的用到的名字(缀)
    public static String fileName = prefixPath3 + "ReadText.txt";//英文测试文本
    /*个别特例,大不了针对性的写一个完整名*/
    public static String fileName3 = prefixPath3 + "My.java";
    public static String fileName4 = prefixPath3 + "weibo.txt";
    public static String fileName5 = prefixPath3 + "weibo_data.txt";
    public static String fileName5_1 = prefixPath5 + "weather.txt";
    public static String fileName6 = prefixPath3 + "weibo_data_sub.txt";
    public static String fileName7_1 = prefixPath7 + "wiki-edges.txt";
    public static String fileName7_2 = prefixPath7 + "wiki-vertices.txt";
    public static String fileName7_3 = prefixPath7 + "pagerank.txt";
    public static String fileName8_1 = prefixPath8 + "english.txt";
    public static String fileName8_2 = prefixPath8 + "三国演义(罗贯中).txt";
    public static String fileName10_1 = prefixPath10 + "倚天屠龙记.txt";
    public static String fileName10_2 = prefixPath10 + "鹿鼎记.txt";
    public static String fileName10_3 = prefixPath10 + "笑傲江湖.txt";
    public static String fileName11_1 = prefixPathThisProject + "src";
    public static String fileName11_2 = "D:/驱动整合包/Audio";//大文件.
    public static String fileName11_3 = prefixPathThisProject + "src/experiment7";
    public static String fileNameWord = desktopPath + "word.docx";
    /**
     * binary files
     */
    public static String fileNamePicture1 = "D:/ecloud/Pictures/shimatani hitomi/working.jpg";

    /**
     * fileNames Out:
     */


    public static String fileNameOut = prefixPathThisProject + "src/experiment9/StudyRead/FileName.java";
    public static String fileNameOut2 = prefixPath3 + "My2.java";
    public static String fileNameOut3 = prefixPath3 + "Counts.txt";
    public static String fileNameOut4 = prefixPath3 + "三国演义地名词频.txt";
    public static String fileNameOut7_1 = prefixPath7 + "wiki-adjacentnodes3.txt";
    public static String fileNameOut10_1 = prefixPath10 + "金庸武侠小说倒排索引.txt";
    /**
     * binary files out
     */
    public static String fileNameOutPicture1 = desktopPath + "pictureBak.jpg";

}
