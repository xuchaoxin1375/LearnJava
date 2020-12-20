package study.map;
/*����һ���ַ�����ÿ���ַ����ִ���
������
1. ��ȡһ���ַ�������
2. ����һ��Map���ϣ��������ַ���ֵ�������
3. �����ַ����õ�ÿ���ַ�
4. �ж�Map���Ƿ��иü�
5. ���û�У���һ�γ��֣��洢����Ϊ1������У���˵
���Ѿ����ֹ�����ȡ����Ӧ��ֵ����++���ٴδ洢
6. ��ӡ���ս��*/
import java.util.HashMap;
import java.util.Scanner;
public class MapUseDemo {

    public static void main(String[] args) {
        System.out.println("��¼��һ���ַ���:");
        String line = new Scanner(System.in).nextLine();/*������ַ�����*/
// �����������ͳ��ÿ���ַ����ִ�����(��̬)����
        findChar(line);
    }
    /*��public class�� ����һ����̬����:findChar*/
    private static void findChar(String line) {
//1:����һ��ӳ�伯��map����,�洢�ַ��Լ�����ֵĴ���
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//2:�����ַ���
        /*java.lang.String @Contract(pure = true)
public int length()
Returns the length of this string. The length is equal to the number of Unicode code units in the string.*/
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);//��for�ж���char c;
//�жϸ��ַ��Ƿ��ڼ�����
            if (!map.containsKey(c)) {//˵������ַ�û�г��ֹ�,�Ǿ��ǵ�һ��,��ô�ͽ�����ӵ���ֵ�Լ���map��
                map.put(c, 1);
            } else {
/*//�Ȼ�ȡ֮ǰ�Ĵ���
                Integer count = map.get(c);
                count++;*/
//�������
                map.put(c, map.get(c)+1);
            }
        }
        System.out.println(map);
    }

}
/*
��¼��һ���ַ���:
rwhithiwjroi0q3og-kgofksf
{f=3, g=3, h=3, i=5, j=1, k=3, -=1, o=5, 0=1, q=1, r=3, 3=1, s=1, t=1, w=3}
* */