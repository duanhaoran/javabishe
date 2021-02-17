package com.SoulMen.business.userManager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserAux extends User {
    /**
     * 所属部门，且用于区分游客
     */
    private Integer userDepartmentId;
}
