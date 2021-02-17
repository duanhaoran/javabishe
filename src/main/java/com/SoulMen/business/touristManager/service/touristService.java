package com.SoulMen.business.touristManager.service;

import com.SoulMen.business.touristManager.model.User;

import java.util.List;
import java.util.Map;



/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2021-02-14 21:04:35
 */
public interface touristService {
    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> selectUserOne(Long id) throws Exception;

    /**
     * @param user 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> selectUserAll(Integer pageNum, Integer pageSize, User user) throws Exception;

    /**
     * @param user 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> insertUserOne(User user) throws Exception;

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> deleteUserOne(Long id) throws Exception;

    /**
     * @param user 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> updateUserOne(User user) throws Exception;

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> deleteUserSome(List<Long> ids) throws Exception;

    /**
     * @param users 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    Map<String, Object> insertUserSome(List<User> users) throws Exception;

}