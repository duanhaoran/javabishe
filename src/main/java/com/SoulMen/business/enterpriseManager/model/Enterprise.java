package com.SoulMen.business.enterpriseManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


/**
 * (Enterprise)实体类
 *
 * @author makejava
 * @since 2021-02-14 14:44:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    @Id
    /**
     * 企业id
     */
    private Integer enterpriseId;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 0-禁  1-正常
     */
    private Integer enterpriseStats;


}