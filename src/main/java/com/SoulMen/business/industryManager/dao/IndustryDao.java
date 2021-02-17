package com.SoulMen.business.industryManager.dao;

import com.SoulMen.business.industryManager.model.Industry;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


/**
 * (Industry)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-14 18:12:35
 */
@Repository
public interface IndustryDao extends BaseMapper<Industry> {

    /**
     * @param industry 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 18:12:35
     */
    @Select("<script>" +
            "select  industry_id, industry_name, industry_administrative_department from industry a  " +
            "where 1=1" +
            "<if test=\"industry.industryId !=null and industry.industryId !='' \"> " +
            " and industry_id = #{industry.industryId}  " +
            "</if>" +
            "<if test=\"industry.industryName !=null and industry.industryName !='' \"> " +
            " and industry_name = #{industry.industryName}  " +
            "</if>" +
            "<if test=\"industry.industryAdministrativeDepartment !=null and industry.industryAdministrativeDepartment !='' \"> " +
            " and industry_administrative_department = #{industry.industryAdministrativeDepartment}  " +
            "</if>" +
            "</script>"
    )
    List<Industry> selectIndustryAll(@Param("industry") Industry industry);


    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 18:12:35
     */
    @Delete("<script>" +
            "delete from industry where industry_id in " +
            "<foreach item = 'item' collection = 'ids' open = '(' close = ')' separator=',' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    Integer deleteIndustrySome(@Param("ids") List<Integer> ids);


    /**
     * @param industrys 添加数据对象s
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 18:12:35
     */
    @Insert("<script>" +
            "insert into industry values " +
            "<foreach item = 'item' collection = 'industrys' separator=',' >" +
            "(#{item.industryId}, #{item.industryName}, #{item.industryAdministrativeDepartment})" +
            "</foreach>" +
            "</script>")
    Integer insertIndustrySome(@Param("industrys") List<Industry> industrys);


}