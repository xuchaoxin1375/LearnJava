package experiment9.exp1;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.model.crf.CRFLexicalAnalyzer;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.io.IOException;
import java.util.List;

/**
 * CRF�ִ�(������ѵ����δѹ��100MBģ���£��ܹ�ȡ�ýϺõ�Ч��������Ͷ����������)
 *
 * @author hankcs
 */
public class DemoCRFSegment
{
    public static void main(String[] args) throws IOException {
        HanLP.Config.ShowTermNature = false;    // �رմ�����ʾ
        Segment segment = new CRFLexicalAnalyzer();
        String[] sentenceArray = new String[]
                {
                        "uid\tmid\ttime\tforward_count\tcomment_count\tlike_count\tcontent\n" ,
                                "d38e9bed5d98110dc2489d0d1cac3c2a\t7d45833d9865727a88b960b0603c19f6\t2015-02-23 17:41:29\t0\t0\t0\t��������(sz002033)#��Ʊ##����##�ƾ�##���##Ͷ��#�Ƽ���Ӯ�ɣ�ӯ���԰�ֳɣ����㱾��Ⱥ��46251412\n" ,
                        "HanLP����һϵ��ģ�����㷨��ɵ�Java���߰���Ŀ�����ռ���Ȼ���Դ��������������е�Ӧ�á�",
                        "�F�U��ꠑ�ŭ��w���Y �RӢ�Ÿ����ܔ�",           // ������ѹ��
                        "�RӢ�Żؑ��B���ġ�ؤ���f�����Q�h��ͬ־ՄԒ��֔��",
                        "������أ�ǿ���������Ϻ�ɫ���壬������ˮ�����Ҵ�������ԭ����������������ˮ����������������Ư�׼����������ռ���������̼���Ƽ��ȡ�", // רҵ������һ����ʶ����
                        "��ҹ������ӡ�ͨ������ǳ�ݵ���Ů�ڰ�ҹ�������ӵ��龰,���������߶����������������",    // ����������
                        "����������[ί��]ǰ���Ǹ����̫�����ˣ�һ�㲻��Ʒ...@hankcs",                       // ΢��
                        "��̩���С��һ��ζ��Ҳû��...ÿ����������...�����ģ�����ʳ��2A�ĺô�",
                        "����˹���ȡ����޶�˵�������Ҳ��ǻ��衣��ȫ�Ҷ��Ȱ����֣���Ҳ����������ô����",
                        "����APPS��Sago Mini Toolbox�������Ӷ�������",
                        "���������������������ι���ͳ�ƾֵ������",
                        "2.34������Ȣ1.53��Ů��˿ �Ʒ�������û����",
                        "�㿴���º�������",
                        "���ӳ����ֻ��ܷ���ؼֲ�˹����̬��"
                };
        for (String sentence : sentenceArray)
        {
            List<Term> termList = segment.seg(sentence);
           /* for(Term x:termList){
                if(x.nature!= Nature.)
            }*/
            System.out.println(termList);
        }
    }
}