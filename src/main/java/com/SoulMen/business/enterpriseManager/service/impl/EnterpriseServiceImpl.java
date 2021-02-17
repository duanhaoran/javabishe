package com.SoulMen.business.enterpriseManager.service.impl;

import com.SoulMen.base.result.CheckUtil;
import com.SoulMen.business.enterpriseManager.dao.EnterpriseDao;
import com.SoulMen.business.enterpriseManager.model.Enterprise;
import com.SoulMen.business.enterpriseManager.model.EnterpriseAux;
import com.SoulMen.business.enterpriseManager.service.EnterpriseService;
import com.SoulMen.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * @author makejava
 * @description (Enterprise)表服务实现类
 * @since 2021-02-14 14:44:34
 */
@Service()
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    EnterpriseDao enterpriseDao;

    private Map<String, Object> checkMap = null;

    /**
     * @param id 主键
     * @return 单条数据
     * @description 通过主键查询单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> selectEnterpriseOne(Integer id) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultMap(enterpriseDao.selectByPrimaryKey(id));
    }

    /**
     * @param enterprise 查询实体类对象
     * @return 数据集合
     * @description 通过实体类对象多条件查询
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> selectEnterpriseAll(Integer pageNum, Integer pageSize, EnterpriseAux enterprise) throws Exception {
        PageUtils pageUtils = new PageUtils();
        pageUtils.setCurrentPage(pageNum);
        pageUtils.setPageSizes(pageSize);
        List<EnterpriseAux> EnterpriseAux=enterpriseDao.selectEnterpriseAll(enterprise);
        List<EnterpriseAux> EnterpriseAuxStr=new ArrayList<>();
        EnterpriseAux Enterpr;
        for(int i = 0;i<EnterpriseAux.size();i++){
            Enterpr=EnterpriseAux.get(i);
            if(Enterpr.getEnterpriseStats()>0){
                Enterpr.setEnterpriseStatsString("正常");
            }else{
                Enterpr.setEnterpriseStatsString("封禁");
            }
            EnterpriseAuxStr.add(i,Enterpr);
        }
        pageUtils.setDataList(EnterpriseAuxStr);
        return CheckUtil.getResultMap(pageUtils.paging());
    }

    /**
     * @param enterprise 添加数据对象
     * @return 结果标志
     * @description 添加单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> insertEnterpriseOne(Enterprise enterprise) throws Exception {
        checkMap = CheckUtil.getCheck(enterprise.getEnterpriseId(), "EnterpriseId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(enterprise.getEnterpriseName(), "EnterpriseName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(enterprise.getEnterpriseStats(), "EnterpriseStats");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(enterpriseDao.insert(enterprise));
    }

    /**
     * @param id 主键
     * @return 结果标志
     * @description 删除单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> deleteEnterpriseOne(Integer id) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(id, "id");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(enterpriseDao.deleteByPrimaryKey(id));
    }

    /**
     * @param enterprise 修改数据对象
     * @return 结果标志
     * @description 修改单条数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> updateEnterpriseOne(Enterprise enterprise) throws Exception {
        checkMap = CheckUtil.getCheck(enterprise.getEnterpriseId(), "EnterpriseId");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(enterprise.getEnterpriseName(), "EnterpriseName");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        checkMap = CheckUtil.getCheck(enterprise.getEnterpriseStats(), "EnterpriseStats");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(enterpriseDao.updateByPrimaryKey(enterprise));
    }

    /**
     * @param ids 删除主键id组
     * @return 结果标志
     * @description 批量删除数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> deleteEnterpriseSome(List<Integer> ids) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(ids, "ids");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(enterpriseDao.deleteEnterpriseSome(ids));

    }

    /**
     * @param enterprises 添加数据对象
     * @return 结果标志
     * @description 批量添加数据
     * @author makejava
     * @since 2021-02-14 14:44:34
     */
    public Map<String, Object> insertEnterpriseSome(List<Enterprise> enterprises) throws Exception {
        Map<String, Object> checkMap = CheckUtil.getCheck(enterprises, "enterprise");
        if ((Integer) checkMap.get("Code") == 3) {
            return checkMap;
        }
        return CheckUtil.getResultCodeMap(enterpriseDao.insertEnterpriseSome(enterprises));
    }
}