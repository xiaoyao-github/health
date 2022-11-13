package com.xiaoyao.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaoyao.health.dao.CheckItemDao;
import com.xiaoyao.health.entity.PageResult;
import com.xiaoyao.health.entity.QueryPageBean;
import com.xiaoyao.health.pojo.CheckItem;
import com.xiaoyao.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaoyao
 * @create 2022-03-13 23:20
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    //注入DAO层
    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增检查项
     * @param checkItem
     */
    @Override
    public void addCheckItem(CheckItem checkItem) {
        checkItemDao.addCheckItem(checkItem);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //组装分页查询的条件
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 删除检查项
     * @param id
     */
    @Override
    public void deleteCheckItem(Integer id) {
        checkItemDao.deleteCheckItem(id);
    }

    @Override
    public CheckItem findCheckItemInfoById(Integer id) {
        CheckItem checkItem = checkItemDao.findCheckItemInfoById(id);
        return checkItem;
    }

    @Override
    public void editCheckItemInfo(CheckItem checkItem) {
        checkItemDao.editCheckItemInfo(checkItem);
    }
}
