package com.cattsoft.security.service;

import com.cattsoft.security.entity.ManagerInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Service;

/**
 * Description: XXXXX <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/6/14 下午4:19
 */
@Service
public class ManagerInfoService {

    /**
     * 通过名称查找用户
     *
     * @param username
     * @return
     */
    public ManagerInfo findByUsername(String username) {
//        ManagerInfo managerInfo = managerInfoDao.findByUsername(username);
        ManagerInfo managerInfo = new ManagerInfo();
        managerInfo.setId(1);
        managerInfo.setPassword("123123");
        managerInfo.setSalt("123123");
        managerInfo.setUsername("abc");

        if (managerInfo == null) {
            throw new UnknownAccountException();
        }
        return managerInfo;
    }


}
