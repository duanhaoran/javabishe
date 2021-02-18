package com.SoulMen.business.roleManager.controller;

import com.SoulMen.base.entity.VO.ResultVO;
import com.SoulMen.business.roleManager.entity.Role;
import com.SoulMen.business.roleManager.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * (Role)表控制层
 *
 * @author SoulMen
 * @since 2020-09-26 17:52:44
 */
@Api(tags = "role")
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Autowired
    RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectRoleOne")
    public ResultVO selectRoleOne(String id) {
        try {
            Map<String, Object> Result = roleService.selectRoleOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * 通过实体类对象多条件查询
     *
     * @param role 查询实体类对象
     * @return 数据集合
     */
    @ApiOperation("通过实体类对象多条件查询")
    @GetMapping("selectRoleByAny")
    public ResultVO selectRoleAll(Role role) {
        try {
            Map<String, Object> Result = roleService.selectRoleAll(role);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * 添加单条数据
     *
     * @param role 添加数据对象
     * @return 结果标志
     */
    @ApiOperation("添加单条数据")
    @PostMapping("insertRoleOne")
    public ResultVO insertRoleOne(Role role) {
        try {
            Map<String, Object> Result = roleService.insertRoleOne(role);
            return ResultVO.success(Result.get("data"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * 删除单条数据
     *
     * @param id 主键
     * @return 结果标志
     */
    @ApiOperation("删除单条数据")
    @DeleteMapping("deleteRoleOne")
    public ResultVO deleteRoleOne(String id) {
        try {
            Map<String, Object> Result = roleService.deleteRoleOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * 修改单条数据
     *
     * @param role 修改数据对象
     * @return 结果标志
     */
    @ApiOperation("修改单条数据")
    @PostMapping("updateRoleOne")
    public ResultVO updateRoleOne(Role role) {
        try {
            Map<String, Object> Result = roleService.updateRoleOne(role);
            return ResultVO.success(Result.get("data"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
    @ApiOperation("批量删除数据")
    @DeleteMapping("deleteRoleByList")
    public ResultVO deleteRoleOne(List<String> ids) {
        try {
            Map<String, Object> Result = roleService.deleteRoleSome(ids);
            return ResultVO.success(Result.get("data"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * 批量添加数据
     *
     * @param roles 添加数据对象
     * @return 结果标志
     */
    @ApiOperation("批量添加数据")
    @PostMapping("insertRoleSome")
    public ResultVO insertRoleSome(List<Role> roles) {
        try {
            Map<String, Object> Result = roleService.insertRoleSome(roles);

            return ResultVO.success(Result.get("data"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }
}