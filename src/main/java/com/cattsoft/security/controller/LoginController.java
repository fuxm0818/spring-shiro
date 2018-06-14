package com.cattsoft.security.controller;

import com.cattsoft.security.entity.ManagerInfo;
import com.cattsoft.security.entity.Result;
import com.cattsoft.security.service.ManagerInfoService;
import com.cattsoft.security.utils.JWTUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: XXXXX <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/6/14 下午4:05
 */
@RestController
public class LoginController {

    @Resource
    private ManagerInfoService managerInfoService;

    private static final Logger _logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        ManagerInfo user = managerInfoService.findByUsername(username);
        //盐（用户名+随机数）
        String salt = user.getSalt();
        //原密码
//        String encodedPassword = ShiroKit.md5(password, username + salt);
        String encodedPassword = password;
        if (user.getPassword().equals(encodedPassword)) {
            Map map = new HashMap();
            map.put("token", JWTUtil.sign(username, encodedPassword));
            return Result.ok().put(map);
        } else {
            throw new UnauthorizedException();
        }
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        return Result.error(org.apache.http.HttpStatus.SC_UNAUTHORIZED, "token失效");
    }

}