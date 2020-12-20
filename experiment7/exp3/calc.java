package experiment7.exp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
public class calc {
    public static void main(String[] args) {
        String dir = "D:\\ecloud\\textbooks\\java\\experiment_doc\\dataExperiment7";
        String fileName="\\pagerank.txt";
        String fileName2="\\wiki-adjacentNodes.txt";
        File file = new File(dir + fileName);
        final double q = 0.85;//阻尼系数
        int N = 0;//节点数
        final double initialValue = 1;
        /*Set<String> set=new HashSet<>();*//*这里要统计的对象是字符串(字符也可,但String更通用),
        不需要重写equals和hashCode方法.用来求不同的节点数目N(不过这里的文件中的行数就是N,所以不必求了*/
        /*计算出L(i)
         * 考虑做出一系列的i-L(i)键值对来保存各个节点的出度输出值
         * 考虑用数组来累加在迭代是收到的输入值(做二次扫描,从读入的各个行的第二个节点号开始).*/
        Map<String, Double> map = new HashMap<>();
        //ArrayList<ArrayList<String>> twoDimensionList = new ArrayList<>();
        /*建议用针对性更强的自定一个Node类:*/
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);/*注意,在try中出创建的对象是不能够在try之外使用的.因为在程序运行之前,谁也不知道到底try中的对象能否被创建,所以就不能在try之外利用这个不确定能否被创建出的对象.*/

//            String[][] twoDimensionArray;//需要制定大小(行数,不太方便)
            while (scanner.hasNext()) {//届时看看如何读取换行符.(.read()方法).has..()方法只做判断.
                ArrayList<String> list = new ArrayList<>();
                for (String x : scanner.nextLine().split("\\s+")) {
                    list.add(x);
                    N++;
                }//正则表达式\s表示匹配任何空白字符，+表示匹配一次或多次。
                //map.put(list.get(0),list.size()-1 );
                /*
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine()," ");

                while (stringTokenizer.hasMoreElements()){
                    list.add((String)stringTokenizer.nextElement());
                }**/   //都不完善
/*List转换为Array可以这样处理：

String[] strings = new String[list.size()];

list.toArray(strings);*/
                String[] strings = new String[list.size() - 1];
                nodeArrayList.add(new Node(initialValue, list.get(0), list.subList(1, list.size()).toArray(strings)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//endCatch
        //System.out.println(twoDimensionList);
        /*       *//*分析各个列表中的元素数目,创建初始键值对.:*//*
        for (ArrayList<String> x : twoDimensionList){
            map.put(x.get(0),initialValue/x.size()-1);
        }*/
        // System.out.println(nodeArrayList);//正常写入节点.
        /*打印结果:*/
        System.out.println("---------初始化输出---------");
                    //System.out.println(nodeArrayList);
        for (Node x : nodeArrayList) {
            System.out.println(x);
        }
        int cnt = 1;
        //循环起来:
        boolean flag=false;
        while (!flag) {
            boolean stop = true;//flag:默认满足条件(从循环中if到不满足的某个条件时(把flag改了,在break出来)
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
                                // y.addTmpCount(x.PageRank/x.getAdjacentNodeNames().length);高耦合
                                y.addTmpCount(x.getOutValue());

                            }

                        }
                    }
                }
            }
            for (Node k : nodeArrayList) {
                k.setPageRank();//完成迭代
            }

            System.out.println("---------迭代计算出的pagerank值---------");
                /*将这一部分作为toString*/
            System.out.print("{");
            int i=0;
            for (Node x : nodeArrayList) {
                System.out.print(x.getName() + "=" + x.getPageRank() );
                if ((++i<nodeArrayList.size())) {
                    System.out.print(",");
                }
            }
            System.out.println("}");


            System.out.println("---------第" + ++cnt + "轮的节点pagerank值---------");
            for (Node x : nodeArrayList) {
                System.out.println(x);
            }
        }//endWhile

    }//endMain
}//endClass
