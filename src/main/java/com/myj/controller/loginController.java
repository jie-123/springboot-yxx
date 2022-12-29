package com.myj.controller;

import com.myj.entity.UserInfo;
import com.myj.service.LoginService;
import com.myj.utils.AxiosResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class loginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param userInfo 用户信息
     * @return
     */
    @RequestMapping("/signIn")
    @ResponseBody
    public AxiosResult signIn(@RequestBody(required = true) UserInfo userInfo){
        UserInfo user = loginService.signIn(userInfo);
        if (user == null){
            return AxiosResult.error(500);
        }
        return AxiosResult.success(200);
    }
}
