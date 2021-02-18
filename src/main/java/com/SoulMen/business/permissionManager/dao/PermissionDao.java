package com.SoulMen.business.permissionManager.dao;

import com.SoulMen.business.permissionManager.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Permission)表数据库访问层
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:11
 */
 @Repository
public interface PermissionDao extends BaseMapper<Permission>{
@Select("<script>" +
        "SELECT p.permission_code\n" +
        "FROM user u,user_role ru, role_permission rp , permission p\n" +
        " WHERE u.user_id = ru.user_id  and ru.role_id = rp.role_id  and  rp.permission_id = p.permission_id and u.user_name = #{userName}" +
        "</script>")
 List<Permission> listPermissions(@Param("userName") String userName);
        }