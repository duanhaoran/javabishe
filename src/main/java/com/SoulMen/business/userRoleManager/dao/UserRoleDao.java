package com.SoulMen.business.userRoleManager.dao;

import com.SoulMen.business.userRoleManager.entity.UserRole;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
/**
 * (UserRole)表数据库访问层
 *
 * @author SoulMen
 * @since 2020-09-01 23:54:14
 */
 @Repository
public interface UserRoleDao extends BaseMapper<UserRole>{

}