package experiment9.StudyRead;
import namesAndStrings.FileName;

import java.io.FileWriter;
import java.io.IOException;

public class StudyWriteContinue {

    public static void main(String[] args) throws IOException {
//1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
        FileWriter fw = new FileWriter(FileName.prefix3+"testWriteContinue",true);
        for (int i = 0; i <10 ; i++) {
            fw.write("HelloWorld"+i+"\r\n");
            System.out.print("HelloWorld"+i+"\r\n");
        }

        fw.close();
    }

}