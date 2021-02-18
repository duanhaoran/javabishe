package com.SoulMen.base.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SoulMen on 2020-10-09 登录实体类
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
}
