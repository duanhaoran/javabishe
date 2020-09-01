package com.hhs.business.Login.service.impl;

import com.hhs.business.Login.service.LoginService;
import com.hhs.business.common.dao.UserDao;
import com.hhs.business.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;
    @Override
    public User LoginInfo(User user) {
        List<User> users = userDao.queryAll(user);

        return null;
    }
}
