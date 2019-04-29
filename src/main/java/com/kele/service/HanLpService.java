package com.kele.service;

import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * HanLP词法分析服务
 */
public interface HanLpService {

    /**
     * 词法分析
     * @param s
     * @return
     */
    List<Term>  LexicalAnalysis(String s);
}
