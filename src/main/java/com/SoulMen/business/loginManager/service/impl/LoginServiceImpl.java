package com.SoulMen.business.loginManager.service.impl;

import com.SoulMen.base.entity.DTO.RegisterReq;
import com.SoulMen.base.jwt.jwtTokenUtil;
import com.SoulMen.business.loginManager.service.loginService;
import com.SoulMen.business.permissionManager.dao.PermissionDao;
import com.SoulMen.business.permissionManager.entity.Permission;
import com.SoulMen.business.userManager.dao.UserDao;
import com.SoulMen.business.userManager.entity.User;
import com.SoulMen.business.userRoleManager.dao.UserRoleDao;
import com.SoulMen.business.userRoleManager.entity.UserRole;
import com.SoulMen.utils.SnowflakeIdUtil;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UmsAdminService实现类
 *
 * @author SoulMen
 * @since 2020-09-01 23:09:13
 */
@Service
@Log4j2
public class LoginServiceImpl implements loginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private jwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${user.pwd}")
    private String pwd;
    @Autowired
    UserDao userDao;
    @Autowired
    private PermissionDao PermissionDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public User getAdminByUsername(String username) {
        User selUser = new User();
        selUser.setUserName(username);
        User adminList = userDao.selectOne(selUser);
        if (adminList != null) {
            return adminList;
        }
        return null;
    }

    @Override
    public Map<String,Object>  register( RegisterReq registerReq) throws Exception{
        Map<String,Object> Result = new HashMap<>();
        //创建注册用户实体类
        User user = new User();
        //校验用户名称是否重复
        user.setUserName(registerReq.getUserName());
        if (userDao.selectOne(user) != null) {
            Result.put("Code",0);
            Result.put("Message","register is false by useranme is same!");
            throw new Exception("register is false by useranme is same!");
        }
        //雪花算法  分布式自增数据类型ID
        SnowflakeIdUtil snowflakeIdUtil = new SnowflakeIdUtil(0,0);
        //封装
        user.setUserId(snowflakeIdUtil.nextId());
        user.setUserAge(registerReq.getUserAge());
        user.setUserSex(registerReq.getUserSex());
        //默认为 不禁用
        user.setStatus("1");
        //默认角色为会员
        user.setRoleId("3");
        //若密码为空则使用默认密码
        if(registerReq.getPassword()==null||registerReq.getPassword().equals("string")){
            log.info("register user with default password!");
            user.setPassword(pwd);
        }else {
            log.info("register user with normal password!");
            user.setPassword(registerReq.getPassword());
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        Integer insertResult =userDao.insert(user);
        Result.put("Code",insertResult);
        if(insertResult==1){
            log.info("register is success!");
            Result.put("Message","register is success!");
            UserRole userRole =new UserRole();
            userRole.setRoleId(user.getRoleId());
            userRole.setUserId(user.getUserId());
            userRoleDao.insert(userRole);
        }else {
            Result.put("Message","register is false!");
        }

        return Result;
    }

    @Override
    public  Map<String, String> login (String username, String password) throws Exception{
        Map<String, String> tokenMap = new HashMap<>();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails==null||userDetails.getUsername()==""){
            log.info("login is field by username is not exist!");
            throw new Exception("login is field by username is not exist!");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            log.info("login is field by password is incorrect!");
            throw new Exception("login is field by password is incorrect!");
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(userDetails);
        if (token == null) {
            tokenMap.put("Message","false");
            throw new Exception("login is false by token is null!");
        }else {
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);
            tokenMap.put("AllToken", tokenHead+" "+token);
            log.info("login is success!");
        }
        return tokenMap;
    }


    @Override
    public List<Permission> getPermissionList(String username) {
        return PermissionDao.listPermissions(username);
    }
}
