package experiment9.StudyRead;

import experiment9.FileName;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudyRead2 {
    public static void main(String[] args) {

        try {
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(FileName.fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int len;
            while (((len = inputStream.read()) != -1)) {
                //System.out.print((char) len);//����������ı�(Ӣ������)
                System.out.println((byte)len);//���һЩASCII��
            }
            /*Reads the next byte of data from the input stream. The value byte is returned as an int in the range 0 to 255. If no byte is available because the end of the stream has been reached, the value -1 is returned.
             * �ɼ�,.read()�޲η����ķ���ֵ�ĺ����read(Byte[])�ĺ����ǲ�ͬ��.*/
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int len = 0; //��¼��ȡ�����ֽ�


        System.out.print((char) len);
    }
}

