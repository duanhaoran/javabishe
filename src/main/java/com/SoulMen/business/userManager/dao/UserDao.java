package com.SoulMen.business.userManager.dao;


import com.SoulMen.business.userManager.entity.User;
import com.SoulMen.business.userManager.entity.UserAux;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * (User)表数据库访问层
 *

 * @author hhs
 * @since 2020-09-28 15:59:47
 */
 @Repository
public interface UserDao extends BaseMapper<User> {

    /**
     * 查询用户性别用于下拉框
     *
     * @return 性别集合
     */
     @Select("select distinct user_sex from user")
     List<String> selectSex();


    /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    @Select("<script>"+
            "select  user_id, user_name, password, role_id, user_age, user_sex, status from user  "  +
            "where 1=1"+
            "<if test=\"user.userId !=null and user.userId !='' \"> " +
            " and user_id = #{user.userId}  " +
            "</if>" +
            "<if test=\"user.userName !=null and user.userName !='' \"> " +
            " and user_name = #{user.userName}  " +
            "</if>" +
            "<if test=\"user.password !=null and user.password !='' \"> " +
            " and password = #{user.password}  " +
            "</if>" +
            "<if test=\"user.roleId !=null and user.roleId !='' \"> " +
            " and role_id = #{user.roleId}  " +
            "</if>" +
            "<if test=\"user.userAge !=null and user.userAge !='' \"> " +
            " and user_age = #{user.userAge}  " +
            "</if>" +
            "<if test=\"user.userSex !=null and user.userSex !='' \"> " +
            " and user_sex = #{user.userSex}  " +
            "</if>" +
            "<if test=\"user.status !=null and user.status !='' \"> " +
            " and status = #{user.status}  " +
            "</if>" +
            "<if test=\"user.userDepartmentId !=null and user.userDepartmentId !='' \"> " +
            " and user_department_id = #{user.userDepartmentId}  " +
            "</if>" +
            "</script>"
    )
    List<User> selectUserAllAux(@Param("user") UserAux user);

    /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    @Select("<script>"+
    "select  user_id, user_name, password, role_id, user_age, user_sex, status from user  "  +
    "where 1=1"+
        "<if test=\"user.userId !=null and user.userId !='' \"> " +
    " and user_id = #{user.userId}  " +
    "</if>" +
        "<if test=\"user.userName !=null and user.userName !='' \"> " +
    " and user_name = #{user.userName}  " +
    "</if>" +
        "<if test=\"user.password !=null and user.password !='' \"> " +
    " and password = #{user.password}  " +
    "</if>" +
        "<if test=\"user.roleId !=null and user.roleId !='' \"> " +
    " and role_id = #{user.roleId}  " +
    "</if>" +
        "<if test=\"user.userAge !=null and user.userAge !='' \"> " +
    " and user_age = #{user.userAge}  " +
    "</if>" +
        "<if test=\"user.userSex !=null and user.userSex !='' \"> " +
    " and user_sex = #{user.userSex}  " +
    "</if>" +
        "<if test=\"user.status !=null and user.status !='' \"> " +
    " and status = #{user.status}  " +
    "</if>" +
        "</script>"
    )
    List<User> selectUserAll(@Param("user") User user);


    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
     @Delete("<script>" +
             "delete from user where user_id in " +
             "<foreach item = 'item' collection = 'ids' open = '(' close = ')' separator=',' >" +
             "#{item}" +
             "</foreach>" +
             "</script>")
    Integer deleteUserSome(@Param("ids") List<Long> ids);


    /**
     * 批量添加数据
     *
     * @param users 添加数据对象s
     * @return 结果标志
     */
    @Insert("<script>" +
            "insert into user values " +
            "<foreach item = 'item' collection = 'users' separator=',' >" +
             "(#{item.userId}, #{item.userName}, #{item.password}, #{item.roleId}, #{item.userAge}, #{item.userSex}, #{item.status})" +
            "</foreach>" +
            "</script>")
    Long insertUserSome(@Param("users") List<User> users);

}