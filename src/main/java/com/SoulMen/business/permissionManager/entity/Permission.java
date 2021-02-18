package com.SoulMen.business.permissionManager.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Id;
/**
 * (Permission)实体类
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission  implements GrantedAuthority {
    @Id
    /**
    * 权限ID
    */
    private String permissionId;
    /**
    * 权限名称
    */
    private String permissionName;
    /**
    * 权限编码
    */
    private String permissionCode;


    @Override
    public String getAuthority() {
        return permissionCode;
    }
}