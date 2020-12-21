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
 * CRF分词(在最新训练的未压缩100MB模型下，能够取得较好的效果，可以投入生产环境)
 *
 * @author hankcs
 */
public class DemoCRFSegment
{
    public static void main(String[] args) throws IOException {
        HanLP.Config.ShowTermNature = false;    // 关闭词性显示
        Segment segment = new CRFLexicalAnalyzer();
        String[] sentenceArray = new String[]
                {
                        "uid\tmid\ttime\tforward_count\tcomment_count\tlike_count\tcontent\n" ,
                                "d38e9bed5d98110dc2489d0d1cac3c2a\t7d45833d9865727a88b960b0603c19f6\t2015-02-23 17:41:29\t0\t0\t0\t丽江旅游(sz002033)#股票##炒股##财经##理财##投资#推荐包赢股，盈利对半分成，不算本金，群：46251412\n" ,
                        "HanLP是由一系列模型与算法组成的Java工具包，目标是普及自然语言处理在生产环境中的应用。",
                        "鐵桿部隊憤怒情緒集結 馬英九腹背受敵",           // 繁体无压力
                        "馬英九回應連勝文“丐幫說”：稱黨內同志談話應謹慎",
                        "高锰酸钾，强氧化剂，紫红色晶体，可溶于水，遇乙醇即被还原。常用作消毒剂、水净化剂、氧化剂、漂白剂、毒气吸收剂、二氧化碳精制剂等。", // 专业名词有一定辨识能力
                        "《夜晚的骰子》通过描述浅草的舞女在暗夜中扔骰子的情景,寄托了作者对庶民生活区的情感",    // 非新闻语料
                        "这个像是真的[委屈]前面那个打扮太江户了，一点不上品...@hankcs",                       // 微博
                        "鼎泰丰的小笼一点味道也没有...每样都淡淡的...淡淡的，哪有食堂2A的好次",
                        "克里斯蒂娜·克罗尔说：不，我不是虎妈。我全家都热爱音乐，我也鼓励他们这么做。",
                        "今日APPS：Sago Mini Toolbox培养孩子动手能力",
                        "财政部副部长王保安调任国家统计局党组书记",
                        "2.34米男子娶1.53米女粉丝 称夫妻生活没问题",
                        "你看过穆赫兰道吗",
                        "乐视超级手机能否承载贾布斯的生态梦"
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