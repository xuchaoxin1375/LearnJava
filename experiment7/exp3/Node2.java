package experiment7.exp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node2 {
    double PageRank;//�ڵ��pagerankֵ

    @Override
    public String toString() {
        return "Node2{" +
                "PageRank=" + PageRank +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    String name;//�ڵ���
    //Set<String> set=new HashSet<>();//����ȥ��.
    List<String> list=new ArrayList<>();
    public Node2(String name, String adj) {
        this.name = name;
        list.add(adj);
    }

    public double getPageRank() {
        return PageRank;
    }

    public void setPageRank(double pageRank) {
        PageRank = pageRank;
    }

    public String getName() {
        return name;
    }
public void addNode2(String newNodeName){
        list.add(newNodeName);
}
    public void setName(String name) {
        this.name = name;
    }



}
