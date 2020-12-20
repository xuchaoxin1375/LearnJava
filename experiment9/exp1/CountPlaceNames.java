package experiment9.exp1;
/*ͳ����������С˵�г��ֶ��ٸ���������������Ƶ����������ļ�*/
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

/*���ļ�����������(�޹���).txt�����зִʣ�ȥ�������ź�ͣ�ôʣ�
���ͳ�ƴ�Ƶ������������ļ������������Ƶ.txt�������������ơ�*/
public class CountPlaceNames {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();//����ͳ�ƴ�Ƶ
        /*���������м���������Խ�һ��Ϊ�޸�����Դ�ṩ����,ֻ��Ҫʹ�ñ�ʶ�������ܹ���*/
        String fileName = FileName.fileName2;
        String fileNameOut = FileName.fileNameOut4;

        try {
            /*�����������������*/
            FileInputStream inputStream = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream(fileNameOut);
//            BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName,StandardCharsets.UTF_8));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameOut,StandardCharsets.UTF_8));
            byte[] bytes = new byte[1024];
            try {
                while (( inputStream.read(bytes)) != -1) {
                    /*ʹ��hanlp��������*/
                    String s = new String(bytes, StandardCharsets.UTF_8);//ֵ��ע�����,�������ֻ�ǽ�bytes����ת��Stringʱ��ͷת��β,�Ͳ���Ҫ����int len����¼��ȡ���ֽ���.
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
            }//endTry Ҫ�ر�ע��io�����Ĺرգ�������ѭ����д�����֣�,������ĩд.
            catch (IOException ioException) {
                ioException.printStackTrace();
            }

            List<Tuple> list = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            for (String x : map.keySet()) {
                list.add(new Tuple(x, map.get(x)));
            }//endFor
            /*����Tuple���󣬲���Tuple��������б���һ��ִ������*/
            Collections.sort(list, new Comparator<>() {
                @Override
                public int compare(Tuple o1, Tuple o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            /*���ӳ�һ�����ַ���*/
            for (Tuple x : list) {
                stringBuffer.append(x);
            }
            System.out.println(stringBuffer);
            /*д���ļ�*/
            outputStream.write(stringBuffer.toString().getBytes());
            /*�ر�io�����ͷ���Դ*/
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
