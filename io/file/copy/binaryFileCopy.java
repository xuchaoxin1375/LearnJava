package io.file.copy;

import namesAndStrings.FileName;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.*;

public class binaryFileCopy {
/*�����ı��ļ�*/

    public static void binaryFileCopy(String srcFile,String desFileName) throws IOException {
        // BufferedReader bufferedReader= new BufferedReader(new FileReader(FileName.fileName10_1, StandardCharsets.UTF_8));
        /*����Buffered֮��,���ֽڻ�����,Ч�����򾡿��ܵĸ�,���仹���벻��������*/
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(desFileName));//��ҪдĿ¼��:"d:/"֮���,���ļ���!!
//        byte[] bytes = bufferedInputStream.readAllBytes();//�����������ͨ��(������С���ݺܷ���,һ�仰)
        /**
         * ���������ж�ȡ����ʣ����ֽڡ� �÷�����������ֱ���Ѷ�ȡ����ʣ���ֽڲ���⵽����ĩβ�������쳣�� �˷�������ر���������
         *
         * ��������������ĩβʱ���Ը÷����Ľ�һ�����ý�����һ�����ֽ����顣
         *
         * ��ע�⣬�˷����������ڼ򵥵����������Щ����£��������ֽڶ����ֽ�����ܷ��㡣 ���������ڶ�ȡ���д������ݵ���������
         *
         * ���������첽�رջ��ڶ�ȡ�������̱߳��жϵ�����µ���Ϊ�Ǹ߶��ض����������ģ����δָ����
         *
         * �������������ȡʱ����I / O����������ڶ�ȡ��һ���֣�������ȫ�����ֽ�֮����������� ��ˣ����������ܲ�������ĩβ�����ҿ��ܴ��ڲ�һ��״̬�� ǿ�ҽ����������I / O�����������ر�����
         */
        /*��Ϊ���Եķ�ʽ:ѭ��*/
        byte[] customBytes= new byte[10000];

        int readLenth=0;
        while ((readLenth=bufferedInputStream.read(customBytes)) != -1) {
            bufferedOutputStream.write(customBytes,0,readLenth);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
       binaryFileCopy(FileName.fileNamePicture1, FileName.fileNameOutPicture1);
        System.out.println("task overed!");
    }
}
