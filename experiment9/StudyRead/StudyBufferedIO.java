package experiment9.StudyRead;

import namesAndStrings.FileName;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StudyBufferedIO {
    /*�����������������ǹ��������ǶԽڵ����İ�װ(Ҳ����˵,�������ڽڵ���,��Ҫ����FileReader/FileInputStream����װʹ��.һ����˵,�Ƽ�ʹ��BufferedIO�������ļ��ȽϺ�(��ֱ�ӵ���ʹ��FileIO���ķ���͸�Ч���� */
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

       bufferedWriter.flush();  //step2:ˢ�»�����
        //step3:�ͷ���Դ:
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("�������.");

    }
}





/*
* try{

        br = new BufferedReader(new
                FileReader("d:\\IOTest\\source.txt"));
        bw = new BufferedWriter(new
                FileWriter("d:\\IOTest\\destBF.txt"));
        String str = null;
        while ((str = br.readLine()) != null) { //һ��
            ��ȡ�ַ��ı��ļ���һ���ַ�
            bw.write(str); //һ��д��һ���ַ���
            bw.newLine();  //д���зָ���
        } bw.flush();  //step2:ˢ�»�����
    }catch(
    IOException e)

    {
        e.printStackTrace();
    }finally

    {
// step3: �ر�IO������
        try {
            if (bw != null) {
                bw.close();  //�رչ�����ʱ,���Զ��ر���
                ����װ�ĵײ�ڵ���

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