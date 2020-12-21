package experiment6.exp4;

import namesAndStrings.FileName;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo2 {
    public static void main(String[] args) throws IOException {
//1.����FileInputStream����,���췽���а�Ҫ��ȡ������Դ
        FileInputStream fis = new FileInputStream(FileName.fileName8_1);
//2.ʹ��FileInputStream�����еķ���read,��ȡ�ļ�
//int read()��ȡ�ļ��е�һ���ֽڲ����أ�����ȡ���ļ���ĩβʱ����-1
        byte[] bytes = new byte[1024]; //�洢��ȡ���Ķ���ֽ�
        int len = 0; //��¼��ȡ�����ֽ�
        while ((len = fis.read(bytes)) != -1) {
            /*every time we specify a len to operate,we can void null to be write.*/
            System.out.print(new String(bytes, 0, len));
            /*String(byte[] bytes, int offset, int length):���ֽ������һ����ת��Ϊ�ַ���
             */
        }

//3.�ͷ���Դ
        fis.close();

    }

}