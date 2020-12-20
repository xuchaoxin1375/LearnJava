package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileReader;
import java.io.IOException;

public class StudyReader {
    public static void main(String[]args) throws IOException {
        FileReader reader= new FileReader(FileName.fileName);//为了是内部代码简洁直观,先将异常跑到方法外,即生命该方法为throws Exception(直接使用异常的根类可以一步到位,不需要反复更改,但是其精度也相应收到ying'xiang影响.
        int len;
        while ((len=reader.read())!=-1){
            System.out.print((char)len);
            /*FileReader.read():Return The character read(ASCII int), or -1 if the end of the stream has been reached*/

        }
        reader.close();
    }
}
