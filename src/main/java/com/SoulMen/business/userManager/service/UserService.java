package com.SoulMen.business.userManager.service;


import com.SoulMen.business.userManager.entity.User;
import com.SoulMen.business.userManager.entity.UserAux;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author hhs
 * @since 2020-09-28 15:59:47
 */
public interface UserService {
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
     public Map<String,Object> selectUserOne(Long id) throws Exception;
     
     /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    public Map<String,Object> selectUserAll(Integer pageNum, Integer pageSize, User user) throws Exception;
    
    /**
     * 添加单条数据
     *
     * @param user 添加数据对象
     * @return 结果标志
     */
    public Map<String,Object> insertUserOne(User user) throws Exception;
    
    /**
     * 删除单条数据
     *
     * @param id 主键
     * @return 结果标志
     */
    public Map<String,Object> deleteUserOne(Long id) throws Exception;
    
    /**
     * 修改单条数据
     *
     * @param user 修改数据对象
     * @return 结果标志
     */
    public Map<String,Object> updateUserOne(User user) throws Exception;

    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
    public Map<String,Object> deleteUserSome(List<Long> ids) throws Exception;
    
    /**
     * 批量添加数据
     *
     * @param users 添加数据对象
     * @return 结果标志
     */
    public Map<String,Object> insertUserSome(List<User> users) throws Exception;

    /**
     * 查询用户性别用于下拉框
     *
     * @return 性别集合
     */
    public List<String> selectSex();


    /**
     *模板导出
     *
     */
    public void Exporttemplatemuban(HttpServletRequest request, HttpServletResponse response);
    /**
     * 数据导出
     */
    public void Exporttemplate(HttpServletRequest request, HttpServletResponse response, User user);

    /**
     *
     * @param MultipartFile 路径
     * @throws IOException
     */
    public void readExcelUser(MultipartFile MultipartFile) throws IOException, NoSuchFieldException;

    public Map<String,Object> selectUserAllAux(Integer pageNum, Integer pageSize, UserAux user) throws Exception;

}