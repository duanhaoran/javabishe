package com.SoulMen.business.createManager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 建表接口
 *
 * @author scumbag
 * @since 2020-10-21 14:41:21
 */
@Api("建表")
@RestController
@RequestMapping("/createController/")
public class createController {

    @Autowired
    com.SoulMen.business.createManager.service.createService createService;

    //    CommonResult<User>
    @ApiOperation(value = "建表导入")
    @PostMapping(value = "/createTable")
    public void createTable(MultipartFile MultipartFile) throws IOException {
        createService.createTable(MultipartFile);
    }
    @ApiOperation(value = "数据导入")
    @PostMapping(value = "/insertTable")
    public void insertTable(MultipartFile MultipartFile) throws IOException {
        createService.insertTable(MultipartFile);
    }
    @ApiOperation(value = "数据导入")
    @PostMapping(value = "/ceshi")
    public void ceshi()   {
        Date now=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String b=sdf.format(now);
        Integer d=10;
        for (Integer a=0;a<20;a++){
            String c=null;
            if (a.compareTo(d)>=0) {
                c=b.substring(0,6) +a.toString();
            }else {
                c=b.substring(0,6) +"0"+a.toString();
            }
            System.out.println(c);
            if (c.equals(b)){
                break;

            }
        }
    }



}