package experiment7.exp3_2;
import namesAndStrings.FileName;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Transformer {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        String line;
        String line2;
        String[] parts;
        HashMap<String, ArrayList<String>> map= new HashMap<>();
        //map为顶点和其邻接顶点集的二元组集合

        File file=new File(FileName.fileName7_1);
        File file2=new File(FileName.fileName7_2);

        try {
            Scanner scanner = new Scanner(file); // 读取边集和
            Scanner scanner2= new Scanner(file2); // 读取节点集合

            while (scanner2.hasNext()){
                line= scanner2.nextLine().trim();
                parts=line.split("\t");
                map.put(parts[0],null); //初始化map集合
            }

            while (scanner.hasNext()){ //将所有节点编号加载至node中
                line2=scanner.nextLine().trim();
                parts=line2.split("\t");
                // Node node = new Node();
                // node.setName(parts[0]); //读取的节点号加载到node中为node的name
                ArrayList<String> strArr = new ArrayList<>(); // strArr存放节点的链接节点数组

               /* if (!map.containsKey(parts[0])){ //节点第一次加入map中
                    strArr.add(parts[1]); //将邻接节点加入
                    map.put(parts[0],strArr);
                }else{
                    map.get(parts[0]).add(parts[1]);
                }*/

                if (map.get(parts[0])==null){ //节点第一次加入map中
                    strArr.add(parts[1]); //将邻接节点加入
                    map.put(parts[0],strArr);
                }else{
                    map.get(parts[0]).add(parts[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println(String.format("总的节点数为%d", map.size()));
        // 总的节点数为22424

        //输出到控制台
       /* for (String key : map.keySet()){
            ArrayList<String> arr=map.get(key);
            System.out.print(key+"\t");
            for (String s : arr) {
                System.out.print(s+"\t");
            }
            System.out.println();
        }*/


        //输出到文件
        try {
            // PrintWriter pw = new PrintWriter("src/com/google/作业七/wiki-adjacentnodes3.txt");
            FileWriter fw = new FileWriter(FileName.fileNameOut7_1);
            BufferedWriter bw = new BufferedWriter(fw);

            int count=0;
            for (String key: map.keySet()) {
                count++;
                ArrayList<String> arr = map.get(key);
                bw.write(key);
                if (arr != null) {
                    //pw.write(key + "\t");
                    for (String s : arr) {
                        bw.write( "\t"+s);
                    }
                    //fw.write("\n");
                }
                bw.write("\n");
            }
            bw.close(); //务必关闭，否则输出不正确
            System.out.println("count= "+count); // count= 22424  22105
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end=System.currentTimeMillis();
        System.out.println(String.format("程序执行时间 %d 毫秒", end-start));

    }
}
