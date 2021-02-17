package com.SoulMen.business.touristManager.dao;

import com.SoulMen.business.touristManager.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2021-02-14 21:04:35
 */
@Repository
public interface TouristDao extends BaseMapper<User> {

    /**
     * @param user 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    @Select("<script>" +
            "select  USER_ID, USER_NAME, PASSWORD, ROLE_ID, USER_AGE, USER_SEX, STATUS, USER_NUM, user_department_id from user a  " +
            "where 1=1" +
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
            "<if test=\"user.userNum !=null and user.userNum !='' \"> " +
            " and user_num = #{user.userNum}  " +
            "</if>" +
            "<if test=\"user.userDepartmentId !=null and user.userDepartmentId !='' \"> " +
            " and user_department_id = #{user.userDepartmentId}  " +
            "</if>" +
            "</script>"
    )
    List<User> selectUserAll(@Param("user") User user);


    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    @Delete("<script>" +
            "delete from user where user_id in " +
            "<foreach item = 'item' collection = 'ids' open = '(' close = ')' separator=',' >" +
            "#{item}" +
            "</foreach>" +
            "</script>")
    Long deleteUserSome(@Param("ids") List<Long> ids);


    /**
     * @param users 添加数据对象s
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 21:04:35
     */
    @Insert("<script>" +
            "insert into user values " +
            "<foreach item = 'item' collection = 'users' separator=',' >" +
            "(#{item.userId}, #{item.userName}, #{item.password}, #{item.roleId}, #{item.userAge}, #{item.userSex}, #{item.status}, #{item.userNum}, #{item.userDepartmentId})" +
            "</foreach>" +
            "</script>")
    Long insertUserSome(@Param("users") List<User> users);


}