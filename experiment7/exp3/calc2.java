package experiment7.exp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/*1、读pagerank.txt中的每个节点，计算出每个节点的pagerank值，当每个节点的pagerank值与上一轮的pagerank值相差小于0.001时，
迭代停止，并输出最终各节点的pagerank值。
2.读文件wiki-edges.txt和wiki-vertices.txt，其中
wiki-vertices.txt列出节点的编号和对应的网页标题。(目前用不到它)
wiki-edges.txt列出节点和其向外邻接的节点（多行显示）。
现将文件wiki-edges.txt改写为类似pagerank.txt的形式，即节点和其向外邻接节点的形式（单行显示）。
输出到文件wiki-adjacentnodes.txt中。
* 读文件可用语句：
File file=new File("src/com/google/作业七/wiki-edges.txt");
Scanner scanner = new Scanner(file);
while (scanner.hasNext()){
….
}

写文件可用语句：
import java.io.PrintWriter;
PrintWriter pw = new PrintWriter("src/com/google/作业七/wiki-adjacentnodes.txt");

*/
public class calc2 {
    public static void main(String[] args) {
        String dir = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment7";
        String fileName = "\\wiki-edges.txt";/*"\\test.txt";// */
        String saveFileName = "\\wiki-adjacentNodes.txt";
        File file = new File(dir + fileName);
        int N = 0;
        /*这里没有必要自定义一个Node类:*/
       // ArrayList<Node2> nodeArrayList = new ArrayList<>();list不满足本题要求
        /*用LinkedHashMap()也可以(使用键对值来加速).*/
        Map<String, String> map = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);/*注意,在try中出创建的对象是不能够在try之外使用的.因为在程序运行之前,谁也不知道到底try中的对象能否被创建,所以就不能在try之外利用这个不确定能否被创建出的对象.*/

            while (scanner.hasNext()) {//届时看看如何读取换行符.(.read()方法).has..()方法只做判断.
                //ArrayList<String> list = new ArrayList<>();
                N++;
                String[] tuple = scanner.nextLine().split("\\s+");
                /*效率太低没法用.过多的遍历开销太大了.*/
//                if ((tuple.length > 1)) {
//                    /*对ArrayList在迭代的时候如果同时对其进行修改就会抛出java.util.ConcurrentModificationException异常*/
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


                // System.out.println(N + "running...");运行结果迟迟不出,通过打印看是完全停止还是开销过大导致运行反馈慢.
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
