package com.SoulMen.business.permissionManager.controller;

import com.SoulMen.business.permissionManager.entity.Permission;
import com.SoulMen.business.permissionManager.service.PermissionService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * (Permission)表控制层
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:13
 */
@Api(tags = "permission")
@RestController
@RequestMapping("permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Autowired
    PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permission selectOne(Integer id) {
        return null;
    }

}