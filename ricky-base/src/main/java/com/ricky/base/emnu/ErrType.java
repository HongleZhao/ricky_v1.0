package com.ricky.base.emnu;

/**
 * Created by zhl on 16/9/22.
 */
public enum ErrType{

    SUCCESS(0,"操作成功"),
    REGISTER_FAIL(10000,"注册失败"),
    LOGIN_FAIL(10001,"登录失败"),
    ACCOUNT_EXISTED(10002,"账户已存在"),
    ACCOUNT_NOTEXISTED(10003,"账户不存在"),
    ACCOUNT_LOCKD(10004,"账户已被锁定,请联系管理员"),
    ACCOUNT_LOGIN_LIMIT(10005,"登录尝试失败次数过多,一小时后再试"),

    ILLEGAL_ACCOUNT_PASSWORD(30006,"用户名或密码错误"),
    WRONG_ACCOUNT_PASSWORD(30007,"当前密码不正确"),

    SYSTEM_ERROR(40000,"系统错误"),
    SYS_BUSY(40001,"系统繁忙"),
    SYSTEM_LOW_VERSION(40002,"系统版本过低"),
    UP_IMG_ERR(40003,"上传文件出错"),
    ILLEGAL_REQ_PARAM(40004,"不合法的请求参数");

    Integer errcode;
    String errmsg;

    private ErrType(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }


    public String getErrmsg() {
        return errmsg;
    }

    public Integer getErrcode() {
        return errcode;
    }


    }
