package study.try_catch;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TryCatch {
    public static void main(String[] args) {
        byte[] bs = toGBK("����");
  /*Object�൱�а����ķ�����11������Ҫѧϰ���е�2����
- public String toString()�����ظö�����ַ�����ʾ��
- public boolean equals(Object obj)��ָʾ����ĳ����
���Ƿ���˶�����ȡ���*/
        System.out.println(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) {
        /*�ڷ�����Ƕ��try..catch���Ʋ�׽�쳣;*/
        try {
            // ��ָ������ת��StringΪbyte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // ���ϵͳ��֧��GBK���룬�Ჶ��UnsupportedEncodingException:
            System.out.println(e); // ��ӡ�쳣��Ϣ
            /*�ı䴦��ʽ�ڳ���*/
            return s.getBytes(); // ����ʹ����Ĭ�ϱ���
        }
    }
}

