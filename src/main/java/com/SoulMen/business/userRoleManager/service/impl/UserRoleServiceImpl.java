package com.SoulMen.business.userRoleManager.service.impl;

import com.SoulMen.business.userRoleManager.dao.UserRoleDao;
import com.SoulMen.business.userRoleManager.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * (UserRole)表服务实现类
 *
 * @author SoulMen
 * @since 2020-09-01 23:54:14
 */
@Service()
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;
}