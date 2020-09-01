package com.hhs.business.common.controller;

import com.hhs.business.common.entity.Text;
import com.hhs.business.common.service.TextService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Text)表控制层
 *
 * @author makejava
 * @since 2020-09-01 10:46:24
 */
@RestController
@RequestMapping("text")
public class TextController {
    /**
     * 服务对象
     */
    @Resource
    private TextService textService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Text selectOne(String id) {
        return this.textService.queryById(id);
    }

}