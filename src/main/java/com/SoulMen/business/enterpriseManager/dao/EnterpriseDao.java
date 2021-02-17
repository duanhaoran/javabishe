package com.SoulMen.business.enterpriseManager.dao;

import com.SoulMen.business.enterpriseManager.model.Enterprise;
import com.SoulMen.business.enterpriseManager.model.EnterpriseAux;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;



/**
 * (Enterprise)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-14 14:44:32
 */
@Repository
public interface EnterpriseDao extends BaseMapper<Enterprise> {

    /**
     * @param enterprise 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 14:44:32
     */
    @Select("<script>" +
            "select  distinct a.enterprise_id, a.enterprise_name, a.enterprise_stats from enterprise a,industry_enterprise b  " +
            "where a.enterprise_id = b.enterprise_id " +
            "<if test=\"enterprise.enterpriseName !=null and enterprise.enterpriseName   !='' \"> " +
            " and a.enterprise_name = #{enterprise.enterpriseName}  " +
            "</if>" +
            "<if test=\"enterprise.industryId !=null and enterprise.industryId !='' \"> " +
            " and b.industry_id = #{enterprise.industryId}  " +
            "</if>" +
            "</script>"
    )
    List<EnterpriseAux> selectEnterpriseAll(@Param("enterprise") EnterpriseAux enterprise);


    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 14:44:32
     */
    @Delete("<script>" +
            "delete from enterprise where enterprise_id in " +
            "<foreach item = 'item' collection = 'ids' open = '(' close = ')' separator=',' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    Integer deleteEnterpriseSome(@Param("ids") List<Integer> ids);


    /**
     * @param enterprises 添加数据对象s
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 14:44:32
     */
    @Insert("<script>" +
            "insert into enterprise values " +
            "<foreach item = 'item' collection = 'enterprises' separator=',' >" +
            "(#{item.enterpriseId}, #{item.enterpriseName}, #{item.enterpriseStats})" +
            "</foreach>" +
            "</script>")
    Integer insertEnterpriseSome(@Param("enterprises") List<Enterprise> enterprises);


}