package experiment7.exp3_2;


import java.io.IOException;

public class Node {

    private double pageRank;
    private String name; //节点名
    //private HashMap<String,Double> vertex;
    private String[] adjacentNodeNames; //节点Node的邻接矩阵
    // private ArrayList<String> adjacentNodeNames2;

//    public  static final char separator='\t';
    public  static final String separator="\t";

    public double getPageRank() {
        return pageRank;
    }

    public void setPageRank(double pageRank) {
      this.pageRank = pageRank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAdjacentNodeNames() {
    return adjacentNodeNames;
  }

    public Node setAdjacentNodeNames(String[] adjacentNodeNames){
       this.adjacentNodeNames=adjacentNodeNames;
       return this;
    }

//    public HashMap<String, Double> getVertex() {
//        return vertex;
//    }

//    public void setVertex(HashMap<String, Double> vertex) {
//        this.vertex = vertex;
//    }

    //判定节点是否有邻接节点
    public boolean containsAdjacentNodes(){
        return adjacentNodeNames!=null && adjacentNodeNames.length>0;
    }

    @Override
    public String toString(){
      StringBuffer sb = new StringBuffer();
      sb.append(name).append(":").append(pageRank);
      //sb.append(pageRank);

      if (getAdjacentNodeNames()!=null){
//        sb.append(separator).append(StringUtils.join(getAdjacentNodeNames(),separator));
        sb.append(separator).append(String.join(separator,getAdjacentNodeNames()));
        // String.join()将数组或集合以某拼接符拼接到一起形成新的字符串
      }
      return sb.toString();
    }

    //输出到文件
//    public void output(){
//        try {
//            PrintWriter pw = new PrintWriter("src/com/google/作业七/pagerank_of_node.txt");
//            pw.write(name+":");
//            if (getAdjacentNodeNames()!=null) {
//                for (String nodeName : getAdjacentNodeNames()) {
//                    pw.write("\t"+nodeName);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    //从字符串 A:1.0	B	D 封装成Node对象,A后面的:1.0是调用toString()方法产生的
    public static Node buildAdjacentNodes(int count,String page) throws IOException {
//         String[] parts=StringUtils.splitPreserveAllTokens(value,separator); //切分后的空格会保留
        String[] parts=page.split("\t{1}",2); //按第一个\t分割成2部分
        if (parts.length<1){
            throw  new IOException("Expected 1 or more parts but received "+ parts.length);
        }

        Node node=new Node(); //创建一个Node
        if (count==1) node.pageRank=1.0; // count==1表示是第一轮运行，pageRank赋初值1.0
        // HashMap<String, Double> vertex = new HashMap<>();
        node.name=parts[0];
        //vertex.put(node.name,Double.valueOf(node.pageRank));

        if (parts.length>1){
            // parts[1].replaceAll("\t",""); //去掉["B","\t","D"]中间的"\t"
            String[] adjacent=parts[1].split("\t"); //变为["B","D"]
            node.setAdjacentNodeNames(adjacent);
        }
        return node;
    }
}
