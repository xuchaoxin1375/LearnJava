package experiment6.exp4;
/*
对7个文件Lincoln, Abraham - The Writings of Abraham Lincoln Volume 1.txt     ~    Lincoln, Abraham - The Writings of Abraham Lincoln Volume 7.txt中的
所有单词进行词频统计，
要求去除停用词、
去除 单词首尾 的标点符号，
并按词频大小按 降序排列
写到文件WordCount.txt中。
可用HashMap实现单词词频记录。
写文件可用语句：
import java.io.PrintWriter;
PrintWriter pw = new PrintWriter("data/wordcount.txt");
pw.write();

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class WordFrequencyStatistics {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();
        Set<String> stopWordsSet = new HashSet<>();/*Set里的对象是String,不需要重写equals和hashCode方法.*/
        /*读入多个文件的数据到list中去.*/
        /*分析文件名结构,以便利用循环读入数据.*/
        String filesDirectory = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment6";
        String filenamesPre = filesDirectory + "\\Lincoln, Abraham - The Writings of Abraham Lincoln Volume ";
        int no = 1;
        String filenamesPos = ".txt";
        Scanner scanner;
        /*读取停用词:*/
        File fileStopWord = new File(filesDirectory + "\\stopwords" + filenamesPos);
        try {
            scanner = new Scanner(fileStopWord);
            String stringStopWord = scanner.nextLine();
            for (; scanner.hasNextLine(); stringStopWord = scanner.nextLine())
                stopWordsSet.add(stringStopWord);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*开始读入各个文件,并处理(这里读入7个文件)*/
        for (; no < 8; no++) {
//File 对象是定义在for中的,即,尽管每次进入for时,File类的实例名都叫file,但由于都是通过new来实例化的,所以这些同名File对象是不同的.
            File file = new File(filenamesPre + no + filenamesPos);
            // File file2 = new File("Lincoln, Abraham - The Writings of Abraham Lincoln Volume 2.txt");
            try {
                scanner = new Scanner(file);
                String s;

                for (s = scanner.nextLine(); scanner.hasNextLine(); s = scanner.nextLine()) {
                    StringTokenizer tokenizer = new StringTokenizer(s, "  #*-,.!:;\"$()[]\\&?");//delimiter界定符
                    String str;
                    /*分析(剔除停用词)并将满足条件的单词添加到list中*/
                    while (tokenizer.hasMoreElements()) {//这一行中的所有单词(保存在tokenizer中)
                        str = (String) tokenizer.nextElement();//挨个地获取单词
                        /*排除停用词(方法1)*/
                        if (!stopWordsSet.contains(str.toLowerCase()))/*//忽视大小写的区别(这里提供的StopWords中的单词都是小写的,
                    因而只需要当方面的将被比较字符转为纯小写即可达到效果(如有必要,可以将listStopWord中的单词也都转为小写,可以达到忽略大小写的效果.*/
                        {
                            list.add(str);
                        }//endIf
                        /*方法2:(这个就不推荐,时间开销比方法一大的多)*/
//                        boolean isEliminate = false;
//                        for (String x : stopWordsSet) {
//                            if (str.compareToIgnoreCase(x) == 0)/*public int compareToIgnoreCase(@NotNull String str)*/ {
//                                isEliminate = true;
//                                break;
//                            }//endIf
//                        }//endFor
//                        if (isEliminate == false)
//                            list.add(str);

                    }//endWhile

                }/*endfor至此,成功读入数据到list中*/

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }//endCatch
        }//endFor

        /*开始利用map统计词频:*/
        for (String x : list) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else
                map.put(x, map.get(x) + 1);
        }

        List<Tuple> listTuples = new ArrayList<>();
        for (String x : map.keySet()) {
            listTuples.add(new Tuple(x, map.get(x)));
        }
        Collections.sort(listTuples, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        /*打印结果*/
//        //System.out.println(listTuples);
//        for (Tuple x : listTuples) {
//            System.out.println(x);
//        }
        /*将结果输出到文件中*/
        /*创建文件*/
        PrintWriter pw = null;
        try {
            //pw = new PrintWriter(filesDirectory+"/data/wordcount.txt");
            pw = new PrintWriter("C://users//xuchaoxin//desktop//wordcount.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*写入方式1:*/
//        for (Tuple x : listTuples) {
//            pw.write(x.toString());
//        }//endFor
        /*写入方式2:*/
        StringBuffer sb=new StringBuffer();
        for(Tuple x:listTuples){
            sb.append(x.toString());
        }
        System.out.println(sb);//其实是打印了sb.toString();
        pw.write(sb.toString());
    }//endMain
}
