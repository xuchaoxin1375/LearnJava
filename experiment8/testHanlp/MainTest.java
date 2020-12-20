/*
package experiment8.testHanlp;
import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.suggest.Suggester;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("�״α�������ʱ��HanLP���Զ������ʵ仺�棬���Ժ򡭡�\n");
        //��һ�����л����ļ��Ҳ����Ĵ��󵫲�Ӱ�����У�������ɺ�Ͳ���������
        System.out.println("��׼�ִʣ�");
        System.out.println(HanLP.segment("��ã���ӭʹ��HanLP��"));
        System.out.println("\n");

        List<Term> termList = NLPTokenizer.segment("�й���ѧԺ���㼼���о������ڳ���������ڽ�����Ȼ���Դ���γ�");
        System.out.println("NLP�ִʣ�");
        System.out.println(termList);
        System.out.println("\n");

        System.out.println("�����Ƽ���");
        getSegement();
        System.out.println("\n");

        System.out.println("�ؼ�����ȡ��");
        getMainIdea();
        System.out.println("\n");

        System.out.println("�Զ�ժҪ��");
        getZhaiYao();
        System.out.println("\n");

        System.out.println("������ȡ��");
        getDuanYu();
        System.out.println("\n");
    }

    */
/**
     * �����Ƽ�����
     *//*

    public static void getSegement() {
        Suggester suggester = new Suggester();
        String[] titleArray = ("�������ӷ�����˵ ��������Ұ������\n" + "��ʱ�����������������Χ������¯ �վ�������ѡ\n" + "���ڸ�ȡ���ɨ�ƣ�����ȡ�����ࡱ���鼰����ɢ\n"
                + "�ձ����ܷ�����ʽ��Ч ��ýָ���𺦹���֪��Ȩ\n" + "Ӣ����˵������Ⱦ��������������Σ����").split("\\n");
        for (String title : titleArray) {
            suggester.addSentence(title);
        }
        System.out.println(suggester.suggest("����", 1)); // ����
        System.out.println(suggester.suggest("Σ������", 1)); // �ַ�
        System.out.println(suggester.suggest("mayun", 1)); // ƴ��
    }

    */
/**
     * �ؼ�����ȡ
     *//*

    public static void getMainIdea() {
        String content = "����Ա(Ӣ��Programmer)�Ǵ��³��򿪷���ά����רҵ��Ա��һ�㽫����Ա��Ϊ���������Ա�ͳ��������Ա�������ߵĽ��޲����ǳ�������ر������й��������ҵ��Ա��Ϊ��������Ա���߼�����Ա��ϵͳ����Ա����Ŀ�����Ĵ��ࡣ";
        List<String> keywordList = HanLP.extractKeyword(content, 5);
        System.out.println(keywordList);
    }

    */
/**
     * �Զ�ժҪ
     *//*

    public static void getZhaiYao() {
        String document = "�㷨�ɴ��·�Ϊ�����㷨�����ݽṹ���㷨�������㷨�����㼸�ε��㷨��ͼ���㷨����̬�滮�Լ���ֵ�����������㷨�������㷨�������㷨��������㷨�������㷨�����ױ���ģ�͡����ɭ���㷨��\n"
                + "�㷨���Կ��ķ�Ϊ���࣬\n" + "һ�����޵�ȷ�����㷨�������㷨�����޵�һ��ʱ������ֹ�����ǿ���Ҫ���ܳ�ʱ����ִ��ָ�������񣬵��Խ���һ����ʱ������ֹ�������㷨�ó��Ľ����ȡ��������ֵ��\n"
                + "�������޵ķ�ȷ���㷨�������㷨�����޵�ʱ������ֹ��Ȼ��������һ������һЩ����������ֵ���㷨�Ľ��������Ψһ�Ļ�ȷ���ġ�\n"
                + "�������޵��㷨������Щ����û�ж�����ֹ��������������������޷���������������������ֹ���е��㷨��ͨ���������㷨�Ĳ���������δ��ȷ���Ķ�����ֹ������";
        List<String> sentenceList = HanLP.extractSummary(document, 3);
        System.out.println(sentenceList);
    }

    */
/**
     * ������ȡ
     *//*

    public static void getDuanYu() {
        String text = "�㷨����ʦ\n"
                + "�㷨��Algorithm����һϵ�н�����������ָ�Ҳ����˵���ܹ���һ���淶�����룬������ʱ���ڻ����Ҫ�����������һ���㷨��ȱ�ݣ����ʺ���ĳ�����⣬ִ������㷨��������������⡣��ͬ���㷨�����ò�ͬ��ʱ�䡢�ռ��Ч�������ͬ��������һ���㷨�����ӿ����ÿռ临�Ӷ���ʱ�临�Ӷ����������㷨����ʦ���������㷨����������ˡ�\n"
                + "\n" + "1ְλ���\n" + "�㷨����ʦ��һ���ǳ��߶˵�ְλ��\n" + "רҵҪ�󣺼���������ӡ�ͨ�š���ѧ�����רҵ��\n"
                + "ѧ��Ҫ�󣺱��Ƽ������ϵ�ѧ�����������˶ʿѧ���������ϣ�\n" + "����Ҫ��Ӣ��Ҫ�������������������Ķ�����רҵ�鿯��\n"
                + "�������ռ�������֪ʶ������ʹ�÷��湤��MATLAB�ȣ������һ�ű�����ԡ�\n" + "\n" + "2�о�����\n"
                + "��Ƶ�㷨����ʦ��ͼ�����㷨����ʦ����Ƶ�㷨����ʦ ͨ�Ż����㷨����ʦ\n" + "\n" + "3Ŀǰ������״��\n"
                + "Ŀǰ���ڴ����㷨�о��Ĺ���ʦ���٣����Ǹ߼��㷨����ʦȴ���٣���һ���ǳ���ȱ��רҵ����ʦ���㷨����ʦ�����о�����������Ҫ����Ƶ/��Ƶ�㷨����ͼ��������Ķ�ά��Ϣ�㷨�����ͨ������㡢�״��źŴ�������ҽѧ�źŴ���������һά��Ϣ�㷨����\n"
                + "�ڼ��������Ƶ��ͼ��ͼ�����ȶ�ά��Ϣ�㷨������Ŀǰ�Ƚ��Ƚ�����Ƶ�����㷨�������Ӿ���Ϊ�����㷨�о��ĺ��ģ����⻹��2Dת3D�㷨(2D-to-3D conversion)��ȥ�����㷨(de-interlacing)���˶������˶������㷨(Motion estimation/Motion Compensation)��ȥ���㷨(Noise Reduction)�������㷨(scaling)���񻯴����㷨(Sharpness)�����ֱ����㷨(Super Resolution),����ʶ��(gesture recognition),����ʶ��(face recognition)��\n"
                + "��ͨ��������һά��Ϣ����Ŀǰ���õ��㷨�����������RRM��RTT����������ĵ��ƽ�����ŵ����⡢�źż�⡢�����Ż����źŷֽ�ȡ�\n" + "���������ھ򡢻����������㷨Ҳ��Ϊ��������ŷ���\n"
                + "�㷨����ʦ�����˹����ܷ���չ��";
        List<String> phraseList = HanLP.extractPhrase(text, 10);
        System.out.println(phraseList);
    }
}
*/
