package com.kele.speech.response;

import com.kele.context.Status;
import com.kele.enums.BackCode;

public class BaseResponse<T> {
    //处理结果封装类
    private Status status = new Status();

    //处理返回对象
    private T result;

    public BaseResponse() {
        super();
    }

    public BaseResponse(T result) {
        super();
        this.result = result;
    }

    public BaseResponse(int resultCode, String resultDesc) {
        super();
        getStatus().setCode(String.valueOf(resultCode));
        getStatus().setDescription(resultDesc);
    }

    public BaseResponse(BackCode backCode) {
        super();
        getStatus().setCode(String.valueOf(backCode.getIndex()));
        getStatus().setDescription(backCode.getName());
    }

    public BaseResponse(int resultCode, String resultDesc, T result) {
        this(resultCode, resultDesc);
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
