package experiment10.exp2;

import java.util.ArrayList;
import java.util.List;

public class WordNode {
    String word;
    List<String> list = new ArrayList<>();

    public WordNode(String word) {
        this.word = word;
        //this.list = list;
    }

    public String getWord() {
        return word;
    }

    public List<String> getList() {
        return list;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void addToList(String fileNameAndFrequency) {
        list.add(fileNameAndFrequency);
    }

    @Override
    public String toString() {
        StringBuffer buffer=new StringBuffer();
        for(String phrase:list){
            buffer.append(phrase+"\t");
        }
        return word+"="+buffer+"\n";
    }
}
