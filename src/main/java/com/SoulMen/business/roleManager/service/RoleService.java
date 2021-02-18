package com.SoulMen.business.roleManager.service;

import com.SoulMen.business.roleManager.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * (Role)表服务接口
 *
 * @author SoulMen
 * @since 2020-09-26 17:52:43
 */
public interface RoleService {
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    Map<String, Object> selectRoleOne(String id) throws Exception;

    /**
     * 通过实体类对象多条件查询
     *
     * @param role 查询实体类对象
     * @return 数据集合
     */
    Map<String, Object> selectRoleAll(Role role) throws Exception;

    /**
     * 添加单条数据
     *
     * @param role 添加数据对象
     * @return 结果标志
     */
    Map<String, Object> insertRoleOne(Role role) throws Exception;

    /**
     * 删除单条数据
     *
     * @param id 主键
     * @return 结果标志
     */
    Map<String, Object> deleteRoleOne(String id) throws Exception;

    /**
     * 修改单条数据
     *
     * @param role 修改数据对象
     * @return 结果标志
     */
    Map<String, Object> updateRoleOne(Role role) throws Exception;

    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
    Map<String, Object> deleteRoleSome(List<String> ids) throws Exception;

    /**
     * 批量添加数据
     *
     * @param roles 添加数据对象
     * @return 结果标志
     */
    Map<String, Object> insertRoleSome(List<Role> roles) throws Exception;

}