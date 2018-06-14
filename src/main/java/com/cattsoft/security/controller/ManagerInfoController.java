package com.cattsoft.security.controller;

import com.cattsoft.security.entity.ManagerInfo;
import com.cattsoft.security.service.ManagerInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: XXXXX <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/6/14 下午4:37
 */
@RestController
@RequestMapping("/managerInfo")
public class ManagerInfoController {

    @Resource
    private ManagerInfoService managerInfoService;

    @GetMapping("/list")
    public List<ManagerInfo> list() {
        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setId(1);
        managerInfo.setPassword("123123");
        managerInfo.setSalt("123123");
        managerInfo.setUsername("abc");

        ManagerInfo managerInfo2 = new ManagerInfo();
        managerInfo2.setId(1);
        managerInfo2.setPassword("234234");
        managerInfo2.setSalt("234234");
        managerInfo2.setUsername("bcd");

        List list = new LinkedList<ManagerInfo>();
        list.add(managerInfo);
        list.add(managerInfo2);
        return list;
    }
}
