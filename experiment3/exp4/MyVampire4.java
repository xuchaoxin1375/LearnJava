package experiment3.exp4;
/*
*��Ѫ��������ָλ��Ϊż�������֣�������һ��������˶��õ���
* ������λ���ֱ�������˻����������֣�˳������������򣩣�(�ܹ���100���������ǲ������
* */

/*
* ��ȫ����ö��(�ݹ�ö��)�Ļ��ǱȽϸ��ӵ�,����������Ĳ�������������,����ͨ����һ�ַ�ʽ:������ʵ��ö��
*   ͨ��ö��������λ��������λ�������,��Ѫ��������������һ��������Щ�������,
*
*  ����,�Ƚ������������ַ���ɵ������е��ַ����༰����Ӧ����Ŀ�Ƿ�һ��,�����Ƚ������е��ַ�����,Ȼ��������ԱȽϼ���;��ɱ���ȫ����ö�ٱȽ����е������Ҫ���õĶ�(���ټ��˲���)
* ���͵��㷨:��ĸ����(����)����:https://blog.csdn.net/xuchaoxin1375/article/details/108568225
* */
import java.util.Arrays;
public class MyVampire4 {

    public static void main(String[] args) {
        for (int i = 10; i <100; i++) {
            //i��ʾ��һ����λ��a
            for (int j = 10; j < 100; j++) {
                //j��ʾ�ڶ�����λ��b
                int product=i*j;
                //��ó˻�v=ab
                if(product%100!=0&&product>999&&product<10000) {
                    /*����String���еľ�̬����:public static String valueOf(int i);
                    * �����Ϊint����;����ֵΪString����*/
                    /*������ת��Ϊ�ַ�����Ȼ�����Կո�ָ�Ϊ����(����
                     public String[] split(@NotNull String regex)):(���÷�����)*/
                    String[] value1=String.valueOf(product).split("");
                    String[] value2=(String.valueOf(i)+String.valueOf(j)).split("");
                    /*Ϊ�������Ƚ���������,�Ա�Ա�ԭ�����ַ������Ƿ���ȫ��ͬ*/
                    Arrays.sort(value1);
                    Arrays.sort(value2);

                    if (Arrays.equals(value1, value2)) {
                        System.out.println(product+"="+i+"*"+j);
                        //��ӡ��Ѫ����
                    }
                }
            }
        }
    }

}
