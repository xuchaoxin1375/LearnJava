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
        String regEx= "[^\u4e00-\u9fa5]";//取出特殊字符
        BufferedReader br= new BufferedReader(new FileReader(FileName.fileName4, StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new FileWriter(FileName.fileNameOut3));

        HashMap<String, Integer> bigMap = new HashMap<>();//统计 用于计算idf
        List<HashMap<String, Double>> list = new ArrayList<>();
        List<String> IDList = new ArrayList<>();

        String string;

        int countLines = 0;//统计文件集文件数(这里是退化为weibo.txt的行数(单条微博"文件"数)
        while ((string = br.readLine()) != null) {
            countLines++;
            HashMap<String, Double> map = new HashMap<>();//用于统计词频(每条微博配一个)
            int IndexOfSeparator = string.indexOf("\t");
            String IDString = string.substring(0, IndexOfSeparator);//取出微博号
            IDList.add(IDString);
            string = string.substring(IndexOfSeparator + 1);//取出每条微博信息
            List<Term> termList = HanLP.segment(string);//HanLP中分词
            List<Term> term= CoreStopWordDictionary.apply(termList);//除去停用词
            int wordsNumber = 0;//对每条微博中的总词数;
            for (Term x : term) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                str=str.replaceAll(regEx," ");//将特殊字符换成空格
                str=str.replaceAll(" ","");//去除空格
                if(str.length()==0){//如果去除空格后长度为0，则不存入集合
                    continue;
                }
                if (map.containsKey(str)) {//存入集合
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);// map.get(x) / wordsNumber 计算每条词频--TF
            }
            list.add(map);
            //todo 计算文件集中含词t的文件数目.(t,number)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);
                } else {
                    bigMap.put(x, 1);
                }
            }
        }
        //todo 计算每个词在其所在的微博中的tfidf值
        int index = 0,sum;
        String str;
        for (HashMap<String, Double> x : list) {
            sum=x.size();
            str = (IDList.get(index++) + "=[");//在文件中写入微博号
            bw.write(str);
            for (String y : x.keySet()) {
                x.put(y, (x.get(y) * Math.log10(countLines / bigMap.get(y))));//Math.log10(countLines / bigMap.get(y))，计算IDF,x.get(y) * Math.log10(countLines / bigMap.get(y)),计算TF-IDF权重
                //利用json格式
                JSONObject json = new JSONObject();
                json.put(y, x.get(y));//存储
                if((--sum)==0)//最后一个使不输出逗号
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
        String regEx= "[^\u4e00-\u9fa5]";//取出特殊字符
        BufferedReader br= new BufferedReader(new FileReader("C:\\users\\惠普荣耀\\IdeaProjects\\untitled4\\实验九\\数据\\weibo_data.txt", StandardCharsets.UTF_8));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\users\\惠普荣耀\\IdeaProjects\\untitled4\\实验九\\数据\\weibo_data1.txt"));
        HashMap<String, Integer> bigMap = new HashMap<>();//统计用于并计算idf
        List<HashMap<String, Double>> list = new ArrayList<>();
        List<String> IDList = new ArrayList<>();
        String string;
        int countLines = 0;//统计文件集文件数(这里是退化为weibo.txt的行数(单条微博"文件"数)
        while ((string = br.readLine()) != null) {
            countLines++;
            HashMap<String, Double> map = new HashMap<>();//用于统计词频(每条微博配一个)
            int IndexOfSeparator = string.indexOf("\t");
            String IDString = string.substring(0, IndexOfSeparator);//取出微博号
            string = string.replaceAll(regEx,"");//取出每条微博信息
            if(string.length()==0)
                continue;
            else
                IDList.add(IDString);
            List<Term> termList = HanLP.segment(string);//HanLP中分词
            List<Term> term= CoreStopWordDictionary.apply(termList);//除去停用词
            int wordsNumber = 0;//对每条微博中的总词数;
            for (Term x : term) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                str=str.replaceAll(regEx," ");//将特殊字符换成空格
                str=str.replaceAll(" ","");//去除空格
                if(str.length()==0){//如果去除空格后长度为0，则不存入集合
                    continue;
                }
                if (map.containsKey(str)) {//存入集合
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);// map.get(x) / wordsNumber 计算每条词频--TF
            }
            list.add(map);
            //todo 计算文件集中含词t的文件数目.(t,number)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);
                } else {
                    bigMap.put(x, 1);
                }
            }
        }
        //todo 计算每个词在其所在的微博中的tfidf值
        int index = 0,sum;
        String str;
        for (HashMap<String, Double> x : list) {
            sum=x.size();
            str = (IDList.get(index++) + "=[");//在文件中写入微博号
            bw.write(str);
            for (String y : x.keySet()) {
                x.put(y, (x.get(y) * Math.log10(countLines / bigMap.get(y))));//Math.log10(countLines / bigMap.get(y))，计算IDF,x.get(y) * Math.log10(countLines / bigMap.get(y)),计算TF-IDF权重
                //利用json格式
                JSONObject json = new JSONObject();
                json.put(y, x.get(y));//存储
                if((--sum)==0)//最后一个使不输出逗号
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












