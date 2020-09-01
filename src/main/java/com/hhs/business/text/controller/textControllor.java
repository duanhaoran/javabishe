package com.hhs.business.text.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.hhs.business.text.dao.aa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "测试")
@RestController
@RequestMapping("/text")
public class textControllor {

    @Autowired
   private aa da;

    @Autowired
    com.hhs.base.jwt.JwtUtil jwtText;

    @ApiOperation(value = "JWT_Token生成")
    @PostMapping("/install")
    public String install( @RequestBody Map<String,String> map){
        return jwtText.JWTUtilInstall(map);
    }
    @ApiOperation(value = "JWT_Token验证")
    @GetMapping("/yz")
    public void yz(String Token){
        jwtText.verify(Token);
    }
    @ApiOperation(value = "JWT_Token解密")
    @GetMapping("/get")
    public Map<String, Object> get(String Token){
        DecodedJWT decodedJWT = jwtText.JWTUtilGet(Token);
        Map<String, Object> map = new HashMap<>();
        map.put("userId",decodedJWT.getClaims().get("userId").asString());
        map.put("username",decodedJWT.getClaims().get("username").asString());
        return map;
    }
}
