package experiment3.exp4;

import java.util.Arrays;

public class Vampire6 {
    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {
            //i��ʾ��һ����λ��a
            for (int j = 100; j < 1000; j++) {
                //j��ʾ�ڶ�����λ��b
                int product = i * j;
                //��ó˻�v=ab
                if (product % 100 != 0 && product >= 100000 && product <= 999999) {
                    /*����String���еľ�̬����:public static String valueOf(int i);
                     * �����Ϊint����;����ֵΪString����*/
                    /*������ת��Ϊ�ַ�����Ȼ�����Կո�ָ�Ϊ����(����
                     public String[] split(@NotNull String regex)):(���÷�����)*/
                    String[] value1 = String.valueOf(product).split("");
                    String[] value2 = (String.valueOf(i) + String.valueOf(j)).split("");
                    /*Ϊ�������Ƚ���������,�Ա�Ա�ԭ�����ַ������Ƿ���ȫ��ͬ*/
                    Arrays.sort(value1);
                    Arrays.sort(value2);

                    if (Arrays.equals(value1, value2)) {
                        System.out.println(product + "=" + i + "*" + j);
                        //��ӡ��Ѫ����
                    }
                }
            }
        }
    }

}

