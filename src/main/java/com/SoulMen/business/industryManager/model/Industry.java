package com.SoulMen.business.industryManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


/**
 * (Industry)实体类
 *
 * @author makejava
 * @since 2021-02-14 18:12:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Industry {
    @Id
    /**
     * 行业id
     */
    private Integer industryId;
    /**
     * 行业名称
     */
    private String industryName;
    /**
     * 行业管理部门
     */
    private String industryAdministrativeDepartment;


}