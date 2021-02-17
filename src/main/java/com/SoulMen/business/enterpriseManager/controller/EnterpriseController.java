package com.SoulMen.business.enterpriseManager.controller;

import com.SoulMen.base.entity.VO.ResultVO;
import com.SoulMen.business.enterpriseManager.model.Enterprise;
import com.SoulMen.business.enterpriseManager.model.EnterpriseAux;
import com.SoulMen.business.enterpriseManager.service.EnterpriseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



/**
 * @author makejava
 * @description (Enterprise)表控制层
 * @since 2021-02-14 14:44:34
 */
@Api(tags = "Enterprise管理模块")
@RestController
@RequestMapping("enterprise")
public class EnterpriseController {
    /**
     * 服务对象
     */
    @Autowired
    EnterpriseService enterpriseService;

    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectEnterpriseOne")
    public ResultVO selectEnterpriseOne(Integer id) {
        try {
            Map<String, Object> Result = enterpriseService.selectEnterpriseOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param enterprise 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("通过实体类对象多条件查询")
    @GetMapping("selectEnterpriseByAny")
    public ResultVO selectEnterpriseAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, EnterpriseAux enterprise) {
        try {
            Map<String, Object> Result = enterpriseService.selectEnterpriseAll(pageNum, pageSize, enterprise);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param enterprise 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("添加单条数据")
    @PostMapping("insertEnterpriseOne")
    public ResultVO insertEnterpriseOne(@RequestBody Enterprise enterprise) {
        try {
            Map<String, Object> Result = enterpriseService.insertEnterpriseOne(enterprise);
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
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("删除单条数据")
    @DeleteMapping("deleteEnterpriseOne")
    public ResultVO deleteEnterpriseOne(Integer id) {
        try {
            Map<String, Object> Result = enterpriseService.deleteEnterpriseOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param enterprise 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("修改单条数据")
    @PostMapping("updateEnterpriseOne")
    public ResultVO updateEnterpriseOne(@RequestBody Enterprise enterprise) {
        try {
            Map<String, Object> Result = enterpriseService.updateEnterpriseOne(enterprise);
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
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("批量删除数据")
    @DeleteMapping("deleteEnterpriseByList")
    public ResultVO deleteEnterpriseOne(@RequestParam(value = "ids", required = false) List<Integer> ids) {
        try {
            Map<String, Object> Result = enterpriseService.deleteEnterpriseSome(ids);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param enterprises 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    @ApiOperation("批量添加数据")
    @PostMapping("insertEnterpriseSome")
    public ResultVO insertEnterpriseSome(@RequestParam(value = "ids", required = false) List<Enterprise> enterprises) {
        try {
            Map<String, Object> Result = enterpriseService.insertEnterpriseSome(enterprises);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }
}