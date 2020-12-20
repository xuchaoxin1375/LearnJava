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
        /*����Buffered֮��,���ֽڻ�����,Ч�����򾡿��ܵĸ�,���仹���벻��������*/
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
