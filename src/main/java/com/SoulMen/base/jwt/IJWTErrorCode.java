package com.SoulMen.base.jwt;

/**
 * 封装API的错误码
 * Created by scumbag on 2020/10/9.
 */
public interface IJWTErrorCode {
    long getCode();

    String getMessage();
}
