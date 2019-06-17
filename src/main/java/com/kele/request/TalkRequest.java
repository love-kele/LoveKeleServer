package com.kele.request;

import org.springframework.web.multipart.MultipartFile;

public class TalkRequest {

    private String text;

    private byte[] voice;

    private MultipartFile multipartFile;

    private String type = "wav";

    public byte[] getVoice() {
        return voice;
    }

    public void setVoice(byte[] voice) {
        this.voice = voice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {

        return text;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public void setText(String text) {
        this.text = text;
    }
}
