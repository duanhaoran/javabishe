package com.SoulMen.business.touristManager.service.impl;

import com.SoulMen.base.result.CheckUtil;
import com.SoulMen.base.result.PageUtils;
import com.SoulMen.business.touristManager.dao.TouristDao;
import com.SoulMen.business.touristManager.model.User;
import com.SoulMen.business.touristManager.service.touristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



/**
 * @author makejava
 * @description 用户表(User)表服务实现类
 * @since 2021-02-14 21:04:36
 */
@Service()
public class TouristServiceImpl implements touristService {
    @Autowired
    TouristDao touristDao;

    private Map<String, Object> checkMap = null;

    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> selectUserOne(Long id) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultMap(touristDao.selectByPrimaryKey(id));
    }

    /**
     * @param user 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> selectUserAll(Integer pageNum, Integer pageSize, User user) throws Exception {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        pageUtils.setDataList(touristDao.selectUserAll(user));
        return CheckUtil.getResultMap(pageUtils.paging());
    }

    /**
     * @param user 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> insertUserOne(User user) throws Exception {
        checkMap = CheckUtil.getCheck(user.getUserId(), "UserId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserName(), "UserName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getPassword(), "Password");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getRoleId(), "RoleId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserAge(), "UserAge");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserSex(), "UserSex");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getStatus(), "Status");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserNum(), "UserNum");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserDepartmentId(), "UserDepartmentId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(touristDao.insert(user));
    }

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> deleteUserOne(Long id) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(touristDao.deleteByPrimaryKey(id));
    }

    /**
     * @param user 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> updateUserOne(User user) throws Exception {
        checkMap = CheckUtil.getCheck(user.getUserId(), "UserId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserName(), "UserName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getPassword(), "Password");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getRoleId(), "RoleId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserAge(), "UserAge");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserSex(), "UserSex");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getStatus(), "Status");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserNum(), "UserNum");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(user.getUserDepartmentId(), "UserDepartmentId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(touristDao.updateByPrimaryKey(user));
    }

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> deleteUserSome(List<Long> ids) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(ids, "ids");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(touristDao.deleteUserSome(ids));

    }

    /**
     * @param users 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 21:04:36
     */
    public Map<String, Object> insertUserSome(List<User> users) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(users, "user");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(touristDao.insertUserSome(users));
    }
}