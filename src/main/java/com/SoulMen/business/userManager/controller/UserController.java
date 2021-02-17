package com.SoulMen.business.userManager.controller;

import com.SoulMen.base.entity.VO.ResultVO;
import com.SoulMen.business.userManager.entity.User;
import com.SoulMen.business.userManager.entity.UserAux;
import com.SoulMen.business.userManager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author hhs
 * @since 2020-09-28 15:59:47
 */
@Api(tags = "user")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectUserOne")
    public ResultVO selectUserOne(Long id) {
    try{
       Map<String,Object> Result = userService.selectUserOne(id);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
        }
    }
    
    /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    @ApiOperation("通过实体类对象多条件查询")
    @GetMapping("selectUserByAny")
    public ResultVO selectUserAll(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, User user){
     try{
       Map<String,Object> Result = userService.selectUserAll(pageNum,pageSize,user);
             return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
        }           
     }
    /**
     * 通过实体类对象多条件查询
     *
     * @param user 查询实体类对象
     * @return 数据集合
     */
    @ApiOperation("通过实体类对象多条件查询")
    @GetMapping("selectUserAllAux")
    public ResultVO selectUserAllAux(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, UserAux user){
        try{
            Map<String,Object> Result = userService.selectUserAllAux(pageNum,pageSize,user);
            return ResultVO.success(Result.get("data"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVO.systemFailed(e.getMessage());
        }
    }
    
    /**
     * 添加单条数据
     *
     * @param user 添加数据对象
     * @return 结果标志
     */
     @ApiOperation("添加单条数据")
     @PostMapping("insertUserOne")
    public ResultVO insertUserOne(@RequestBody User user){
     try {
             Map<String,Object>  Result = userService.insertUserOne(user);
                 return ResultVO.success(Result.get("data"));
           
         } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
         }
      }
    
    /**
     * 删除单条数据
     *
     * @param id 主键
     * @return 结果标志
     */
     @ApiOperation("删除单条数据")
     @DeleteMapping("deleteUserOne")
    public ResultVO deleteUserOne(Long id){
      try {

             Map<String,Object>  Result = userService.deleteUserOne(id);
                 return ResultVO.success(Result.get("data"));
         } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
         }
    }
    
    /**
     * 修改单条数据
     *
     * @param user 修改数据对象
     * @return 结果标志
     */
     @ApiOperation("修改单条数据")
     @PostMapping("updateUserOne")
    public ResultVO updateUserOne(@RequestBody User user){
     try {
             Map<String,Object>  Result = userService.updateUserOne(user);
                 return ResultVO.success(Result.get("data"));
           
         } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
         }
    }

    /**
     * 性别下拉框查询
     */
    @ApiOperation("性别下拉框查询")
    @GetMapping("selectSex")
    public ResultVO selectSex(){
        return ResultVO.success(userService.selectSex());
    }

    /**
     * 总数信息查询
     */
    @ApiOperation("性别下拉框查询")
    @GetMapping("selectCount")
    public ResultVO selectCount(){
        return ResultVO.success(userService.selectSex());
    }


    /**
     * 批量删除数据
     *
     * @param ids 删除主键id组
     * @return 结果标志
     */
     @ApiOperation("批量删除数据")
     @DeleteMapping("deleteUserByList")
    public ResultVO deleteUserOne(@RequestParam(value = "ids",required = false)List<Long> ids){
    try {
             Map<String,Object>  Result =  userService.deleteUserSome(ids);
                 return ResultVO.success(Result.get("data"));

         } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
         }
    }
    
    /**
     * 批量添加数据
     *
     * @param users 添加数据对象
     * @return 结果标志
     */
     @ApiOperation("批量添加数据")
     @PostMapping("insertUserSome")
    public ResultVO insertUserSome(List<User> users){
     try {
             Map<String,Object>  Result =  userService.insertUserSome(users);
   
                 return ResultVO.success(Result.get("data"));
        
         } catch (Exception e) {
             e.printStackTrace();
             return ResultVO.systemFailed(e.getMessage());
         }
    }

    /**
     * 模板导出
     */
    @ApiOperation("模板导出")
    @GetMapping("Exporttemplatemuban")
    public void Exporttemplatemuban(HttpServletRequest request, HttpServletResponse response){
        userService.Exporttemplatemuban(request,response);
    }


    /**
     * 数据导出
     */
    @ApiOperation("数据导出")
    @GetMapping("Exporttemplate")
    public void Exporttemplate(HttpServletRequest request, HttpServletResponse response, User user) throws Exception{
        try{
            userService.Exporttemplate(request,response,user);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param MultipartFile
     * @throws IOException
     */
    @ApiOperation("模板导入")
    @PostMapping("readExcelUser")
    public void inputshuju(MultipartFile MultipartFile) throws Exception {
        userService.readExcelUser(MultipartFile);
    };


}