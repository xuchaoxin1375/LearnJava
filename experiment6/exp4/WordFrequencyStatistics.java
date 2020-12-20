package experiment6.exp4;
/*
��7���ļ�Lincoln, Abraham - The Writings of Abraham Lincoln Volume 1.txt     ~    Lincoln, Abraham - The Writings of Abraham Lincoln Volume 7.txt�е�
���е��ʽ��д�Ƶͳ�ƣ�
Ҫ��ȥ��ͣ�ôʡ�
ȥ�� ������β �ı����ţ�
������Ƶ��С�� ��������
д���ļ�WordCount.txt�С�
����HashMapʵ�ֵ��ʴ�Ƶ��¼��
д�ļ�������䣺
import java.io.PrintWriter;
PrintWriter pw = new PrintWriter("data/wordcount.txt");
pw.write();

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class WordFrequencyStatistics {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();
        Set<String> stopWordsSet = new HashSet<>();/*Set��Ķ�����String,����Ҫ��дequals��hashCode����.*/
        /*�������ļ������ݵ�list��ȥ.*/
        /*�����ļ����ṹ,�Ա�����ѭ����������.*/
        String filesDirectory = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment6";
        String filenamesPre = filesDirectory + "\\Lincoln, Abraham - The Writings of Abraham Lincoln Volume ";
        int no = 1;
        String filenamesPos = ".txt";
        Scanner scanner;
        /*��ȡͣ�ô�:*/
        File fileStopWord = new File(filesDirectory + "\\stopwords" + filenamesPos);
        try {
            scanner = new Scanner(fileStopWord);
            String stringStopWord = scanner.nextLine();
            for (; scanner.hasNextLine(); stringStopWord = scanner.nextLine())
                stopWordsSet.add(stringStopWord);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*��ʼ��������ļ�,������(�������7���ļ�)*/
        for (; no < 8; no++) {
//File �����Ƕ�����for�е�,��,����ÿ�ν���forʱ,File���ʵ��������file,�����ڶ���ͨ��new��ʵ������,������Щͬ��File�����ǲ�ͬ��.
            File file = new File(filenamesPre + no + filenamesPos);
            // File file2 = new File("Lincoln, Abraham - The Writings of Abraham Lincoln Volume 2.txt");
            try {
                scanner = new Scanner(file);
                String s;

                for (s = scanner.nextLine(); scanner.hasNextLine(); s = scanner.nextLine()) {
                    StringTokenizer tokenizer = new StringTokenizer(s, "  #*-,.!:;\"$()[]\\&?");//delimiter�綨��
                    String str;
                    /*����(�޳�ͣ�ô�)�������������ĵ�����ӵ�list��*/
                    while (tokenizer.hasMoreElements()) {//��һ���е����е���(������tokenizer��)
                        str = (String) tokenizer.nextElement();//�����ػ�ȡ����
                        /*�ų�ͣ�ô�(����1)*/
                        if (!stopWordsSet.contains(str.toLowerCase()))/*//���Ӵ�Сд������(�����ṩ��StopWords�еĵ��ʶ���Сд��,
                    ���ֻ��Ҫ������Ľ����Ƚ��ַ�תΪ��Сд���ɴﵽЧ��(���б�Ҫ,���Խ�listStopWord�еĵ���Ҳ��תΪСд,���Դﵽ���Դ�Сд��Ч��.*/
                        {
                            list.add(str);
                        }//endIf
                        /*����2:(����Ͳ��Ƽ�,ʱ�俪���ȷ���һ��Ķ�)*/
//                        boolean isEliminate = false;
//                        for (String x : stopWordsSet) {
//                            if (str.compareToIgnoreCase(x) == 0)/*public int compareToIgnoreCase(@NotNull String str)*/ {
//                                isEliminate = true;
//                                break;
//                            }//endIf
//                        }//endFor
//                        if (isEliminate == false)
//                            list.add(str);

                    }//endWhile

                }/*endfor����,�ɹ��������ݵ�list��*/

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }//endCatch
        }//endFor

        /*��ʼ����mapͳ�ƴ�Ƶ:*/
        for (String x : list) {
            if (!map.containsKey(x)) {
                map.put(x, 1);
            } else
                map.put(x, map.get(x) + 1);
        }

        List<Tuple> listTuples = new ArrayList<>();
        for (String x : map.keySet()) {
            listTuples.add(new Tuple(x, map.get(x)));
        }
        Collections.sort(listTuples, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        /*��ӡ���*/
//        //System.out.println(listTuples);
//        for (Tuple x : listTuples) {
//            System.out.println(x);
//        }
        /*�����������ļ���*/
        /*�����ļ�*/
        PrintWriter pw = null;
        try {
            //pw = new PrintWriter(filesDirectory+"/data/wordcount.txt");
            pw = new PrintWriter("C://users//xuchaoxin//desktop//wordcount.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*д�뷽ʽ1:*/
//        for (Tuple x : listTuples) {
//            pw.write(x.toString());
//        }//endFor
        /*д�뷽ʽ2:*/
        StringBuffer sb=new StringBuffer();
        for(Tuple x:listTuples){
            sb.append(x.toString());
        }
        System.out.println(sb);//��ʵ�Ǵ�ӡ��sb.toString();
        pw.write(sb.toString());
    }//endMain
}
