package study.collection;

public class ArrayAndFor {

    public static void main(String[] args) {
        String[] str = new String[5];
        /*�õ�����(��ǿ���for()���޷��޸Ķ�Ӧ�ļ��ϵ�Ԫ�ص�,����str��������Ȼû������;*/
        for (String myStr : str) {
            myStr = "�ú�ѧϰ����������";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
/*

* �ú�ѧϰ����������
�ú�ѧϰ����������
�ú�ѧϰ����������
�ú�ѧϰ����������
�ú�ѧϰ����������
null
null
null
null
null*/