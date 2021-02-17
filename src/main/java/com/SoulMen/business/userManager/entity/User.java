package com.SoulMen.business.userManager.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * (User)实体类
 *
 * @author hhs
 * @since 2020-09-28 15:59:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id
    /**
    * 用户ID
    */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    /**
    * 用户名称
    */
    private String userName;
    /**
    * 用户密码
    */
    private String password;
    /**
    * 角色
    */
    private String roleId;
    /**
    * 用户年龄
    */
    private String userAge;
    /**
    * 用户性别
    */
    private String userSex;
    /**
    * 帐号启用状态：0->禁用；1->启用
    */
    private String status;


}