package com.xiaoyao.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaoyao.health.service.CheckItemService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaoyao
 * @create 2022-07-04 22:04
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckGroupServiceImpl {
}
