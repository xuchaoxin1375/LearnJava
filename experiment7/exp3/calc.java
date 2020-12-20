package experiment7.exp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
public class calc {
    public static void main(String[] args) {
        String dir = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment7";
        String fileName="\\pagerank.txt";
        String fileName2="\\wiki-adjacentNodes.txt";
        File file = new File(dir + fileName);
        final double q = 0.85;//����ϵ��
        int N = 0;//�ڵ���
        final double initialValue = 1;
        /*Set<String> set=new HashSet<>();*//*����Ҫͳ�ƵĶ������ַ���(�ַ�Ҳ��,��String��ͨ��),
        ����Ҫ��дequals��hashCode����.������ͬ�Ľڵ���ĿN(����������ļ��е���������N,���Բ�������*/
        /*�����L(i)
         * ��������һϵ�е�i-L(i)��ֵ������������ڵ�ĳ������ֵ
         * �������������ۼ��ڵ������յ�������ֵ(������ɨ��,�Ӷ���ĸ����еĵڶ����ڵ�ſ�ʼ).*/
        Map<String, Double> map = new HashMap<>();
        //ArrayList<ArrayList<String>> twoDimensionList = new ArrayList<>();
        /*����������Ը�ǿ���Զ�һ��Node��:*/
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);/*ע��,��try�г������Ķ����ǲ��ܹ���try֮��ʹ�õ�.��Ϊ�ڳ�������֮ǰ,˭Ҳ��֪������try�еĶ����ܷ񱻴���,���ԾͲ�����try֮�����������ȷ���ܷ񱻴������Ķ���.*/

//            String[][] twoDimensionArray;//��Ҫ�ƶ���С(����,��̫����)
            while (scanner.hasNext()) {//��ʱ������ζ�ȡ���з�.(.read()����).has..()����ֻ���ж�.
                ArrayList<String> list = new ArrayList<>();
                for (String x : scanner.nextLine().split("\\s+")) {
                    list.add(x);
                    N++;
                }//������ʽ\s��ʾƥ���κοհ��ַ���+��ʾƥ��һ�λ��Ρ�
                //map.put(list.get(0),list.size()-1 );
                /*
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine()," ");

                while (stringTokenizer.hasMoreElements()){
                    list.add((String)stringTokenizer.nextElement());
                }**/   //��������
/*Listת��ΪArray������������

String[] strings = new String[list.size()];

list.toArray(strings);*/
                String[] strings = new String[list.size() - 1];
                nodeArrayList.add(new Node(initialValue, list.get(0), list.subList(1, list.size()).toArray(strings)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//endCatch
        //System.out.println(twoDimensionList);
        /*       *//*���������б��е�Ԫ����Ŀ,������ʼ��ֵ��.:*//*
        for (ArrayList<String> x : twoDimensionList){
            map.put(x.get(0),initialValue/x.size()-1);
        }*/
        // System.out.println(nodeArrayList);//����д��ڵ�.
        /*��ӡ���:*/
        System.out.println("---------��ʼ�����---------");
                    //System.out.println(nodeArrayList);
        for (Node x : nodeArrayList) {
            System.out.println(x);
        }
        int cnt = 1;
        //ѭ������:
        boolean flag=false;
        while (!flag) {
            boolean stop = true;//flag:Ĭ����������(��ѭ����if���������ĳ������ʱ(��flag����,��break����)
            for(Node x:nodeArrayList){
                if (x.getDelta()>0.001) {
                    stop=false;
                    break;
                }
            }
            flag=stop;
            for (Node x : nodeArrayList) {
                //System.out.println(x);
                if ((x.getAdjacentNodeNames().length > 0)) {
                    for (int i = 0; i < x.getAdjacentNodeNames().length; i++) {
                        for (Node y : nodeArrayList) {
                            if (x.getAdjacentNodeNames()[i].equals(y.getName())) {
                                // y.addTmpCount(x.PageRank/x.getAdjacentNodeNames().length);�����
                                y.addTmpCount(x.getOutValue());

                            }

                        }
                    }
                }
            }
            for (Node k : nodeArrayList) {
                k.setPageRank();//��ɵ���
            }

            System.out.println("---------�����������pagerankֵ---------");
                /*����һ������ΪtoString*/
            System.out.print("{");
            int i=0;
            for (Node x : nodeArrayList) {
                System.out.print(x.getName() + "=" + x.getPageRank() );
                if ((++i<nodeArrayList.size())) {
                    System.out.print(",");
                }
            }
            System.out.println("}");


            System.out.println("---------��" + ++cnt + "�ֵĽڵ�pagerankֵ---------");
            for (Node x : nodeArrayList) {
                System.out.println(x);
            }
        }//endWhile

    }//endMain
}//endClass
