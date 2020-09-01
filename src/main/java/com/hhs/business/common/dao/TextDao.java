package com.hhs.business.common.dao;

import com.hhs.business.common.entity.Text;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Text)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-01 10:46:24
 */
public interface TextDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Text queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Text> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param text 实例对象
     * @return 对象列表
     */
    List<Text> queryAll(Text text);

    /**
     * 新增数据
     *
     * @param text 实例对象
     * @return 影响行数
     */
    int insert(Text text);

    /**
     * 修改数据
     *
     * @param text 实例对象
     * @return 影响行数
     */
    int update(Text text);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}