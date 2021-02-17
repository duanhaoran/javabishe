package com.SoulMen.business.enterpriseManager.service;

import com.SoulMen.business.enterpriseManager.model.Enterprise;
import com.SoulMen.business.enterpriseManager.model.EnterpriseAux;

import java.util.List;
import java.util.Map;


/**
 * (Enterprise)表服务接口
 *
 * @author makejava
 * @since 2021-02-14 14:44:33
 */
public interface EnterpriseService {
    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> selectEnterpriseOne(Integer id) throws Exception;

    /**
     * @param enterprise 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> selectEnterpriseAll(Integer pageNum, Integer pageSize, EnterpriseAux enterprise) throws Exception;

    /**
     * @param enterprise 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> insertEnterpriseOne(Enterprise enterprise) throws Exception;

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> deleteEnterpriseOne(Integer id) throws Exception;

    /**
     * @param enterprise 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> updateEnterpriseOne(Enterprise enterprise) throws Exception;

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> deleteEnterpriseSome(List<Integer> ids) throws Exception;

    /**
     * @param enterprises 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 14:44:33
     */
    Map<String, Object> insertEnterpriseSome(List<Enterprise> enterprises) throws Exception;

}