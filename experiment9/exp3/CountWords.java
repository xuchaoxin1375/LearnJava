package experiment9.exp3;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import experiment6.exp4.Tuple;
import experiment9.FileName;
import net.sf.json.JSONObject;

import java.io.*;
import java.lang.module.FindException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*TF-IDF是一种计算句子/篇章关键词的统计方法，用以评估一字词对于一个文件集或一个语料库中的其中一份文件的重要程度。
*TF-IDF（term frequency–inverse document frequency）是一种用于信息检索与数据挖掘的常用加权技术。TF是词频(Term Frequency)，IDF是逆文本频率指数(Inverse Document Frequency)
* TF: Term Frequency
TF(t) = (词t在当前文中出现次数)
*
IDF：Inverse Document Frequency
IDF(t) = lg(总文档数/含 t的文档数):lg
*
TF-IDF权重 = TF(t) * IDF(t)
假如一篇文件的总词语数是100个，而词语“挖掘”出现了3次，
* 那么“挖掘”一词在该文件中的词频就是3/100=0.03。
*
* 一个计算文件频率 (IDF) 的方法是文件集里包含的文件总数除以测定有多少份文件出现过“挖掘”一词。
*
* 所以，如果“挖掘”一词在1,000份文件出现过，而文件总数是10,000,000份的话，其逆向文件频率就是 lg(10,000,000 / 1,000)=4。
* 最后，“挖掘”的TF-IDF的值为0.03 * 4=0.12。
*/
//////////总之,我们需要做的事情,就是把每个词(t)的TF,和IDF都求出来,然后相乘即可得到欲求的每个词t的TF-IDF.
//所以我们需要列一张关于所有的词t所组成的大表(可以用集合set或者HaspMap,后者更好)(然而,t的IDF是唯一的,但是t的IF却因不同的文件而异)
/*TF-IDF是一种统计方法，用以评估一字词对于一个文件集或一个语料库中的其中一份文件的重要程度。
字词的重要性随着它在文件中出现的次数成正比增加，但同时会随着它在语料库中出现的频率成反比下降。

TFIDF的主要思想是：如果某个词或短语在一篇文章中出现的频率TF高，并且在其他文章中很少出现，则认为此词或者短语具有很好的类别区分能力，适合用来分类。TFIDF实际上是：TF * IDF，TF词频(TermFrequency)，IDF逆向文件频率(Inverse Document Frequency)。TF表示词条在文档d中出现的频率。
IDF的主要思想是：如果包含词条t的文档越少，也就是n越小，IDF越大，则说明词条t具有很好的类别区分能力。

IDF的不足之处：
如果某一类文档C中包含词条t的文档数为m，而其它类包含t的文档总数为k，显然所有包含t的文档数n=m+k，当m大的时候，n也大，按照IDF公式得到的IDF的值会小，就说明该词条t类别区分能力不强。但是实际上，如果一个词条在一个类的文档中频繁出现，则说明该词条能够很好代表这个类的文本的特征，这样的词条应该给它们赋予较高的权重，并选来作为该类文本的特征词以区别与其它类文档。这就是IDF的不足之处.
如此一来，本次作业中的每一条微博（占有一行）当做一个文件，里面的每个词t都具有tfdif值这些（t，tfidf）元组构成的列表就是一条输出的记录（即这个微博行的处理结果）
这就又遇到一个问题，如果记录上百万个，那就考验算法的高效性，不能太多的遍历，至少不能多重循环（恐怖），可以考虑线性多次遍历。
本题中，在统计完一条微博中的各个词的种类后，用一个大map在这个小map的key添加到大map，这样每一条微博中的每个词即时在同一条微博出现多次，我们也只当出现一次记录，完成遍历后，大map的key，value中的value就是文件集（微博集）中出现各个关键词t的文件数，这样每个词t的idf就可以求得。应当知道，idf是词t相对于文件集的概念，每个词t对于同一个文件集有唯一确定的值，可以为文件集中各个文件中的词t求tfidf时所共用
*/
/*分别对两个微博数据集weibo.txt和weibo_data.txt计算，
其中大数据版的微博数据集有7列，分别为：
用户ID、微博ID、微博时间、点赞数、转发数、评论数、微博内容
*/
/*步骤：
1、计算每个词条在 每条微博 中的出现次数
2、计算每个词条在 微博 中的出现次数
3、计算出每条微博中 所有词条 的tf-idf值
可能用到JSONObject类辅助结果输出
用法：
JSONObject json = new JSONObject();
json.put();
或者
json.accumulate();

*/
public class CountWords {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();//检测运行时间(part1)
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FileName.fileName4, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName.fileNameOut3/*,StandardCharsets.UTF_8*/, true));

        HashMap<String, Integer> bigMap = new HashMap<>();//统计用于并计算idf
        HashMap<String, HashMap<String, Double>> IDMap = new HashMap<>();
        String string = null;
        int countLines = 0;//统计文件集文件数(这里是退化为wei_bo.txt的行数(单条微博"文件"数)
        //todo 从文件中读取每一行.
        while ((string = bufferedReader.readLine()) != null) {
            //System.out.println(string);
            /*使用hanlp包来做：*/
            countLines++;
            HashMap<String, HashMap<String, Double>> idMap = new HashMap<>();
            HashMap<String, Double> map = new HashMap<>();//用于统计词频(每条微博配一个)

            int IndexOfSeparator = string.indexOf("\t");//分隔符在字符串中的索引
            String IDString = string.substring(0, IndexOfSeparator);//每条微博的ID号
            //IDMap.put(IDString,null);无序;
            string = string.substring(IndexOfSeparator + 1);//每条微博ID号之后的内容(作为统计分析的对象)
            //todo 开始分析当前得微博
            List<Term> termList = HanLP.segment(string);//当断点打在这里时,调试的时候陷在里面了?
            int wordsNumber = 0; //= termList.size();
            //对每条微博中的词进行词频统计(string,Double);
            for (Term x : termList) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }//endFor(每一条微博的map生成了)
            /*生成TF键值对(t,tf)*/
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);
            }
            //list.add(map);//将当前得统计map加入到list中
            //todo 将每一条微博的ID号和其统计map配对.
            IDMap.put(IDString, map);
            //测试打印:
            // System.out.println(map);
            //添加记录到bigMap中:(统计某个词t相对于整个文件集的IDF的过程,要完整遍历所有微博,然后才能使用这个IDF(即要在这个while节输之后使用.)(key:词t,value:包含词t的文件(微博条数)

            //todo 计算文件集中含词t的文件数目.(t,number)(其中bigMap是整个while循环共同使用的)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);//不要写成map.get(x)了
                } else {
                    bigMap.put(x, 1);
                }
            }//endFor
            //再次监视:
            // System.out.println(map);
        }//endWhile//遍历完所有输入行


        /*将(t,tf)更新为(t,tf-idf);其中,tf-idf=tf*idf;idf=countLines/bigMap.get(x).log10 计算出每条微博中各个词t的TF-IDF值*/
        /*强制运行到此处*/
        //todo 计算每个词在其所在的微博中的tfidf值
        for (String ID : IDMap.keySet()) {
            HashMap<String, Double> mapTmp = new HashMap<>();
            mapTmp = IDMap.get(ID);
            for (String s : mapTmp.keySet()) {
                mapTmp.put(s, (mapTmp.get(s)) * (Math.log10((double) countLines / bigMap.get(s))));
            }
            //监视:
            //System.out.println(mapTmp);
        }
        for(String ID:IDMap.keySet()){
            System.out.println(ID+"="+IDMap.get(ID));
            bufferedWriter.write(ID+"="+IDMap.get(ID)+"\n");
        }

        bufferedWriter.flush();  //step2:刷新缓冲区
        //step3:释放资源:
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("操作完毕.");
        System.out.println("运行耗时" + (System.currentTimeMillis() - time1));

    }
}
/*
附:
json.toString()源代码:
public String toString() {
        if (this.isNullObject()) {
            return JSONNull.getInstance().toString();
        } else {
            try {
                Iterator keys = this.keys();//迭代器
                StringBuffer sb = new StringBuffer("{");//利用StringBuffer(同时以字符"{"初始化.

                while(keys.hasNext()) {
                    if (sb.length() > 1) {
                        sb.append(',');//在非末尾字符串以','分割.
                    }

                    Object o = keys.next();
                    sb.append(JSONUtils.quote(o.toString()));//quote引用
                    sb.append(':');//':'分割键值对的key:value
                    sb.append(JSONUtils.valueToString(this.properties.get(o)));
                }

                sb.append('}');//'}'结尾
                return sb.toString();//返回sb(StringBuffer)对应的字符串
            } catch (Exception var4) {
                return null;
            }
        }
    }

* */
/*json.put():
*     public Object put(Object key, Object value) {
        if (key == null) {//优先检查异常.
            throw new IllegalArgumentException("key is null.");
        } else {
            Object previous = this.properties.get(key);
            this.element(String.valueOf(key), value);
            return previous;
        }
    }*/