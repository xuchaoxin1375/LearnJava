package experiment7.exp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/*1����pagerank.txt�е�ÿ���ڵ㣬�����ÿ���ڵ��pagerankֵ����ÿ���ڵ��pagerankֵ����һ�ֵ�pagerankֵ���С��0.001ʱ��
����ֹͣ����������ո��ڵ��pagerankֵ��
2.���ļ�wiki-edges.txt��wiki-vertices.txt������
wiki-vertices.txt�г��ڵ�ı�źͶ�Ӧ����ҳ���⡣(Ŀǰ�ò�����)
wiki-edges.txt�г��ڵ���������ڽӵĽڵ㣨������ʾ����
�ֽ��ļ�wiki-edges.txt��дΪ����pagerank.txt����ʽ�����ڵ���������ڽӽڵ����ʽ��������ʾ����
������ļ�wiki-adjacentnodes.txt�С�
* ���ļ�������䣺
File file=new File("src/com/google/��ҵ��/wiki-edges.txt");
Scanner scanner = new Scanner(file);
while (scanner.hasNext()){
��.
}

д�ļ�������䣺
import java.io.PrintWriter;
PrintWriter pw = new PrintWriter("src/com/google/��ҵ��/wiki-adjacentnodes.txt");

*/
public class calc2 {
    public static void main(String[] args) {
        String dir = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment7";
        String fileName = "\\wiki-edges.txt";/*"\\test.txt";// */
        String saveFileName = "\\wiki-adjacentNodes.txt";
        File file = new File(dir + fileName);
        int N = 0;
        /*����û�б�Ҫ�Զ���һ��Node��:*/
       // ArrayList<Node2> nodeArrayList = new ArrayList<>();list�����㱾��Ҫ��
        /*��LinkedHashMap()Ҳ����(ʹ�ü���ֵ������).*/
        Map<String, String> map = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);/*ע��,��try�г������Ķ����ǲ��ܹ���try֮��ʹ�õ�.��Ϊ�ڳ�������֮ǰ,˭Ҳ��֪������try�еĶ����ܷ񱻴���,���ԾͲ�����try֮�����������ȷ���ܷ񱻴������Ķ���.*/

            while (scanner.hasNext()) {//��ʱ������ζ�ȡ���з�.(.read()����).has..()����ֻ���ж�.
                //ArrayList<String> list = new ArrayList<>();
                N++;
                String[] tuple = scanner.nextLine().split("\\s+");
                /*Ч��̫��û����.����ı�������̫����.*/
//                if ((tuple.length > 1)) {
//                    /*��ArrayList�ڵ�����ʱ�����ͬʱ��������޸ľͻ��׳�java.util.ConcurrentModificationException�쳣*/
//                    for (int i = 0;i<nodeArrayList.size();i++) {
//                        if (nodeArrayList.get(i).name.equals(tuple[0])) {
//                            nodeArrayList.get(i).addNode2(tuple[1]);
//                        } else {
//                            nodeArrayList.add(new Node2(tuple[0],tuple[1]));
//                        }
//                    }
//                }
//                else{
//                    nodeArrayList.add(new Node2(tuple[0],""));
//                }
                if (tuple.length > 1) {
                    if (map.containsKey(tuple[0])) {
                        map.put(tuple[0], map.get(tuple[0]) + "\t" + tuple[1]);
                    } else {
                        map.put(tuple[0], tuple[1]);
                    }
                }


                // System.out.println(N + "running...");���н���ٳٲ���,ͨ����ӡ������ȫֹͣ���ǿ������������з�����.
            }//endWhile
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//endCatch
        try {
            PrintWriter pw = new PrintWriter(dir + saveFileName);
            StringBuffer stringBuffer = new StringBuffer();
            for (String x : map.keySet()) {
//           System.out.println(x+"\t"+map.get(x));
                //stringBuffer.append(x+"\t"+map.get(x));
                pw.write(x+"\t"+map.get(x)+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }//endMain
}//endClass
