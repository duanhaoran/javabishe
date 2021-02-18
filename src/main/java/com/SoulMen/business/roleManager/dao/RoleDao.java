package com.SoulMen.business.roleManager.dao;

import com.SoulMen.business.roleManager.entity.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author SoulMen
 * @since 2020-09-26 18:08:59
 */
@Repository
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 通过实体类对象多条件查询
     *
     * @param role 查询实体类对象
     * @return 数据集合
     */
    @Select("<script>" +
            "select  role_id, role_name from role " +
            "where 1=1" +
            "<if test=\"role.roleId !=null and role.roleId !='' \"> " +
            " and role_id = #{role.roleId}  " +
            "</if>" +
            "<if test=\"role.roleName !=null and role.roleName !='' \"> " +
            " and role_name = #{role.roleName}  " +
            "</if>" +
            "</script>"
    )
    List<Role> selectRoleAll(@Param("role") Role role);


    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
    @Delete("<script>" +
            "delete from role where String in " +
            "<foreach item = 'item' collection = 'ids' separator=',' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    String deleteRoleSome(List<String> ids);


    /**
     * 批量添加数据
     *
     * @param roles 添加数据对象s
     * @return 结果标志
     */
    @Insert("<script>" +
            "insert into role values " +
            "<foreach item = 'item' collection = 'roles' separator=',' >" +
            "(#{item.roleId}, #{item.roleName})" +
            "</foreach>" +
            "</script>")
    String insertRoleSome(@Param("roles")List<Role> roles);


}