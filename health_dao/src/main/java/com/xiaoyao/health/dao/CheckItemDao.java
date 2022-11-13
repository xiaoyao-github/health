package com.xiaoyao.health.dao;

import com.github.pagehelper.Page;
import com.xiaoyao.health.pojo.CheckItem;
import org.springframework.stereotype.Repository;

/**
 * @author xiaoyao
 * @create 2022-03-13 23:25
 */
@Repository
public interface CheckItemDao {

    void addCheckItem( CheckItem checkItem);

    Page<CheckItem> selectByCondition(String queryString);

    void deleteCheckItem(Integer id);

    CheckItem findCheckItemInfoById(Integer id);

    void editCheckItemInfo(CheckItem checkItem);
}
