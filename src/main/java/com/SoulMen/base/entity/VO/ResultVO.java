package com.SoulMen.base.entity.VO;

import com.SoulMen.base.entity.ResultEnum;

/**
 * 返回结果封装
 *   @author SoulMen on 2020-10-09
 */
public class ResultVO<T> {

    private Integer resultCode;
    private String resultMessage;
    private T date;

    public ResultVO() {
    }

    public ResultVO(Integer resultCode, String resultMessage, T date) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
        this.date = date;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public static <T> ResultVO success(T date){
        return new ResultVO<T>(ResultEnum.success.getCode(), ResultEnum.success.getMessage(), date);
    }

    public static <T> ResultVO systemFailed(String message){
        return new ResultVO<T>(ResultEnum.filedOther.getCode(), message, null);
    }

    public static <T> ResultVO failed(){
        return new ResultVO<T>(ResultEnum.filedSQLExecute.getCode(), ResultEnum.filedSQLExecute.getMessage(), null);
    }

}
