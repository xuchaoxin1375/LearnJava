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

/*���ļ�����������(�޹���).txt�����зִʣ�ȥ�������ź�ͣ�ôʣ�
���ͳ�ƴ�Ƶ������������ļ������������Ƶ.txt�������������ơ�*/
public class StatisticsWords {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();//����ͳ�ƴ�Ƶ
        System.out.println("�����ļ�Ŀ¼:"); //String fileName = new Scanner(System.in).nextLine();
          /*     File file =new File(fileName);//�޷������������ġ�
            Scanner scanner = new Scanner(file);*/
        String fileName = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment8\\��������(�޹���).txt";
        /*����Ŀ¼: D:\ecloud\textbooks\java\experiment_doc\dataExperiment8\��������(�޹�n��).txt
    D:\ecloud\textbooks\java\experiment_doc\dataExperiment8\english.txt    */
        String fileNameOut = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment8\\���������Ƶ.txt";

        try {
            /*�����������������*/
            FileInputStream inputStream = new FileInputStream(fileName);
            ;/*������һ��(�ڵ�)������
            ������������������ݲ���:һ����ʹ�ø��������Ӧ���еķ������в���:
            ����.read()������ȡ��ĳЩ����*/
            FileOutputStream outputStream = new FileOutputStream(fileNameOut);

            //String str;
            byte[] bytes = new byte[1024];/*����һ��byte[]���͵�����(����),�ö���Ĺ��ͨ��new Byte[1024] ������,��bytes���ñ������������������;
            ����������ڴ洢��ʱ��ȡ������,����ע�ⲻҪʹ��byte�İ�װ��Byte,������������*/
            int len = 0;
            try {
                while ((len = inputStream.read(bytes)) != -1) {
                    //System.out.println(new String(bytes,"utf-8"));//Ĭ������gbk����,�����ִ�ӡ�����ʱ�򽫳�������(������ָ����utf-8)������.
                    //String(byte[] bytes, int offset, int length):���ֽ������һ����ת��Ϊ�ַ���
//                    StringTokenizer tokenizer = new StringTokenizer(new String(bytes/*, StandardCharsets.UTF_8*/), "������������������? ��������~��`\\��|");/*������������������ ������~`\?  */
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
                    /*ʹ��hanlp��������*/
                    String s = new String(bytes, StandardCharsets.UTF_8);
                    /*System.out.println(HanLP.segment(s));*/
                  /*  CoreStopWordDictionary.add("??");
                    CoreStopWordDictionary.add(" ");*/

                    /*hanlp�����ַ���s:���ú�����Ч���������⣺*/
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
                    /*ʹ��Term���е�nature��Ա�������������Ƚ����⡣*/
                    //Segment segment = HanLP.newSegment().enableNameRecognize(true);

                    List<Term> termList = StandardTokenizer.segment(s);/*��׼�ִ���*/
                   // System.out.println(termList);//�鿴�ִ�Ч��,���ַ��źʹ��ﶼ�������б��С�
                    for (Term x : termList) {

//                        if (x.nature == Nature.w) {//Term���µ�nature��Ա�Ǵ��ԡ���Nature����������ԣ����ʣ����ʣ��������������������׼..��ϸ�µĻ��֡�public static final Nature nr = new Nature("nr");nr��Ա��������,w���Ǳ����š���ע��ͳ������ʱӦ����x.nature!=Nature.nr��Ϊ����
//                            continue;/*����Ƚϵ�֪��x�����Բ�����������ô����������ͳ�Ʋ������ж��¸���¼*/
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
            }//whileEndIO Ҫ�ر�ע��io�����Ĺرգ�������ѭ����д�����֣�
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