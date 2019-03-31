package com.kele.enums;

import org.apache.commons.lang3.StringUtils;

public enum BackCode {
    //全局错误类型
    PASS("0", "操作成功"),


    //语音识别错误
    ERROR_PARAMETERS("3300","输入参数不正确"),
    POOR_AUDIO_QUALITY("3301","音频质量过差"),
    SERVER_ERROR("3303","语音服务器后端问题")
    ;

    private String name;
    private String index;

    BackCode(String index, String name) {
        this.index = index;
        this.name = name;
    }

    public static String getName(String index) {
        for (BackCode c : BackCode.values()) {
            if (StringUtils.equals(c.getIndex(), index)) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
