package com.kele.context;

import com.kele.enums.BackCode;

public class Status {
    //处理状态 默认成功
    private String code = String.valueOf(BackCode.PASS.getIndex());

    //处理说明 默认成功
    private String description = BackCode.PASS.getName();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return "Status{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
