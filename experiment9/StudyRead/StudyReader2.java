package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class StudyReader2 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(FileName.fileName2, Charset.forName("utf-8"));//为了是内部代码简洁直观,先将异常跑到方法外,即生命该方法为throws Exception(直接使用异常的根类可以一步到位,不需要反复更改,但是其精度也相应收到ying'xiang影响.(而当指定读入的文标时utf-8编码时,应当在创建FileReader的时候就给予指定编码:Charset.forName(utf-8),基本就能正常读入了.
        int len;
        char[] chars = new char[1000];//这里就和InputStream流中的read(Byte[])有所区别.
        while ((len = reader.read(chars)) != -1) {
            System.out.print(new String(chars,0,len));
            /*FileReader.read():Return The character read(ASCII int), or -1 if the end of the stream has been reached*/
        }
        reader.close();//勿忘
    }
}

