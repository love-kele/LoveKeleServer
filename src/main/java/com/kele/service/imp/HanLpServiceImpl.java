package com.kele.service.imp;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.classification.tokenizers.HanLPTokenizer;
import com.hankcs.hanlp.seg.common.Term;
import com.kele.service.HanLpService;
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
        List<Term> segment = HanLP.segment(s);
        segment.forEach(seg -> {
            System.out.println(seg.toString());
        });
        return segment;
    }
}
