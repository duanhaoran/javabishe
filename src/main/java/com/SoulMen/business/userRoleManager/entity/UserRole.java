package com.SoulMen.business.userRoleManager.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
/**
 * (UserRole)实体类
 *
 * @author SoulMen
 * @since 2020-09-01 23:54:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole  {
    @Id
    /**
    * 用户角色ID
    */
    private Integer userRoleId;
    /**
    * 用户ID 对应user表
    */
    private Long userId;
    /**
    * 角色ID 对应角色表
    */
    private String roleId;


}