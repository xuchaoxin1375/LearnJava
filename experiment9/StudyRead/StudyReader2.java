package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class StudyReader2 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(FileName.fileName2, Charset.forName("utf-8"));//Ϊ�����ڲ�������ֱ��,�Ƚ��쳣�ܵ�������,�������÷���Ϊthrows Exception(ֱ��ʹ���쳣�ĸ������һ����λ,����Ҫ��������,�����侫��Ҳ��Ӧ�յ�ying'xiangӰ��.(����ָ��������ı�ʱutf-8����ʱ,Ӧ���ڴ���FileReader��ʱ��͸���ָ������:Charset.forName(utf-8),������������������.
        int len;
        char[] chars = new char[1000];//����ͺ�InputStream���е�read(Byte[])��������.
        while ((len = reader.read(chars)) != -1) {
            System.out.print(new String(chars,0,len));
            /*FileReader.read():Return The character read(ASCII int), or -1 if the end of the stream has been reached*/
        }
        reader.close();//����
    }
}

