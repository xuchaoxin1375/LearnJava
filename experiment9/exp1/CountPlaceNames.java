package experiment9.exp1;
/*统计三国演义小说中出现多少个地名，将地名词频排序输出到文件*/
/*http://www.hankcs.com/nlp/hanlp.html*/
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import experiment6.exp4.Tuple;
import namesAndStrings.FileName;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*对文件“三国演义(罗贯中).txt”进行分词，去掉标点符号和停用词，
最后统计词频，排序输出到文件“三国演义词频.txt”，并画出词云。*/
public class CountPlaceNames {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();//用于统计词频
        /*这里引入中间过度名可以进一步为修改数据源提供方便,只需要使得标识符尽可能规律*/
        String fileName = FileName.fileName2;
        String fileNameOut = FileName.fileNameOut4;

        try {
            /*创建输入流和输出流*/
            FileInputStream inputStream = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream(fileNameOut);
//            BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName,StandardCharsets.UTF_8));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameOut,StandardCharsets.UTF_8));
            byte[] bytes = new byte[1024];
            try {
                while (( inputStream.read(bytes)) != -1) {
                    /*使用hanlp包来做：*/
                    String s = new String(bytes, StandardCharsets.UTF_8);//值得注意的是,如果仅仅只是将bytes数组转成String时从头转到尾,就不需要定义int len来记录读取的字节数.
                    Segment segment = HanLP.newSegment().enablePlaceRecognize(true);
                    List<Term> termList = segment.seg(s);
                    for (Term x : termList) {
                        if (x.nature != Nature.ns) {
                            continue;
                        }
                        String str = x.toString();
                        if (map.containsKey(str)) {
                            map.put(str, map.get(str) + 1);
                        } else {
                            map.put(str, 1);
                        }
                    }//for
                }//endWhile
            }//endTry 要特别注意io流（的关闭）不能在循环里写（出现）,留到文末写.
            catch (IOException ioException) {
                ioException.printStackTrace();
            }

            List<Tuple> list = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            for (String x : map.keySet()) {
                list.add(new Tuple(x, map.get(x)));
            }//endFor
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
