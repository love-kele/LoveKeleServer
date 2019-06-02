package com.kele.respone;

import java.util.Arrays;

public class BaiduSdkResponse {
    //错误码
    private Integer err_no;
    //错误码描述
    private String err_msg;
    //语音数据唯一标识，系统内部产生，用于 debug
    private String sn;

    private String corpus_no;
    //识别结果数组，提供1-5 个候选结果，string 类型为识别的字符串， utf-8 编码
    private String result[];

    public Integer getErr_no() {
        return err_no;
    }

    public void setErr_no(Integer err_no) {
        this.err_no = err_no;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCorpus_no() {
        return corpus_no;
    }

    public void setCorpus_no(String corpus_no) {
        this.corpus_no = corpus_no;
    }

    public String[] getResult() {
        return result;
    }

    public void setResult(String[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaiduSdkResponse{" +
                "err_no=" + err_no +
                ", err_msg='" + err_msg + '\'' +
                ", sn='" + sn + '\'' +
                ", corpus_no='" + corpus_no + '\'' +
                ", result=" + Arrays.toString(result) +
                '}';
    }
}
