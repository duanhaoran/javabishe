package com.SoulMen.business.userRoleManager.controller;

import com.SoulMen.business.userRoleManager.entity.UserRole;
import com.SoulMen.business.userRoleManager.service.UserRoleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (UserRole)表控制层
 *
 * @author SoulMen
 * @since 2020-09-01 23:54:14
 */
@Api(tags = "userRole")
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Autowired
    UserRoleService userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserRole selectOne(Integer id) {
        return null;
    }

}