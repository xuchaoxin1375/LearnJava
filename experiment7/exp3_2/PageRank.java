package experiment7.exp3_2;

import namesAndStrings.FileName;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PageRank {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int count = 1; //count记录程序的运行次数
        final double q = 0.85;
        double error = 0.001;
//        int N = 5;
//        int N=22424;
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<String, Double> vertex; //用于计算节点的pagerank
        File file = new File(FileName.fileName7_3);
        // File file = new File("src/com/google/作业七/wiki-adjacentnodes.txt");

        String page;  //pagerank.txt中的一行
        String[] parts;
        int num_nodes=0;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                page = scanner.nextLine().trim();
                //parts=page.split("\t{1}",2); //按第一个\t分割成2部分
                Node node = null;
                node = Node.buildAdjacentNodes(count, page);
                nodes.add(node);
                num_nodes++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("节点数：%d", num_nodes));

        System.out.println("---------初始化输出---------");
        for (Node node : nodes) {
            System.out.println(node);
        }


        while (true) {
            count++;

            //迭代计算每个节点的pagerank值
            vertex = new HashMap<>();
            init_vertexes(vertex, nodes); //初始化
            // System.out.println(vertex); //{A=0.0, B=0.0, C=0.0, D=0.0}

            for (Node node : nodes) {
                if (node.containsAdjacentNodes()) {
                    //System.out.println("node.getName()= "+node.getName());
                    // node.getName()= 4289168012538570878
                    // 4289168012538570878	4315052278831489964	8830299306937918434
                    double outPageRank = node.getPageRank() / node.getAdjacentNodeNames().length;
                    for (int i = 0; i < node.getAdjacentNodeNames().length; i++) {
                        String outPageName = node.getAdjacentNodeNames()[i]; //第i个邻接的节点
                        // vertex.put(outPageName, (1 - q) /num_nodes + q * (vertex.get(outPageName) + outPageRank));
                        vertex.put(outPageName, vertex.get(outPageName) + outPageRank); //每个节点的pageRank更新
                        // 这个是只算和，不加 (1 - q) /num_nodes+q*()
                        //每个节点的pageRank更新，其中vertex.get(outPageName)是outPageName旧的pagerank值
                        //System.out.println("vetex= "+vertex);
                        //vertex.put(outPageName, vertex.get(outPageName) + outPageRank);//每个节点的pageRank更新
                    }
                }
            }

            // 计算节点最终的pagerank值
            System.out.println("求和部分：");
            for(String key: vertex.keySet()){
                System.out.println("vertex.get("+key+")= "+vertex.get(key));
                vertex.put(key, (1 - q) /num_nodes + q *vertex.get(key)); //节点最终的pagerank值
            }

            boolean b = true;
            for (Node node : nodes) {
                b = b & (Math.abs(node.getPageRank() - vertex.get(node.getName())) <= error);
            }

            if (b) {
                break;
            }

            System.out.println();
            System.out.println("---------迭代计算出的pagerank值---------");
            System.out.println(vertex);

            //将vertex所有节点的pagerank值保存至node中
            for (Node node : nodes) {
                //node.setPageRank(vertex.get(node.getName()));
                node.setPageRank(vertex.get(node.getName())); //修正后的pagerank值
            }

            System.out.println();
            System.out.println(String.format("---------第%d轮的节点pagerank值---------", count));
            // ---------第30轮的节点pagerank值---------

            //输出到控制台
            /* for (Node node : nodes) {
                 System.out.println(node);
            }*/
        }

        //输出到文件
        try {
            //PrintWriter pw = new PrintWriter("src/com/google/作业七/pagerank_of_node.txt");
            // FileWriter fw = new FileWriter("src/com/google/作业七/pagerank_of_node.txt");
            FileWriter fw = new FileWriter("src/com/google/作业七/pagerank_of_5node2.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Node node : nodes) {
                fw.write(node.getName() + ":"+node.getPageRank());
                if (node.getAdjacentNodeNames() != null) {
                    for (String nodeName : node.getAdjacentNodeNames()) {
                        fw.write("\t" + nodeName);
                    }
                }
                fw.write("\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(String.format("程序执行时间为%d毫秒",end-start));
        // 程序执行时间为1742毫秒
}

    // 初始化vertex
    public static void init_vertexes(HashMap<String,Double> vertex, ArrayList<Node> nodes){
        for (Node node : nodes) {
            vertex.put(node.getName(), 0.0);
        }
    }
}
