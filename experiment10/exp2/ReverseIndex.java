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

/*��������
  ������������������ĺ��ļ������Ժ������ı����ĵ�����ҳ��������������Ҫ��������������
*/
public class ReverseIndex {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(FileName.fileName10_1, Charset.forName("utf-8")));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(FileName.fileName10_2, Charset.forName("utf-8")));
        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(FileName.fileName10_3, Charset.forName("utf-8")));
        //���:
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName.fileNameOut10_1));

        HashMap<String, Integer> countMap1 = new HashMap<>();
        HashMap<String, Integer> countMap2 = new HashMap<>();
        HashMap<String, Integer> countMap3 = new HashMap<>();
//        List<WordNode> list=new ArrayList<>();//����ͳ����Ϣ.
        HashMap<String, WordNode> map = new HashMap<>();

        String line = "";//����ֻ��Ϊ�����Ķ���/����Ӧ����ʼ��.
        //����countWordsͳ�Ƹ����ĵ��еĴ�Ƶ.(ͳ�Ƶ�ͬһ��map��)
        /*������ö��߳���д�Ļ�,�ڿ����̰߳�ȫ֮��,����countWords������Ӧ���������߳���ִ��.(�����̰߳�ȫ��,���ụ����ŵ�)
         * ���Ƕ�����ͬһ��map��д��/�޸�<String,WordNode>��ֵ��.�������Ӧ��word��,����wordNode�в���������.
         * ������������Ǹ����ĵ���+���ĵ�������word�Ĵ���.*/
        /*�������µ��̵߳İ�ȫ�Ի����д���ȶ(����thread1�߳�ɨ��map�е�keyʱû�з������key,thread2ɨ��map�е�ͬһ��keyʱҲû�з����Ѵ��ڵĸ�key,�����п��ܵ��³�����map��put����key-value(��ʵ�ʵڶ���Ӧ��ʱ����value�ȿ���) */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countWords(bufferedReader1, countMap1, line);
                    bufferedReader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //(�����ļ��еĴ�Ƶͳ�Ƶ�ʱ��Ҳ���첽��
                for (String word : countMap1.keySet()) {
                    WordNode node = new WordNode(word);
                    node.addToList("����������.txt->" + countMap1.get(word));
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
                        node.addToList("¹����.txt->" + countMap2.get(word));
                        map.put(word, node);
                    } else {
                        map.get(word).addToList("¹����.txt->" + countMap2.get(word));
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
                        node.addToList("Ц������.txt->" + countMap3.get(word));
                        map.put(word, node);
                    } else {
                        map.get(word).addToList("Ц������.txt->" + countMap3.get(word));
                    }

                }
            }
        });
        thread3.start();
        /*��mainִ��д�뵽�ĵ�����֮ǰ,��Ҫ�ȴ�����ͳ�ƹ����߳�ȫ������,�������쳣(ʹ��join��Ϊ�����߳���ȡʱ��)*/
        thread1.join();
        thread2.join();
        thread3.join();
/*todo ����ͳ������޷������ĵ�����ʾ����������,�д�Ū���ԭ��(���̰߳����������ʾ(���������),(���ÿ��join������start��,Ҳ������,���ǾͲ����������߳���*/
        //������ĵ�:
        StringBuffer stringBuffer = new StringBuffer();
        for (String item : map.keySet()) {
            stringBuffer.append(map.get(item));
        }
        /*�ڿ���̨�ϼ��ӽ��(console����ʾδ���ܹ�����,һ���ѽ��������Ƶ�,���ǿ������Ǻ���Ĳ���)*/
        System.out.println(stringBuffer);
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.flush();

        bufferedWriter.close();

    }//endMain

    //countWords();������Կ������ط���,�ﵽĬ�ϲ�����Ч��(��Ӧ��ֻ�ǳ�����������)
    static void countWords(BufferedReader bufferedReader, HashMap<String, Integer> countMap, String line) throws IOException {
        while ((line = (bufferedReader.readLine())) != null) {
            //ͳ�Ƹ����ĵ��еĴ�Ƶ�ķ���.
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
