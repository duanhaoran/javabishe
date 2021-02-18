package com.SoulMen.business.loginManager.service;

import com.SoulMen.base.entity.DTO.RegisterReq;
import com.SoulMen.business.permissionManager.entity.Permission;
import com.SoulMen.business.userManager.entity.User;

import java.util.List;
import java.util.Map;
/**
 * 后台管理员Service
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:13
 */

public interface loginService {
    /**
     * 根据用户名获取后台管理员
     */
    User getAdminByUsername(String username);

    /**
     * 注册功能
     */
    Map<String,Object> register(RegisterReq registerReq)throws Exception;

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    Map<String, String> login(String username, String password)throws Exception;

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<Permission> getPermissionList(String username);
}
