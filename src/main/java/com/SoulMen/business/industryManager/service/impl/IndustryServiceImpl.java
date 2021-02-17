package com.SoulMen.business.industryManager.service.impl;

import com.SoulMen.base.result.CheckUtil;
import com.SoulMen.base.result.PageUtils;
import com.SoulMen.business.industryManager.dao.IndustryDao;
import com.SoulMen.business.industryManager.model.Industry;
import com.SoulMen.business.industryManager.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



/**
 * @author makejava
 * @description (Industry)表服务实现类
 * @since 2021-02-14 18:12:37
 */
@Service()
public class IndustryServiceImpl implements IndustryService {
    @Autowired
    IndustryDao industryDao;

    private Map<String, Object> checkMap = null;

    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> selectIndustryOne(Integer id) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultMap(industryDao.selectByPrimaryKey(id));
    }

    /**
     * @param industry 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> selectIndustryAll(Integer pageNum, Integer pageSize, Industry industry) throws Exception {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        pageUtils.setDataList(industryDao.selectIndustryAll(industry));
        return CheckUtil.getResultMap(pageUtils.paging());
    }

    /**
     * @param industry 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> insertIndustryOne(Industry industry) throws Exception {
        checkMap = CheckUtil.getCheck(industry.getIndustryId(), "IndustryId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(industry.getIndustryName(), "IndustryName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(industry.getIndustryAdministrativeDepartment(), "IndustryAdministrativeDepartment");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(industryDao.insert(industry));
    }

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> deleteIndustryOne(Integer id) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(industryDao.deleteByPrimaryKey(id));
    }

    /**
     * @param industry 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> updateIndustryOne(Industry industry) throws Exception {
        checkMap = CheckUtil.getCheck(industry.getIndustryId(), "IndustryId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(industry.getIndustryName(), "IndustryName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(industry.getIndustryAdministrativeDepartment(), "IndustryAdministrativeDepartment");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(industryDao.updateByPrimaryKey(industry));
    }

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> deleteIndustrySome(List<Integer> ids) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(ids, "ids");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(industryDao.deleteIndustrySome(ids));

    }

    /**
     * @param industrys 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 18:12:37
     */
    public Map<String, Object> insertIndustrySome(List<Industry> industrys) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(industrys, "industry");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(industryDao.insertIndustrySome(industrys));
    }
}