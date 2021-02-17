package com.SoulMen.business.userManager.service.impl;

import com.SoulMen.business.userManager.dao.UserDao;
import com.SoulMen.business.userManager.entity.User;
import com.SoulMen.business.userManager.entity.UserAux;
import com.SoulMen.business.userManager.service.UserService;
import com.SoulMen.utils.PageUtils;
import com.SoulMen.utils.PoiUtil;
import com.SoulMen.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author hhs
 * @since 2020-09-28 15:59:47
 */
@Service()
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    
    private Map<String, Object> checkMap = null;
     /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    public Map<String,Object> selectUserOne(Long id) throws Exception{
        Map<String,Object> checkMap = ResultUtil.getCheck(id,"id");
        if ((Integer) checkMap.get("Code") == 3) {
        return checkMap;
        }
        return ResultUtil.getResultMap(userDao.selectByPrimaryKey(id));
    }
    
    /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    public Map<String,Object> selectUserAll(Integer pageNum,Integer pageSize,User user) throws Exception{
        PageUtils pageUtils=new PageUtils();
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        pageUtils.setDataList(userDao.selectUserAll(user));
        return ResultUtil.getResultMap(pageUtils.paging());

    }

    /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    public Map<String,Object> selectUserAllAux(Integer pageNum, Integer pageSize, UserAux user) throws Exception{
        PageUtils pageUtils=new PageUtils();
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        pageUtils.setDataList(userDao.selectUserAllAux(user));
        return ResultUtil.getResultMap(pageUtils.paging());

    }
    /**
     * 添加单条数据
     *
     * @param user 添加数据对象
     * @return 结果标志
     */
    public Map<String,Object> insertUserOne(User user) throws Exception{
        checkMap = ResultUtil.getCheck(user.getUserId(),"UserId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = ResultUtil.getCheck(user.getUserName(),"UserName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }   
                checkMap = ResultUtil.getCheck(user.getPassword(),"Password");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }   
                checkMap = ResultUtil.getCheck(user.getRoleId(),"RoleId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }   
                checkMap = ResultUtil.getCheck(user.getUserAge(),"UserAge");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }   
                checkMap = ResultUtil.getCheck(user.getUserSex(),"UserSex");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }   
                checkMap = ResultUtil.getCheck(user.getStatus(),"Status");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }   
                return ResultUtil.getResultCodeMap(userDao.insert(user));
     }
    
    /**
     * 删除单条数据
     *
     * @param id 主键
     * @return 结果标志
     */
    public Map<String,Object> deleteUserOne(Long id) throws Exception {
       Map<String,Object> checkMap = ResultUtil.getCheck(id,"id");
        if ((Integer) checkMap.get("Code") == 3) {
        return checkMap;
        }
        return ResultUtil.getResultCodeMap(userDao.deleteByPrimaryKey(id));
    }
    
    /**
     * 修改单条数据
     *
     * @param user 修改数据对象
     * @return 结果标志
     */
    public Map<String,Object> updateUserOne(User user) throws Exception {
        checkMap = ResultUtil.getCheck(user.getUserId(),"UserId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
         checkMap = ResultUtil.getCheck(user.getUserName(),"UserName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
         checkMap = ResultUtil.getCheck(user.getPassword(),"Password");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
         checkMap = ResultUtil.getCheck(user.getRoleId(),"RoleId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
         checkMap = ResultUtil.getCheck(user.getUserAge(),"UserAge");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
         checkMap = ResultUtil.getCheck(user.getUserSex(),"UserSex");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
         checkMap = ResultUtil.getCheck(user.getStatus(),"Status");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        
             return ResultUtil.getResultCodeMap(userDao.updateByPrimaryKey(user));
    }

    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
    public Map<String,Object> deleteUserSome(List<Long> ids) throws Exception {
       Map<String,Object> checkMap = ResultUtil.getCheck(ids,"ids");
        if ((Integer) checkMap.get("Code") == 3) {
        return checkMap;
        }
        return ResultUtil.getResultCodeMap(userDao.deleteUserSome(ids));

    }
    
    /**
     * 批量添加数据
     *
     * @param users 添加数据对象
     * @return 结果标志
     */
    public Map<String,Object> insertUserSome(List<User> users) throws Exception {
        Map<String,Object> checkMap = ResultUtil.getCheck(users,"user");
        if ((Integer) checkMap.get("Code") == 3) {
        return checkMap;
        }
        return ResultUtil.getResultCodeMap(userDao.insertUserSome(users));
    }

    /**
     * 查询下拉框
     * @return 返回结果
     */
    public List<String> selectSex() {
        return userDao.selectSex();
    }


    /**
     * 模板导出
     */
    public void Exporttemplatemuban(HttpServletRequest request, HttpServletResponse response){
        List<User> user=new ArrayList<>();
        String[] columnNames={"userId","userName","roleId","userAge","userSex","status"};
        String[] keyList={"用户ID","用户名称","角色","用户年龄","用户性别","帐号启用状态：0->禁用；1->启用"};
        String filename="muban.xls";
        PoiUtil.downLoadExcel(columnNames,keyList,user,filename,response);
    }
    /**
     * 数据导出
     */
    public void Exporttemplate(HttpServletRequest request, HttpServletResponse response,User user){
        List<User> roleAll=userDao.selectUserAll(user);
        String[] columnNames={"userId","userName","roleId","userAge","userSex","status"};
        String[] keyList={"用户ID","用户名称","角色","用户年龄","用户性别","帐号启用状态：0->禁用；1->启用"};
        String filename="shuju.xls";
        PoiUtil.downLoadExcel(columnNames,keyList,roleAll,filename,response);
    }

    /**
     *
     * @param MultipartFile 路径
     * @throws IOException
     */
    public void readExcelUser(MultipartFile MultipartFile) throws IOException, NoSuchFieldException {
        String[] columnNames={"userId","userName","password","roleId","userAge","userSex","status"};
        List<User> a= PoiUtil.readExcel(MultipartFile,columnNames,User.class);
        userDao.insertUserSome(a);
    }
}