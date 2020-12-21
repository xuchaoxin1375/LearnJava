package experiment8.exp3;

import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import experiment6.exp4.Tuple;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*对文件“三国演义(罗贯中).txt”进行分词，去掉标点符号和停用词，
最后统计词频，排序输出到文件“三国演义词频.txt”，并画出词云。*/
public class StatisticsWords {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();//用于统计词频
        System.out.println("输入文件目录:"); //String fileName = new Scanner(System.in).nextLine();
          /*     File file =new File(fileName);//无法正常读入中文。
            Scanner scanner = new Scanner(file);*/
        String fileName = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment8\\三国演义(罗贯中).txt";
        /*读入目录: D:\ecloud\textbooks\java\experiment_doc\dataExperiment8\三国演义(罗贯n中).txt
    D:\ecloud\textbooks\java\experiment_doc\dataExperiment8\english.txt    */
        String fileNameOut = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment8\\三国演义词频.txt";

        try {
            /*创建输入流和输出流*/
            FileInputStream inputStream = new FileInputStream(fileName);
            ;/*产生了一个(节点)流对象
            方便后期用流对其数据操作:一般是使用该流对象对应具有的方法进行操作:
            比如.read()方法来取用某些内容*/
            FileOutputStream outputStream = new FileOutputStream(fileNameOut);

            //String str;
            byte[] bytes = new byte[1024];/*申请一个byte[]类型的数组(对象),该对象的规格通过new Byte[1024] 来定义,用bytes引用变量类管理这个数组对象;
            这个数组用于存储届时读取的数据,另外注意不要使用byte的包装类Byte,两者有所不容*/
            int len = 0;
            try {
                while ((len = inputStream.read(bytes)) != -1) {
                    //System.out.println(new String(bytes,"utf-8"));//默认是用gbk编码,所以灾打印输出的时候将出现乱码(故这里指定用utf-8)来处理.
                    //String(byte[] bytes, int offset, int length):把字节数组的一部分转换为字符串
//                    StringTokenizer tokenizer = new StringTokenizer(new String(bytes/*, StandardCharsets.UTF_8*/), "《》；，。！【】‘? ”“：￥~—`\\？|");/*《》；，。！【】‘ “：￥~`\?  */
//                    String str;
//                    while (tokenizer.hasMoreElements()) {
//                        str = (String) tokenizer.nextElement();
//                        if (map.containsKey(str)) {
//                            map.put(str, map.get(str) + 1);
//                        } else {
//                            map.put(str, 1);
//                        }
//                        //System.out.println(str);
//                    }//endWhileTokenizer
                    /*使用hanlp包来做：*/
                    String s = new String(bytes, StandardCharsets.UTF_8);
                    /*System.out.println(HanLP.segment(s));*/
                  /*  CoreStopWordDictionary.add("??");
                    CoreStopWordDictionary.add(" ");*/

                    /*hanlp处理字符串s:光用函数的效果并不如意：*/
      /*              for (Term x : HanLP.segment(s)) {
                        str = x.toString();
                        if (!CoreStopWordDictionary.contains(str)) {
                            if (map.containsKey(str)) {
                                map.put(str, map.get(str) + 1);
                            } else {
                                map.put(str, 1);
                            }
                        }
                    }//endfor
              */
                    /*使用Term类中的nature成员来处理符号问题比较满意。*/
                    //Segment segment = HanLP.newSegment().enableNameRecognize(true);

                    List<Term> termList = StandardTokenizer.segment(s);/*标准分词器*/
                   // System.out.println(termList);//查看分词效果,发现符号和词语都别列入列表中。
                    for (Term x : termList) {

//                        if (x.nature == Nature.w) {//Term类下的nature成员是词性。而Nature类里有诸词性（名词，连词，乃至人名等其他分类标准..等细致的划分。public static final Nature nr = new Nature("nr");nr成员就是人名,w就是标点符号。但注意统计人名时应当是x.nature!=Nature.nr作为条件
//                            continue;/*如果比较得知该x的属性不是人名，那么跳过后续的统计操作，判断下个记录*/
//                        }
                        if (x.nature!= Nature.nr) {
                            continue;
                        }

                        String str = x.toString();
                        if (map.containsKey(str)) {
                            map.put(str, map.get(str) + 1);
                        } else {
                            map.put(str, 1);
                        }
                    }

                }
            }//whileEndIO 要特别注意io流（的关闭）不能在循环里写（出现）
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
//
            List<Tuple> list = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            for (String x : map.keySet()) {
                list.add(new Tuple(x, map.get(x)));
            }//endFor
            //System.out.println(stringBuffer);
            /*创建Tuple对象，并将Tuple对象放入列表中一遍执行排序：*/
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Tuple o1, Tuple o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            /*链接成一整个字符串*/
            for (Tuple x : list) {
                stringBuffer.append(x);
            }
           System.out.println(stringBuffer);
            /*写入文件*/
            outputStream.write(stringBuffer.toString().getBytes());
            /*关闭io流，释放资源*/
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}