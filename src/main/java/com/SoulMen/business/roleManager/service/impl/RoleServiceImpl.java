package com.SoulMen.business.roleManager.service.impl;

import com.SoulMen.business.roleManager.dao.RoleDao;
import com.SoulMen.business.roleManager.entity.Role;
import com.SoulMen.business.roleManager.service.RoleService;
import com.SoulMen.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * (Role)表服务实现类
 *
 * @author SoulMen
 * @since 2020-09-26 18:06:15
 */
@Service()
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    private Map<String, Object> checkMap = null;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    public Map<String, Object> selectRoleOne(String id) throws Exception {
        Map<String, Object> checkMap = ResultUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return ResultUtil.getResultMap(roleDao.selectByPrimaryKey(id));
    }

    /**
     * 通过实体类对象多条件查询
     *
     * @param role 查询实体类对象
     * @return 数据集合
     */
    public Map<String, Object> selectRoleAll(Role role) throws Exception {
        return ResultUtil.getResultMap(roleDao.selectRoleAll(role));
    }

    /**
     * 添加单条数据
     *
     * @param role 添加数据对象
     * @return 结果标志
     */
    public Map<String, Object> insertRoleOne(Role role) throws Exception {
        checkMap = ResultUtil.getCheck(role.getRoleId(), "RoleId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = ResultUtil.getCheck(role.getRoleName(), "RoleName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return ResultUtil.getResultCodeMap(roleDao.insert(role));
    }

    /**
     * 删除单条数据
     *
     * @param id 主键
     * @return 结果标志
     */
    public Map<String, Object> deleteRoleOne(String id) throws Exception {
        Map<String, Object> checkMap = ResultUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return ResultUtil.getResultCodeMap(roleDao.deleteByPrimaryKey(id));
    }

    /**
     * 修改单条数据
     *
     * @param role 修改数据对象
     * @return 结果标志
     */
    public Map<String, Object> updateRoleOne(Role role) throws Exception {
        checkMap = ResultUtil.getCheck(role.getRoleId(), "RoleId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }

        checkMap = ResultUtil.getCheck(role.getRoleName(), "RoleName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }

        return ResultUtil.getResultCodeMap(roleDao.updateByPrimaryKey(role));
    }

    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
    public Map<String, Object> deleteRoleSome(List<String> ids) throws Exception {
        Map<String, Object> checkMap = ResultUtil.getCheck(ids, "ids");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return ResultUtil.getResultCodeMap(roleDao.deleteRoleSome(ids));

    }

    /**
     * 批量添加数据
     *
     * @param roles 添加数据对象
     * @return 结果标志
     */
    public Map<String, Object> insertRoleSome(List<Role> roles) throws Exception {
        Map<String, Object> checkMap = ResultUtil.getCheck(roles, "role");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return ResultUtil.getResultCodeMap(roleDao.insertRoleSome(roles));
    }
}