package experiment5.exp3;

import java.util.*;

/*�Ӽ�������һ��������ַ������磺aaabbababaaaababababa����ͳ�Ƹ��ַ����г���Ϊi���Ӵ����ִ�����i��1��ʼ�������ַ������Ƚ���������ʾ����ʹ��HashMapʵ�֡�*/
public class SubString {
    public static void main(String[] args) {

        String line = new Scanner(System.in).nextLine();
        /*�Զ�ȡһ������,������������Scanner��������ȡ����,��ֱ�ӽ����ݷ��ظ�line�ַ���*/
        /*�����ͳ�ƴ����ľ�̬����*/
        count(line);

    }

    private static void count(String line) {
        Map<String, Integer> map = new HashMap<>();
        String tmp;
        //System.out.println("ö�������Ӵ�:(�����ظ����ֵ�)");
        /*�ο�:https://blog.csdn.net/xuchaoxin1375/article/details/109545953*/
        for (int i = 0; i < line.length(); i++) {
            for (int j = i + 1; j <= line.length(); j++) {
                if (!map.containsKey(tmp = line.substring(i, j))) {
                    map.put(tmp, 1);
                } else {
                    map.put(tmp, map.get(tmp) + 1);/*//����map.get(tmp)++,��Ϊ�����������ֵ�������,Ҳ�ǲ���Ҫ��,
                    ͨ��+1��������������ʽ�Ѿ��㹻,����Ҫ�ø�ֵ��.*/
                }
            }
        }
        //System.out.println(map);
        Set<String> set = map.keySet();
        for (String x : set) {
            System.out.println(x + "=" + map.get(x));
        }
    }
}

