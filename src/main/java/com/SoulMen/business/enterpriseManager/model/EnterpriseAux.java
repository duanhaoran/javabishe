package com.SoulMen.business.enterpriseManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Enterprise)实体类
 *
 * @author makejava
 * @since 2021-02-14 14:44:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseAux  extends  Enterprise{

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
    /**
     * 0-禁  1-正常
     */
    private String enterpriseStatsString;
}