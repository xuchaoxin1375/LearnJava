package experiment9.StudyRead;

import namesAndStrings.FileName;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StudyBufferedIO {
    /*创建缓冲流对象：它是过滤流，是对节点流的包装(也就是说,它依赖于节点流,需要基于FileReader/FileInputStream来包装使用.一般来说,推荐使用BufferedIO来操作文件比较好(比直接单纯使用FileIO来的方便和高效智能 */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(FileName.fileName3, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(FileName.fileNameOut2/*,StandardCharsets.UTF_8*/));
        String string=null;

        char [] chars=new char[1000];
        StringBuffer stringBuffer=new StringBuffer();
        while(bufferedReader.read(chars)!=-1){
            stringBuffer.append(chars);
        }
        string=stringBuffer.toString();
        string=string.replaceAll("//", "").replaceAll("/\\*|\\*/","");

        System.out.println(string);
        bufferedWriter.write(string);

       bufferedWriter.flush();  //step2:刷新缓冲区
        //step3:释放资源:
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("操作完毕.");

    }
}





/*
* try{

        br = new BufferedReader(new
                FileReader("d:\\IOTest\\source.txt"));
        bw = new BufferedWriter(new
                FileWriter("d:\\IOTest\\destBF.txt"));
        String str = null;
        while ((str = br.readLine()) != null) { //一次
            读取字符文本文件的一行字符
            bw.write(str); //一次写入一行字符串
            bw.newLine();  //写入行分隔符
        } bw.flush();  //step2:刷新缓冲区
    }catch(
    IOException e)

    {
        e.printStackTrace();
    }finally

    {
// step3: 关闭IO流对象
        try {
            if (bw != null) {
                bw.close();  //关闭过滤流时,会自动关闭它
                所包装的底层节点流

            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/