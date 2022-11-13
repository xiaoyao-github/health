package com.xiaoyao.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaoyao.health.constant.MessageConstant;
import com.xiaoyao.health.entity.PageResult;
import com.xiaoyao.health.entity.QueryPageBean;
import com.xiaoyao.health.entity.Result;
import com.xiaoyao.health.pojo.CheckItem;
import com.xiaoyao.health.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoyao
 * @create 2022-03-13 23:01
 */
@RestController
@RequestMapping(value = "/checkItem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    /**
     * 新增检查项
     * @param checkItem
     * @return
     */
    @RequestMapping(value = "/add")
    public Result addCheckItem(@RequestBody CheckItem checkItem){
        try {
            checkItemService.addCheckItem(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @RequestMapping(value = "/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = null;
        try {
            pageResult = checkItemService.findPage(queryPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL,null);
        }
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);

        //PageResult pageResult = checkItemService.findPage(queryPageBean);
        //return pageResult;
    }

    /**
     * 删除一行检查项
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public Result delete(Integer id){
        try {
            checkItemService.deleteCheckItem(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    /**
     * 编辑检查项获取待编辑的数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/findCheckItemInfoById")
    public Result findCheckItemInfoById(Integer id){
        try {
            CheckItem checkItem = checkItemService.findCheckItemInfoById(id);
            System.out.println("id:"+id);
            System.out.println("checkItem:"+checkItem);
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    @RequestMapping(value = "/editCheckItemInfo")
    public Result editCheckItemInfo(@RequestBody CheckItem checkItem){
        try {
            checkItemService.editCheckItemInfo(checkItem);
            return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_CHECKITEM_FAIL);
        }
    }
}
