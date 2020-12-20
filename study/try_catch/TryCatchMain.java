package study.try_catch;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class TryCatchMain {
    /*�������д�κ�try���룬����ֱ�Ӱ�main()��������Ϊthrows Exception}{������д����ͷ}��
     * ������try..catch���ƴ���:
     * ��Ϊmain()���������˿����׳�Exception��Ҳ�������˿����׳����е�Exception��
     * ������ڲ������貶���ˡ����۾���һ�������쳣������������˳���*/
    public static void main(String[] args) throws Exception {
        byte[] bs = toGBK("����");
        System.out.println(Arrays.toString(bs));
        byte[] bs2=toGBK2("����");
        System.out.println(Arrays.toString(bs2));
    }

    /*����һ��Ҫ�󲶻��쳣�ķ���:*/
    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        // ��ָ������ת��StringΪbyte[]:
        return s.getBytes("GBK");
    }
    /*����һ���ڷ����ڲ���¼�쳣�ķ���*/
    //����󲻴���ķ�ʽ�Ƿǳ����õģ���ʹ���ʲôҲ�����ˣ�ҲҪ�Ȱ��쳣��¼������
    static byte[] toGBK2(String s) {
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // �ȼ�������˵:
            e.printStackTrace();//�����쳣�����Ե���printStackTrace()������ӡ�쳣ջ������һ�������õĿ��ٴ�ӡ�쳣�ķ�����
        }
        return null;
    }

}
