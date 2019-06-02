package com.kele.service.imp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.classification.tokenizers.HanLPTokenizer;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.kele.service.HanLpService;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HanLpServiceImpl implements HanLpService {

    /**
     * 词法分析
     *
     * @param s
     * @return
     */
    public List<Term> LexicalAnalysis(String s) {
        System.out.println("===============>hanLP分词测试");
        HanLP.Config.ShowTermNature=true;
        Segment segment = HanLP.newSegment();

        List<Term> termList = segment.seg(s);

        termList.forEach(seg -> {
            System.out.println(seg.toString());
        });
        return termList;
    }

    @Test
    public void Test(){

        LexicalAnalysis("你好吗？因为它让浏览器本身变得不那么被动");
    }
}
