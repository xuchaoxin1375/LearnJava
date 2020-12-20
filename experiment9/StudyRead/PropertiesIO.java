package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesIO {
    public static void main(String[] args) throws IOException {
//新建一个流对象，
        FileWriter fr = new FileWriter(FileName.prefix3+"userinfo.properties");

        Properties pro = new Properties();

//通过key来获取value
         pro.setProperty("username","jack");

/*username=Jack
password=45678*/
        pro.setProperty("password","45678");
        pro.store(fr, "");//将pro中的信息写入到fr所指定的输出流
        System.out.println("...\n写入完毕.");
    }
}
