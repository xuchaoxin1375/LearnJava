package experiment9.StudyRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudyRead {

    public static void main(String[] args) {
       String fileName = "D:\\OneDrive\\Java\\ProjectCodeInIDEA\\experiment_doc\\dataExperiment9\\ReadText.txt";
        String fileNameAnother = "D:\\OneDrive\\Java\\ProjectCodeInIDEA\\experiment_doc\\dataExperiment8\\��������(�޹���).txt";
        //D:\OneDrive\Java\ProjectCodeInIDEA\experiment_doc\dataExperiment8\��������(�޹���).txt
        try {
            FileInputStream inputStream = new FileInputStream(fileName);//�׳��쳣1
            byte[] bytes = new byte[1024]; //�洢��ȡ���Ķ���ֽ�
            int len = 0; //��¼��ȡ�����ֽ���,�Ա�������� String(bytes, 0, len)ת�����ַ���;
            while ((len = inputStream.read(bytes)) != -1) {//��������read��Ե��,��Ҫ�׳��쳣2,��ô�������catch����һ��catch�ĺ���.
//String(byte[] bytes, int offset, int length):���ֽ������һ����ת��Ϊ�ַ���
// �ַ���offset:����Ŀ�ʼ����
                System.out.print(new String(bytes, 0, len));//��bytes�еĵ�0���ַ���ʼ�����ܶ���len���ַ�,����֮ת��λ�ַ���.(Ȼ��,�ֽ����ڶ����ı�ʱ(����ʱ�����ı���ʱ��,���ײ���Ī���ķ���(��ʹָ������ȷ�ı���Ҳ���ɴ�����,�����ʵ�����ʱ��Reader�������������ı��Ķ���)
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
