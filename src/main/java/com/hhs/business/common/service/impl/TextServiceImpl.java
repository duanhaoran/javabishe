package com.hhs.business.common.service.impl;

import com.hhs.business.common.dao.TextDao;
import com.hhs.business.common.entity.Text;
import com.hhs.business.common.service.TextService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Text)表服务实现类
 *
 * @author makejava
 * @since 2020-09-01 10:46:24
 */
@Service("textService")
public class TextServiceImpl implements TextService {
    @Resource
    private TextDao textDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Text queryById(String id) {
        return this.textDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Text> queryAllByLimit(int offset, int limit) {
        return this.textDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param text 实例对象
     * @return 实例对象
     */
    @Override
    public Text insert(Text text) {
        this.textDao.insert(text);
        return text;
    }

    /**
     * 修改数据
     *
     * @param text 实例对象
     * @return 实例对象
     */
    @Override
    public Text update(Text text) {
        this.textDao.update(text);
        return this.queryById(text.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.textDao.deleteById(id) > 0;
    }
}