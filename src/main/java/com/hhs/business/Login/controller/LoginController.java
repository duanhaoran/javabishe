package com.hhs.business.Login.controller;

import com.hhs.business.Login.service.LoginService;
import com.hhs.business.common.entity.User;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录")
@RestController
@RequestMapping("Login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("LoginInfo")
    public User LoginInfo(User user){
        return null;
    }


}
