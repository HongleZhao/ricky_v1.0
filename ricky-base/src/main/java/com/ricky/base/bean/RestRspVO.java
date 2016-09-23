package com.ricky.base.bean;

import com.ricky.base.emnu.ErrType;

/**
 * Rest返回结果封装类
 * Created by zhl on 16/9/22.
 */
public class RestRspVO<T> extends BaseRespVO {

    private T result;

    public RestRspVO() {
    }

    public RestRspVO(int code, String message) {
        super(code, message);
    }

    public RestRspVO(int code, String message, T result) {
        super(code, message);
        this.result = result;
    }

    public RestRspVO(ErrType errType, T record){
        super(errType);
        this.result = record;
    }

    public RestRspVO(ErrType errType){
        super(errType);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RestRspVO{" +
                "result=" + result +
                '}';
    }
}
