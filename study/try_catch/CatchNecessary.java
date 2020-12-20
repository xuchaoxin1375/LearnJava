package study.try_catch;
//������ǲ�����UnsupportedEncodingException������ֱ���ʧ�ܵ����⣺
// try...catch
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CatchNecessary {
    public static void main(String[] args) {
        try {
            byte[] bs = toGBK("����");/* static byte[] toGBK(@NotNull String s) throws UnsupportedEncodingException*/
            System.out.println("try succeed!\n"+Arrays.toString(bs));
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            System.out.println("�ź�tryû�ɹ�.");
            System.out.println(e);
        }
    }
    /*   static byte[] toGBK(String s) {
            return s.getBytes("GBK");
        }
        ����java.lang.String @NotNull
    @Contract(pure = true)
    public byte[] getBytes(@NonNls @NotNull String charsetName) throws java.io.UnsupportedEncodingException
        */
            /*         �������ᱨ��������Ϣ���ƣ�unreported exception UnsupportedEncodingException;
            must be caught or declared to be thrown������׼ȷ��ָ����Ҫ����������return s.getBytes("GBK");��
            ��˼��˵����UnsupportedEncodingException������Checked Exception�����뱻����
                     ������ΪString.getBytes(String)���������ǣ�
            public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
                    ...
                    }*/
    /*toGBK()�������Լ������������throws UnsupportedEncodingExceptionҪ��ķ���,�ڵ��õ�ʱ��������try...catch����(Ԥ�ڿ�������ִ�е���һ����(��������)����try��,�쳣�������catch��*/
    static byte[] toGBK(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");/*public byte[] getBytes(@NonNls @NotNull String charsetName) throws java.io.UnsupportedEncodingException*/
    }
}
/*��Ϊ��main()�����У�����toGBK()��û�в����������Ŀ����׳���UnsupportedEncodingException��
�޸���������main()�����в����쳣������*/

/*�� ���������ʱ��ʹ��throws Xxx��ʾ�÷��������׳����쳣���͡�
��Ӧ��,�ڵ������ִ�throws�ķ�����ʱ�򣬱���ǿ�Ʋ�����Щ�쳣������������ᱨ��*/

/*�ɼ���ֻҪ�Ƿ���������Checked Exception�����ڵ��ò㲶��
Ҳ�����ڸ��ߵĵ��ò㲶������δ������쳣������Ҳ������main()�����в��񣬲������©дtry������������ɱ�������֤�ġ�main()����Ҳ����󲶻�Exception�Ļ��ᡣ
    �������д�κ�try���룬����ֱ�Ӱ�main()��������Ϊthrows Exception��
    ��Ϊmain()���������˿����׳�Exception��Ҳ�������˿����׳����е�Exception��������ڲ������貶���ˡ�
    ���۾���һ�������쳣������������˳���*/