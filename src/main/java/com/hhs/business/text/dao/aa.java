package com.hhs.business.text.dao;

import com.hhs.business.text.entity.text;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface aa extends BaseMapper<text> {

    @Select("select id from text where name = #{name}")
    public String textGetInfo (@Param("name") String name);
}
