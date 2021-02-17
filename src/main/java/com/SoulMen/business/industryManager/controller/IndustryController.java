package com.SoulMen.business.industryManager.controller;

import com.SoulMen.base.result.ResultVO;
import com.SoulMen.business.industryManager.model.Industry;
import com.SoulMen.business.industryManager.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author makejava
 * @description (Industry)表控制层
 * @since 2021-02-14 18:12:37
 */
@Api(tags = "Industry管理模块")
@RestController
@RequestMapping("industry")
public class IndustryController {
    /**
     * 服务对象
     */
    @Autowired
    IndustryService industryService;

    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectIndustryOne")
    public ResultVO selectIndustryOne(Integer id) {
        try {
            Map<String, Object> Result = industryService.selectIndustryOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param industry 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("通过实体类对象多条件查询")
    @GetMapping("selectIndustryByAny")
    public ResultVO selectIndustryAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, Industry industry) {
        try {
            Map<String, Object> Result = industryService.selectIndustryAll(pageNum, pageSize, industry);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param industry 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("添加单条数据")
    @PostMapping("insertIndustryOne")
    public ResultVO insertIndustryOne(@RequestBody Industry industry) {
        try {
            Map<String, Object> Result = industryService.insertIndustryOne(industry);
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
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("删除单条数据")
    @DeleteMapping("deleteIndustryOne")
    public ResultVO deleteIndustryOne(Integer id) {
        try {
            Map<String, Object> Result = industryService.deleteIndustryOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param industry 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("修改单条数据")
    @PostMapping("updateIndustryOne")
    public ResultVO updateIndustryOne(@RequestBody Industry industry) {
        try {
            Map<String, Object> Result = industryService.updateIndustryOne(industry);
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
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("批量删除数据")
    @DeleteMapping("deleteIndustryByList")
    public ResultVO deleteIndustryOne(@RequestParam(value = "ids", required = false) List<Integer> ids) {
        try {
            Map<String, Object> Result = industryService.deleteIndustrySome(ids);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }

    /**
     * @param industrys 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    @ApiOperation("批量添加数据")
    @PostMapping("insertIndustrySome")
    public ResultVO insertIndustrySome(@RequestParam(value = "ids", required = false) List<Industry> industrys) {
        try {
            Map<String, Object> Result = industryService.insertIndustrySome(industrys);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }
}