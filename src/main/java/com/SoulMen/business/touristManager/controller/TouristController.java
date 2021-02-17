package com.SoulMen.business.touristManager.controller;

import com.SoulMen.base.result.ResultVO;
import com.SoulMen.business.touristManager.model.User;
import com.SoulMen.business.touristManager.service.touristService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author makejava
 * @description 用户表(User)表控制层
 * @since 2021-02-14 21:04:36
 */
@Api(tags = "User管理模块")
@RestController
@RequestMapping("tourist")
public class TouristController {
    /**
     * 服务对象
     */
    @Autowired
    touristService touristService;

    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectUserOne")
    public ResultVO selectUserOne(Long id) {
        try {
            Map<String, Object> Result = touristService.selectUserOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param user 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("通过实体类对象多条件查询")
    @GetMapping("selectUserByAny")
    public ResultVO selectUserAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, User user) {
        try {
            Map<String, Object> Result = touristService.selectUserAll(pageNum, pageSize, user);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param user 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("添加单条数据")
    @PostMapping("insertUserOne")
    public ResultVO insertUserOne(@RequestBody User user) {
        try {
            Map<String, Object> Result = touristService.insertUserOne(user);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("删除单条数据")
    @DeleteMapping("deleteUserOne")
    public ResultVO deleteUserOne(Long id) {
        try {
            Map<String, Object> Result = touristService.deleteUserOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param user 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("修改单条数据")
    @PostMapping("updateUserOne")
    public ResultVO updateUserOne(@RequestBody User user) {
        try {
            Map<String, Object> Result = touristService.updateUserOne(user);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("批量删除数据")
    @DeleteMapping("deleteUserByList")
    public ResultVO deleteUserOne(@RequestParam(value = "ids", required = false) List<Long> ids) {
        try {
            Map<String, Object> Result = touristService.deleteUserSome(ids);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param users 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    @ApiOperation("批量添加数据")
    @PostMapping("insertUserSome")
    public ResultVO insertUserSome(@RequestParam(value = "ids", required = false) List<User> users) {
        try {
            Map<String, Object> Result = touristService.insertUserSome(users);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }
}