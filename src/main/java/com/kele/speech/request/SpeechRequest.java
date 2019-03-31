package com.kele.speech.request;

import sun.audio.AudioData;


public class SpeechRequest {
    //语音文件 二进制 语音文件的格式，pcm 或者 wav 或者 amr。不区分大小写
    private byte[] data;

    /**
     * 1:普通话(默认)(支持简单的英文识别)	2:普通话(纯中文识别)
     * 3:英语                           4:粤语
     * 5:四川话	                        6:普通话远场
     */
    private int lang_type=1;

    private String format; //文件类型

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getLang_type() {
        return lang_type;
    }

    public void setLang_type(int lang_type) {
        this.lang_type = lang_type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
