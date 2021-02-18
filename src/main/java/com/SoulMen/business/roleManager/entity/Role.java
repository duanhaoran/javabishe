package com.SoulMen.business.roleManager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * (Role)实体类
 *
 * @author SoulMen
 * @since 2020-09-26 17:52:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;


}