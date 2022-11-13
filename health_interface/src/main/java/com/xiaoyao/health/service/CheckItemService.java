package com.xiaoyao.health.service;

import com.xiaoyao.health.entity.PageResult;
import com.xiaoyao.health.entity.QueryPageBean;
import com.xiaoyao.health.pojo.CheckItem;

/**
 * @author xiaoyao
 * @create 2022-03-13 23:22
 */
public interface CheckItemService {

    /**
     * 新增检查项
     * @param checkItem
     */
    void addCheckItem(CheckItem checkItem);

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 删除检查项
     * @param id
     */
    void deleteCheckItem(Integer id);

    CheckItem findCheckItemInfoById(Integer id);

    void editCheckItemInfo(CheckItem checkItem);
}
