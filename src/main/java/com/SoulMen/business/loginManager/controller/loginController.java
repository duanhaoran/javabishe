package com.SoulMen.business.loginManager.controller;

import com.SoulMen.base.entity.DTO.LoginReq;
import com.SoulMen.base.entity.DTO.RegisterReq;
import com.SoulMen.base.jwt.CommonResult;
import com.SoulMen.business.loginManager.service.loginService;
import com.SoulMen.business.permissionManager.entity.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * 登录接口
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:12
 */
@Api("登录管理")
@RestController
@RequestMapping("/loginController/")
public class loginController {



    @Autowired
    private loginService adminService;
//    CommonResult<User>
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register(@RequestBody RegisterReq registerReq) {
        try {
            Map<String,Object>  Result = adminService.register(registerReq);
            if((Integer)Result.get("Code") ==1){
                return CommonResult.success(Result.get("Code"));
            }else {
                return CommonResult.failed((String)Result.get("Message"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody LoginReq loginReq, BindingResult result)  {
        try {
            Map<String, String> Result = adminService.login(loginReq.getUserName(), loginReq.getPassword());
            return CommonResult.success(Result);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Permission>> getPermissionList(String username) {
        List<Permission> permissionList = adminService.getPermissionList(username);
        return CommonResult.success(permissionList);
    }
}
