package com.SoulMen.business.industryManager.service;

import com.SoulMen.business.industryManager.model.Industry;

import java.util.List;
import java.util.Map;


/**
 * (Industry)表服务接口
 *
 * @author makejava
 * @since 2021-02-14 18:12:36
 */
public interface IndustryService {
    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> selectIndustryOne(Integer id) throws Exception;

    /**
     * @param industry 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> selectIndustryAll(Integer pageNum, Integer pageSize, Industry industry) throws Exception;

    /**
     * @param industry 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> insertIndustryOne(Industry industry) throws Exception;

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> deleteIndustryOne(Integer id) throws Exception;

    /**
     * @param industry 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> updateIndustryOne(Industry industry) throws Exception;

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> deleteIndustrySome(List<Integer> ids) throws Exception;

    /**
     * @param industrys 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 18:12:36
     */
    Map<String, Object> insertIndustrySome(List<Industry> industrys) throws Exception;

}