package experiment8.testHanlp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //System.out.println(HanLP.segment("��ã���ӭʹ��HanLP���ﴦ�����"));
        String[] testCase = new String[]{
                "ǩԼ��ʽǰ���ع��١���ͺ㡢��͵�һͬ����˲μ�ǩԼ����ҵ�ҡ�",
                "����ǿ���߷塢�����ų�������ͷ��������С��",
                "�źƺͺ�������Ա�ؼ���",
                "���ܺ�С�������",
                "����۾��ֺͻ�����˵",
                "�����й�������й��¼�",
                "��ѧƽ���쵼,��ӱ����ǰ",
        };
        Segment segment = HanLP.newSegment().enableNameRecognize(true);
        for (String sentence : testCase)
        {
            List<Term> termList = segment.seg(sentence);
            System.out.println(termList);
        }
    }
}
