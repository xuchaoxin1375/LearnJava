package experiment9.exp3;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import namesAndStrings.FileName;
import net.sf.json.JSONObject;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ObservationTFIDF {
    public static void main(String[] args) throws IOException {
        String regEx= "[^\u4e00-\u9fa5]";//ȡ�������ַ�
        BufferedReader br= new BufferedReader(new FileReader(FileName.fileName4, StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new FileWriter(FileName.fileNameOut3));

        HashMap<String, Integer> bigMap = new HashMap<>();//ͳ�� ���ڼ���idf
        List<HashMap<String, Double>> list = new ArrayList<>();
        List<String> IDList = new ArrayList<>();

        String string;

        int countLines = 0;//ͳ���ļ����ļ���(�������˻�Ϊweibo.txt������(����΢��"�ļ�"��)
        while ((string = br.readLine()) != null) {
            countLines++;
            HashMap<String, Double> map = new HashMap<>();//����ͳ�ƴ�Ƶ(ÿ��΢����һ��)
            int IndexOfSeparator = string.indexOf("\t");
            String IDString = string.substring(0, IndexOfSeparator);//ȡ��΢����
            IDList.add(IDString);
            string = string.substring(IndexOfSeparator + 1);//ȡ��ÿ��΢����Ϣ
            List<Term> termList = HanLP.segment(string);//HanLP�зִ�
            List<Term> term= CoreStopWordDictionary.apply(termList);//��ȥͣ�ô�
            int wordsNumber = 0;//��ÿ��΢���е��ܴ���;
            for (Term x : term) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                str=str.replaceAll(regEx," ");//�������ַ����ɿո�
                str=str.replaceAll(" ","");//ȥ���ո�
                if(str.length()==0){//���ȥ���ո�󳤶�Ϊ0���򲻴��뼯��
                    continue;
                }
                if (map.containsKey(str)) {//���뼯��
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);// map.get(x) / wordsNumber ����ÿ����Ƶ--TF
            }
            list.add(map);
            //todo �����ļ����к���t���ļ���Ŀ.(t,number)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);
                } else {
                    bigMap.put(x, 1);
                }
            }
        }
        //todo ����ÿ�����������ڵ�΢���е�tfidfֵ
        int index = 0,sum;
        String str;
        for (HashMap<String, Double> x : list) {
            sum=x.size();
            str = (IDList.get(index++) + "=[");//���ļ���д��΢����
            bw.write(str);
            for (String y : x.keySet()) {
                x.put(y, (x.get(y) * Math.log10(countLines / bigMap.get(y))));//Math.log10(countLines / bigMap.get(y))������IDF,x.get(y) * Math.log10(countLines / bigMap.get(y)),����TF-IDFȨ��
                //����json��ʽ
                JSONObject json = new JSONObject();
                json.put(y, x.get(y));//�洢
                if((--sum)==0)//���һ��ʹ���������
                    bw.write(String.valueOf(json));
                else
                    bw.write(json + ",");
            }
            bw.write("]\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}





/*

public class MyHomeWorks9 {
    public static void main(String[] args) throws IOException {
        String regEx= "[^\u4e00-\u9fa5]";//ȡ�������ַ�
        BufferedReader br= new BufferedReader(new FileReader("C:\\users\\������ҫ\\IdeaProjects\\untitled4\\ʵ���\\����\\weibo_data.txt", StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\users\\������ҫ\\IdeaProjects\\untitled4\\ʵ���\\����\\weibo_data1.txt"));
        HashMap<String, Integer> bigMap = new HashMap<>();//ͳ�����ڲ�����idf
        List<HashMap<String, Double>> list = new ArrayList<>();
        List<String> IDList = new ArrayList<>();
        String string;
        int countLines = 0;//ͳ���ļ����ļ���(�������˻�Ϊweibo.txt������(����΢��"�ļ�"��)
        while ((string = br.readLine()) != null) {
            countLines++;
            HashMap<String, Double> map = new HashMap<>();//����ͳ�ƴ�Ƶ(ÿ��΢����һ��)
            int IndexOfSeparator = string.indexOf("\t");
            String IDString = string.substring(0, IndexOfSeparator);//ȡ��΢����
            string = string.replaceAll(regEx,"");//ȡ��ÿ��΢����Ϣ
            if(string.length()==0)
                continue;
            else
                IDList.add(IDString);
            List<Term> termList = HanLP.segment(string);//HanLP�зִ�
            List<Term> term= CoreStopWordDictionary.apply(termList);//��ȥͣ�ô�
            int wordsNumber = 0;//��ÿ��΢���е��ܴ���;
            for (Term x : term) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                str=str.replaceAll(regEx," ");//�������ַ����ɿո�
                str=str.replaceAll(" ","");//ȥ���ո�
                if(str.length()==0){//���ȥ���ո�󳤶�Ϊ0���򲻴��뼯��
                    continue;
                }
                if (map.containsKey(str)) {//���뼯��
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);// map.get(x) / wordsNumber ����ÿ����Ƶ--TF
            }
            list.add(map);
            //todo �����ļ����к���t���ļ���Ŀ.(t,number)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);
                } else {
                    bigMap.put(x, 1);
                }
            }
        }
        //todo ����ÿ�����������ڵ�΢���е�tfidfֵ
        int index = 0,sum;
        String str;
        for (HashMap<String, Double> x : list) {
            sum=x.size();
            str = (IDList.get(index++) + "=[");//���ļ���д��΢����
            bw.write(str);
            for (String y : x.keySet()) {
                x.put(y, (x.get(y) * Math.log10(countLines / bigMap.get(y))));//Math.log10(countLines / bigMap.get(y))������IDF,x.get(y) * Math.log10(countLines / bigMap.get(y)),����TF-IDFȨ��
                //����json��ʽ
                JSONObject json = new JSONObject();
                json.put(y, x.get(y));//�洢
                if((--sum)==0)//���һ��ʹ���������
                    bw.write(String.valueOf(json));
                else
                    bw.write(json + ",");
            }
            bw.write("]\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

*/












