package experiment9.exp2;

/*����JavaԴ���ļ���My.java����һ���ļ�����My2.java��Ҫ��My2.javaɾ��My.java������ע�ͣ�������ȫ��ͬ��
//ע��Javaע�������֣�һ�����磺/*����*/
//��һ������ //����.
//*/

import experiment9.FileName;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class RegularExpression {
    /*�����������������ǹ��������ǶԽڵ����İ�װ(Ҳ����˵,�������ڽڵ���,��Ҫ����FileReader/FileInputStream����װʹ��.һ����˵,�Ƽ�ʹ��BufferedIO�������ļ��ȽϺ�(��ֱ�ӵ���ʹ��FileIO���ķ���͸�Ч���� */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(FileName.fileName3, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(FileName.fileNameOut2/*,StandardCharsets.UTF_8*/));//ֵ��ע�����,�ڽ�����д����ʱ��,�Ƿ�Ĭ��(һ������Ϊgbk,����Ҫ��Ϊutf-8����),����,���԰�ĩβnull����ӡ��ʾ����,������һ��ļ��±��������������������(��������ַ�������)
        String string=null;

        char [] chars=new char[1000];
        StringBuffer stringBuffer=new StringBuffer();
        while(bufferedReader.read(chars)!=-1){
            stringBuffer.append(chars);
        }
        string=stringBuffer.toString();
        string=string.replaceAll("//", "").replaceAll("/\\*|\\*/","");

        //System.out.println(string);
        bufferedWriter.write(string);
        /*����������������ʧ��*/
//       while( (string=bufferedReader.readLine())!=null){
//                string=string.replaceAll("//", "").replaceAll("/\\*|\\*/","");
//                                //ֵ��ע���ʱ,������ǿ������ת��һ��,����replaceAll����������ַ��������ᷢ���ı�,��ʮ�൱�ڴ���Դ�ַ�����һ������,�����ش�����ĸ���.
//           //  ����û��\*��һ�ַ�,�����㻹��Ҫ��\\���\,Ȼ���ڼ�*,��\\*,��Ŵ���regex�е���ͨ�ַ���\*,��\*��һ��������Ϊ'*'����ͨ�ַ�����Ԫ�ַ�.
//                bufferedWriter.write(string+"\n");
//           System.out.println(string);
//       }


        bufferedWriter.flush();  //step2:ˢ�»�����
        //step3:�ͷ���Դ:
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("�������.");
           /*
A String containing the contents of the line, not including any line-termination characters,
 or null if the end of the stream has been reached without reading any characters*/

    }
}