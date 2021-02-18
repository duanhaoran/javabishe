package com.SoulMen.utils;

import com.SoulMen.base.entity.ResultEnum;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
/**
 * 结果工具类
 * Created by jackeyWater on 2020/10/9.
 */
@Log4j2
public class ResultUtil {

    public static <T> Map<String,Object> getCheck(T data ,String name) throws Exception {
        Map<String,Object> checkMap = new HashMap<>();
        if (data == null){
            log.error("持久层操作前校验失败！传入参数为空！");
            checkMap.put("Code",ResultEnum.nullParameter.getCode());
            checkMap.put("Message",ResultEnum.nullParameter.getMessage()+",缺少值为："+name);
            throw new Exception(ResultEnum.nullParameter.getMessage()+",缺少值为："+name);
        } else {
            log.info("参数正常！进行下一步操作！");
            checkMap.put("Code",ResultEnum.success.getCode());
        }
        return checkMap;
    }

    public static Map<String,Object> getResultMap(Object object) throws Exception{
        Map<String,Object> ResultMap = new HashMap<>();
        if (object == null){
            ResultMap.put("Code",ResultEnum.nullResult.getCode());
            ResultMap.put("Message",ResultEnum.nullResult.getMessage());
            log.error("查询结果为空！");
            throw new Exception(ResultEnum.nullResult.getMessage());
        } else {
            log.info("信息查询成功！");
            log.info("查询结果为："+object.toString());
            ResultMap.put("Message",ResultEnum.success.getMessage());
            ResultMap.put("Code",ResultEnum.success.getCode());
            ResultMap.put("data",object);
        }
        return ResultMap;
    }

    public static Map<String,Object> getResultCodeMap(Object object) throws Exception{
        Map<String,Object> ResultMap = new HashMap<>();
        if (object == null){
            ResultMap.put("Code",ResultEnum.filedOther.getCode());
            ResultMap.put("Message",ResultEnum.filedOther.getMessage());
            log.error("提交失败！原因未知！");
            throw new Exception(ResultEnum.filedOther.getMessage());
        } else if ((Integer)object == 0){
            ResultMap.put("data",object);
            ResultMap.put("Code",ResultEnum.filedSQLExecute.getCode());
            ResultMap.put("Message",ResultEnum.filedSQLExecute.getMessage()+"：输入ID无效!");
            log.info("数据库执行返回结果为："+object);
            log.error("数据库提交执行失败！");
            throw new Exception(ResultEnum.filedSQLExecute.getMessage()+"：输入ID无效!");
        } else {
            ResultMap.put("data",object);
            ResultMap.put("Code",ResultEnum.success.getCode());
            ResultMap.put("Message",ResultEnum.success.getMessage());
            log.info("数据库执行成功！");
            log.info("数据库执行返回结果为："+object);
        }
        return ResultMap;
    }

}
