package experiment9.StudyRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudyRead {

    public static void main(String[] args) {
       String fileName = "D:\\OneDrive\\Java\\ProjectCodeInIDEA\\experiment_doc\\dataExperiment9\\ReadText.txt";
        String fileNameAnother = "D:\\OneDrive\\Java\\ProjectCodeInIDEA\\experiment_doc\\dataExperiment8\\三国演义(罗贯中).txt";
        //D:\OneDrive\Java\ProjectCodeInIDEA\experiment_doc\dataExperiment8\三国演义(罗贯中).txt
        try {
            FileInputStream inputStream = new FileInputStream(fileName);//抛出异常1
            byte[] bytes = new byte[1024]; //存储读取到的多个字节
            int len = 0; //记录读取到的字节数,以便后续利用 String(bytes, 0, len)转换成字符串;
            while ((len = inputStream.read(bytes)) != -1) {//这里由于read的缘故,需要抛出异常2,那么建议添加catch到上一次catch的后面.
//String(byte[] bytes, int offset, int length):把字节数组的一部分转换为字符串
// 字符串offset:数组的开始索引
                System.out.print(new String(bytes, 0, len));//从bytes中的第0个字符开始尽可能读入len个字符,并将之转换位字符串.(然而,字节流在读入文本时(尤其时中文文本的时候,容易产生莫名的符号(即使指定了正确的编码也是由此问题,更合适的做法时用Reader的子类来处理文本的读入)
                /*public String(@NotNull byte[] bytes,
              int offset,
              int length)*/
                inputStream.close();

            }//endWhile
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
