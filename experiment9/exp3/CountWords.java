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

/*TF-IDF��һ�ּ������/ƪ�¹ؼ��ʵ�ͳ�Ʒ�������������һ�ִʶ���һ���ļ�����һ�����Ͽ��е�����һ���ļ�����Ҫ�̶ȡ�
*TF-IDF��term frequency�Cinverse document frequency����һ��������Ϣ�����������ھ�ĳ��ü�Ȩ������TF�Ǵ�Ƶ(Term Frequency)��IDF�����ı�Ƶ��ָ��(Inverse Document Frequency)
* TF: Term Frequency
TF(t) = (��t�ڵ�ǰ���г��ִ���)
*
IDF��Inverse Document Frequency
IDF(t) = lg(���ĵ���/�� t���ĵ���):lg
*
TF-IDFȨ�� = TF(t) * IDF(t)
����һƪ�ļ����ܴ�������100����������ھ򡱳�����3�Σ�
* ��ô���ھ�һ���ڸ��ļ��еĴ�Ƶ����3/100=0.03��
*
* һ�������ļ�Ƶ�� (IDF) �ķ������ļ�����������ļ��������Բⶨ�ж��ٷ��ļ����ֹ����ھ�һ�ʡ�
*
* ���ԣ�������ھ�һ����1,000���ļ����ֹ������ļ�������10,000,000�ݵĻ����������ļ�Ƶ�ʾ��� lg(10,000,000 / 1,000)=4��
* ��󣬡��ھ򡱵�TF-IDF��ֵΪ0.03 * 4=0.12��
*/
//////////��֮,������Ҫ��������,���ǰ�ÿ����(t)��TF,��IDF�������,Ȼ����˼��ɵõ������ÿ����t��TF-IDF.
//����������Ҫ��һ�Ź������еĴ�t����ɵĴ��(�����ü���set����HaspMap,���߸���)(Ȼ��,t��IDF��Ψһ��,����t��IFȴ��ͬ���ļ�����)
/*TF-IDF��һ��ͳ�Ʒ�������������һ�ִʶ���һ���ļ�����һ�����Ͽ��е�����һ���ļ�����Ҫ�̶ȡ�
�ִʵ���Ҫ�����������ļ��г��ֵĴ������������ӣ���ͬʱ�������������Ͽ��г��ֵ�Ƶ�ʳɷ����½���

TFIDF����Ҫ˼���ǣ����ĳ���ʻ������һƪ�����г��ֵ�Ƶ��TF�ߣ����������������к��ٳ��֣�����Ϊ�˴ʻ��߶�����кܺõ���������������ʺ��������ࡣTFIDFʵ�����ǣ�TF * IDF��TF��Ƶ(TermFrequency)��IDF�����ļ�Ƶ��(Inverse Document Frequency)��TF��ʾ�������ĵ�d�г��ֵ�Ƶ�ʡ�
IDF����Ҫ˼���ǣ������������t���ĵ�Խ�٣�Ҳ����nԽС��IDFԽ����˵������t���кܺõ��������������

IDF�Ĳ���֮����
���ĳһ���ĵ�C�а�������t���ĵ���Ϊm�������������t���ĵ�����Ϊk����Ȼ���а���t���ĵ���n=m+k����m���ʱ��nҲ�󣬰���IDF��ʽ�õ���IDF��ֵ��С����˵���ô���t�������������ǿ������ʵ���ϣ����һ��������һ������ĵ���Ƶ�����֣���˵���ô����ܹ��ܺô����������ı��������������Ĵ���Ӧ�ø����Ǹ���ϸߵ�Ȩ�أ���ѡ����Ϊ�����ı������������������������ĵ��������IDF�Ĳ���֮��.
���һ����������ҵ�е�ÿһ��΢����ռ��һ�У�����һ���ļ��������ÿ����t������tfdifֵ��Щ��t��tfidf��Ԫ�鹹�ɵ��б����һ������ļ�¼�������΢���еĴ�������
���������һ�����⣬�����¼�ϰ�������ǾͿ����㷨�ĸ�Ч�ԣ�����̫��ı��������ٲ��ܶ���ѭ�����ֲ��������Կ������Զ�α�����
�����У���ͳ����һ��΢���еĸ����ʵ��������һ����map�����Сmap��key��ӵ���map������ÿһ��΢���е�ÿ���ʼ�ʱ��ͬһ��΢�����ֶ�Σ�����Ҳֻ������һ�μ�¼����ɱ����󣬴�map��key��value�е�value�����ļ�����΢�������г��ָ����ؼ���t���ļ���������ÿ����t��idf�Ϳ�����á�Ӧ��֪����idf�Ǵ�t������ļ����ĸ��ÿ����t����ͬһ���ļ�����Ψһȷ����ֵ������Ϊ�ļ����и����ļ��еĴ�t��tfidfʱ������
*/
/*�ֱ������΢�����ݼ�weibo.txt��weibo_data.txt���㣬
���д����ݰ��΢�����ݼ���7�У��ֱ�Ϊ��
�û�ID��΢��ID��΢��ʱ�䡢��������ת��������������΢������
*/
/*���裺
1������ÿ�������� ÿ��΢�� �еĳ��ִ���
2������ÿ�������� ΢�� �еĳ��ִ���
3�������ÿ��΢���� ���д��� ��tf-idfֵ
�����õ�JSONObject�ศ��������
�÷���
JSONObject json = new JSONObject();
json.put();
����
json.accumulate();

*/
public class CountWords {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();//�������ʱ��(part1)
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FileName.fileName4, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName.fileNameOut3/*,StandardCharsets.UTF_8*/, true));

        HashMap<String, Integer> bigMap = new HashMap<>();//ͳ�����ڲ�����idf
        HashMap<String, HashMap<String, Double>> IDMap = new HashMap<>();
        String string = null;
        int countLines = 0;//ͳ���ļ����ļ���(�������˻�Ϊwei_bo.txt������(����΢��"�ļ�"��)
        //todo ���ļ��ж�ȡÿһ��.
        while ((string = bufferedReader.readLine()) != null) {
            //System.out.println(string);
            /*ʹ��hanlp��������*/
            countLines++;
            HashMap<String, HashMap<String, Double>> idMap = new HashMap<>();
            HashMap<String, Double> map = new HashMap<>();//����ͳ�ƴ�Ƶ(ÿ��΢����һ��)

            int IndexOfSeparator = string.indexOf("\t");//�ָ������ַ����е�����
            String IDString = string.substring(0, IndexOfSeparator);//ÿ��΢����ID��
            //IDMap.put(IDString,null);����;
            string = string.substring(IndexOfSeparator + 1);//ÿ��΢��ID��֮�������(��Ϊͳ�Ʒ����Ķ���)
            //todo ��ʼ������ǰ��΢��
            List<Term> termList = HanLP.segment(string);//���ϵ��������ʱ,���Ե�ʱ������������?
            int wordsNumber = 0; //= termList.size();
            //��ÿ��΢���еĴʽ��д�Ƶͳ��(string,Double);
            for (Term x : termList) {
                if (x.nature == Nature.w) continue;
                wordsNumber++;
                String str = x.toString();
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + 1);
                } else {
                    map.put(str, 1.0);
                }
            }//endFor(ÿһ��΢����map������)
            /*����TF��ֵ��(t,tf)*/
            for (String x : map.keySet()) {
                map.put(x, map.get(x) / wordsNumber);
            }
            //list.add(map);//����ǰ��ͳ��map���뵽list��
            //todo ��ÿһ��΢����ID�ź���ͳ��map���.
            IDMap.put(IDString, map);
            //���Դ�ӡ:
            // System.out.println(map);
            //��Ӽ�¼��bigMap��:(ͳ��ĳ����t����������ļ�����IDF�Ĺ���,Ҫ������������΢��,Ȼ�����ʹ�����IDF(��Ҫ�����while����֮��ʹ��.)(key:��t,value:������t���ļ�(΢������)

            //todo �����ļ����к���t���ļ���Ŀ.(t,number)(����bigMap������whileѭ����ͬʹ�õ�)
            for (String x : map.keySet()) {
                if (bigMap.containsKey(x)) {
                    bigMap.put(x, bigMap.get(x) + 1);//��Ҫд��map.get(x)��
                } else {
                    bigMap.put(x, 1);
                }
            }//endFor
            //�ٴμ���:
            // System.out.println(map);
        }//endWhile//����������������


        /*��(t,tf)����Ϊ(t,tf-idf);����,tf-idf=tf*idf;idf=countLines/bigMap.get(x).log10 �����ÿ��΢���и�����t��TF-IDFֵ*/
        /*ǿ�����е��˴�*/
        //todo ����ÿ�����������ڵ�΢���е�tfidfֵ
        for (String ID : IDMap.keySet()) {
            HashMap<String, Double> mapTmp = new HashMap<>();
            mapTmp = IDMap.get(ID);
            for (String s : mapTmp.keySet()) {
                mapTmp.put(s, (mapTmp.get(s)) * (Math.log10((double) countLines / bigMap.get(s))));
            }
            //����:
            //System.out.println(mapTmp);
        }
        for(String ID:IDMap.keySet()){
            System.out.println(ID+"="+IDMap.get(ID));
            bufferedWriter.write(ID+"="+IDMap.get(ID)+"\n");
        }

        bufferedWriter.flush();  //step2:ˢ�»�����
        //step3:�ͷ���Դ:
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("�������.");
        System.out.println("���к�ʱ" + (System.currentTimeMillis() - time1));

    }
}
/*
��:
json.toString()Դ����:
public String toString() {
        if (this.isNullObject()) {
            return JSONNull.getInstance().toString();
        } else {
            try {
                Iterator keys = this.keys();//������
                StringBuffer sb = new StringBuffer("{");//����StringBuffer(ͬʱ���ַ�"{"��ʼ��.

                while(keys.hasNext()) {
                    if (sb.length() > 1) {
                        sb.append(',');//�ڷ�ĩβ�ַ�����','�ָ�.
                    }

                    Object o = keys.next();
                    sb.append(JSONUtils.quote(o.toString()));//quote����
                    sb.append(':');//':'�ָ��ֵ�Ե�key:value
                    sb.append(JSONUtils.valueToString(this.properties.get(o)));
                }

                sb.append('}');//'}'��β
                return sb.toString();//����sb(StringBuffer)��Ӧ���ַ���
            } catch (Exception var4) {
                return null;
            }
        }
    }

* */
/*json.put():
*     public Object put(Object key, Object value) {
        if (key == null) {//���ȼ���쳣.
            throw new IllegalArgumentException("key is null.");
        } else {
            Object previous = this.properties.get(key);
            this.element(String.valueOf(key), value);
            return previous;
        }
    }*/