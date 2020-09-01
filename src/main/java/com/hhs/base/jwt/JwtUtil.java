package com.hhs.base.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JwtUtil {

    //加密密钥
    private static final String SIGN = "!QUEEN#JASDH";

    /**
     * 生成Token header。payload。sing
     *
     * @author hhs
     * @since 2020-08-30 15:03:39
     * */
    public  String JWTUtilInstall(Map<String,String> mapParam){
        //头部
        Map<String,Object> map =new HashMap<>();
        //有效日期
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_WEEK,1);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //参数赋值
        mapParam.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //有效期赋值 加密密钥赋值 生成Token
        String Token = builder.withExpiresAt(instance.getTime())
                        .sign(Algorithm.HMAC256(SIGN));
        return Token;
    }
    public  String JWTUtilInstall(String userid,String username ){
        //头部
        Map<String,Object> map =new HashMap<>();
        //有效日期
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_WEEK,1);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //参数赋值
        builder.withClaim("userid",userid);
        builder.withClaim("username",username);
        //有效期赋值 加密密钥赋值 生成Token
        String Token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGN));
        return Token;
    }
    /**
     * 验证Token
     *
     * @author hhs
     * @since 2020-08-30 15:03:39
     * */
    public void verify(String Token){
         JWT.require(Algorithm.HMAC256(SIGN)).build().verify(Token);
    }
    /**
     * 获取Token信息
     *
     * @author hhs
     * @since 2020-08-30 15:03:39
     * */
    public  DecodedJWT JWTUtilGet(String Token){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SIGN)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(Token);
//        map.put("userId",decodedJWT.getClaims().get("userId").asInt());
//        map.put("username",decodedJWT.getClaims().get("username").asString());
        return decodedJWT;
    }




}
