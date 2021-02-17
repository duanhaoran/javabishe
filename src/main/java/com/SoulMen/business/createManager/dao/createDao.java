package com.SoulMen.business.createManager.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface createDao {
    @Update("${create}")
    Integer createTable(@Param("create")String create);
    @Insert("${insert}")
    Integer insertTable(@Param("insert")String insert);
}
