package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileReader;
import java.io.IOException;

public class StudyReader {
    public static void main(String[]args) throws IOException {
        FileReader reader= new FileReader(FileName.fileName);//Ϊ�����ڲ�������ֱ��,�Ƚ��쳣�ܵ�������,�������÷���Ϊthrows Exception(ֱ��ʹ���쳣�ĸ������һ����λ,����Ҫ��������,�����侫��Ҳ��Ӧ�յ�ying'xiangӰ��.
        int len;
        while ((len=reader.read())!=-1){
            System.out.print((char)len);
            /*FileReader.read():Return The character read(ASCII int), or -1 if the end of the stream has been reached*/

        }
        reader.close();
    }
}
