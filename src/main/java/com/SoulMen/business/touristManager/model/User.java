package com.SoulMen.business.touristManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2021-02-14 21:04:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    /**
     * 用户ID
     */
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
     * 角色Id
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
     * 帐号启用状态:0->禁用；1->启用
     */
    private String status;

    private String userNum;
    /**
     * 所属部门id
     */
    private String userDepartmentId;


}