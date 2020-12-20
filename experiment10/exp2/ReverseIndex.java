package experiment10.exp2;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.document.sentence.word.Word;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import experiment9.FileName;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*倒排索引
  倒排索引是搜索引擎的核心技术，对海量的文本（文档、网页），搜索引擎需要建立搜索索引。
*/
public class ReverseIndex {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(FileName.fileName10_1, Charset.forName("utf-8")));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(FileName.fileName10_2, Charset.forName("utf-8")));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(FileName.fileName10_3, Charset.forName("utf-8")));
        //输出:
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName.fileNameOut10_1));

        HashMap<String, Integer> countMap1 = new HashMap<>();
        HashMap<String, Integer> countMap2 = new HashMap<>();
        HashMap<String, Integer> countMap3 = new HashMap<>();
//        List<WordNode> list=new ArrayList<>();//整合统计信息.
        HashMap<String, WordNode> map = new HashMap<>();

        String line = "";//这种只作为参数的对象/变量应当初始化.
        //调用countWords统计各份文档中的词频.(统计到同一个map中)
        /*如果采用多线程来写的话,在考虑线程安全之外,三个countWords工作对应可有三个线程来执行.(这是线程安全的,不会互相干扰的)
         * 他们都是往同一个map中写入/修改<String,WordNode>键值对.如果有相应的word键,则往wordNode中插入新内容.
         * 所插入的内容是各个文档名+该文档包出现word的次数.*/
        /*但是如下的线程的安全性还是有待商榷(比如thread1线程扫描map中的key时没有发现这个key,thread2扫描map中的同一个key时也没有发现已存在的该key,于是有可能导致尝试在map中put两次key-value(而实际第二次应到时更新value既可以) */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countWords(bufferedReader1, countMap1, line);
                    bufferedReader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //(各个文件中的词频统计的时候也是异步的
                for (String word : countMap1.keySet()) {
                    WordNode node = new WordNode(word);
                    node.addToList("倚天屠龙记.txt->" + countMap1.get(word));
                    map.put(word, node);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countWords(bufferedReader2, countMap2, line);
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (String word : countMap2.keySet()) {//
                    if (!map.containsKey(word)) {
                        WordNode node = new WordNode(word);
                        node.addToList("鹿鼎记.txt->" + countMap2.get(word));
                        map.put(word, node);
                    } else {
                        map.get(word).addToList("鹿鼎记.txt->" + countMap2.get(word));
                    }
                }
            }
        });
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    countWords(bufferedReader3, countMap3, line);
                    bufferedReader3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (String word : countMap3.keySet()) {//
                    if (!map.containsKey(word)) {
                        WordNode node = new WordNode(word);
                        node.addToList("笑傲江湖.txt->" + countMap3.get(word));
                        map.put(word, node);
                    } else {
                        map.get(word).addToList("笑傲江湖.txt->" + countMap3.get(word));
                    }

                }
            }
        });
        thread3.start();
        /*在main执行写入到文档操作之前,需要等待三个统计工作线程全部结束,否则会出异常(使用join来为三个线程争取时间)*/
        thread1.join();
        thread2.join();
        thread3.join();
/*todo 但这就出先了无法三个文档都显示出来的问题,有待弄清楚原因(单线程版可以正常显示(看博客里的),(如果每个join都紧跟start后,也可正常,但那就不是真正多线程了*/
        //输出到文档:
        StringBuffer stringBuffer = new StringBuffer();
        for (String item : map.keySet()) {
            stringBuffer.append(map.get(item));
        }
        /*在控制台上监视结果(console的显示未必能够完整,一般会把较早的输出推掉,我们看到的是后面的部分)*/
        System.out.println(stringBuffer);
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.flush();

        bufferedWriter.close();

    }//endMain

    //countWords();另外可以考虑重载方法,达到默认参数的效果(但应该只是常量才有意义)
    static void countWords(BufferedReader bufferedReader, HashMap<String, Integer> countMap, String line) throws IOException {
        while ((line = (bufferedReader.readLine())) != null) {
            //统计各份文档中的词频的方法.
            List<Term> segment = HanLP.segment(line);
            for (Term x : segment) {
                //if(/*x.nature== Nature.w*//*||x.nature==Nature.e*/) continue;
                String keyString = x.toString();
                if (countMap.containsKey(keyString)) {
                    countMap.put(keyString, countMap.get(keyString) + 1);
                } else {
                    countMap.put(keyString, 1);
                }
            }
        }//endWhile
    }
}
