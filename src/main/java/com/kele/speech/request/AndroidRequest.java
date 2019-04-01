package com.kele.speech.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传语音文件请求体
 */
public class AndroidRequest {

    private MultipartFile multipartFile;

    private int lang_type=1;


    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public int getLang_type() {
        return lang_type;
    }

    public void setLang_type(int lang_type) {
        this.lang_type = lang_type;
    }
}
