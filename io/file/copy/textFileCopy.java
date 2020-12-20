package io.file.copy;

import namesAndStrings.FileName;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @Author xuchaoxin
 * @Date 12/20/2020 4:50 PM
 * @Version 1.0
 */
public class textFileCopy {

    public static void binaryFileCopy(String srcPathAndFileNameStr,String desPathAndFileNameStr) throws IOException {
        /*套上Buffered之后,是字节缓冲流,效率区域尽可能的高,但其还是离不开基础流*/
        BufferedReader bufferedReader= new BufferedReader(new FileReader(srcPathAndFileNameStr, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(desPathAndFileNameStr));
        String line;
        while((line=bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();

    }

    public static void main(String[] args) throws IOException {
        binaryFileCopy(FileName.fileName10_1,FileName.desktopPath +"text File.bak.txt");
        System.out.println("task end!");
    }
}
