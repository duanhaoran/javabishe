package com.SoulMen.base.result;

/**
 * @author SoulMen on 2020-10-09
 * */
public enum ResultEnum {
    success(1,"执行成功！"),
    nullResult(2,"SQL无数据"),
    filedSQLExecute(-1,"SQL执行失败"),
    filedOther(0,"发生预料外的错误"),
    nullParameter(3,"输入参数异常！值为空！"),
    ;

    private Integer code;
    private String message;

    ResultEnum (Integer code,String message) {
        this.code = code;
        this.message = message;
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
