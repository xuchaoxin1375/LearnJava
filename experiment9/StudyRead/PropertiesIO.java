package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesIO {
    public static void main(String[] args) throws IOException {
//�½�һ��������
        FileWriter fr = new FileWriter(FileName.prefix3+"userinfo.properties");

        Properties pro = new Properties();

//ͨ��key����ȡvalue
         pro.setProperty("username","jack");

/*username=Jack
password=45678*/
        pro.setProperty("password","45678");
        pro.store(fr, "");//��pro�е���Ϣд�뵽fr��ָ���������
        System.out.println("...\nд�����.");
    }
}
