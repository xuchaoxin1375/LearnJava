package study.equals;

import java.util.ArrayList;
import java.util.List;

public class equal1 {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        /*contains()����
        * ���Ǵ������new String("C")������һ���ǲ�ͬ��ʵ����
        * �����Ȼ����Ԥ�ڣ�����Ϊʲô�أ���ΪList�ڲ�������ͨ��==�ж�����Ԫ���Ƿ����(�����Ļ��ǱȽ�����ʵ���ĵ�ַ)
        * ������ʹ��equals()�����ж�(�Ƚϵ���ʵ��������)����Ԫ���Ƿ���ȣ�*/
        System.out.println(list.contains(new String("C"))); // true
        System.out.println(list.indexOf(new String("C"))); // 2
        ArrayList sc=new ArrayList();/*ArrayList ��һ��������*/
    }
}
