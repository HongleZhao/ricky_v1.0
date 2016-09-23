package com.ricky.base.bean;

import com.ricky.base.emnu.ErrType;

/**
 * 返回结果基础类
 * Created by zhl on 16/9/22.
 */
public class BaseRespVO {
    private  Integer code;
    private String message;

    public BaseRespVO() {

    }

    public BaseRespVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public BaseRespVO(ErrType errType){
        this.code = errType.getErrcode();
        this.message=errType.getErrmsg();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
