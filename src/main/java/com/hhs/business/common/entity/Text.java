package com.hhs.business.common.entity;

import java.io.Serializable;

/**
 * (Text)实体类
 *
 * @author makejava
 * @since 2020-09-01 10:46:23
 */
public class Text implements Serializable {
    private static final long serialVersionUID = 325836919252670341L;

    private String id;

    private String name;

    private Integer age;

    private String bir;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBir() {
        return bir;
    }

    public void setBir(String bir) {
        this.bir = bir;
    }

}