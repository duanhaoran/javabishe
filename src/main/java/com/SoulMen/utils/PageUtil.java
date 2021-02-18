package com.SoulMen.utils;

import com.github.pagehelper.PageInfo;
import com.SoulMen.base.entity.VO.PageVO;

import java.util.List;

/**
 * 分页工具类
 * Created by scumbag on 2020/10/9.
 */
public class PageUtil {

    public static PageInfo pageResultInfo(List<?> list) {
        return new PageInfo<>(list);
    }

    public static <T> PageVO<T> pageResultVO(List<T> list) {
        return new PageVO<>(list);
    }

}
