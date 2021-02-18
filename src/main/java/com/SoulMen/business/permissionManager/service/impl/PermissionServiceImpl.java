package com.SoulMen.business.permissionManager.service.impl;

import com.SoulMen.business.permissionManager.dao.PermissionDao;
import com.SoulMen.business.permissionManager.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * (Permission)表服务实现类
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:13
 */
@Service()
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
}