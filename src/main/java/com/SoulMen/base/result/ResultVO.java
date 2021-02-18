package com.SoulMen.base.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果封装
 *   @author SoulMen on 2020-10-09
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultVO<T> {

    private Integer resultCode;
    private String resultMessage;
    private T date;

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
