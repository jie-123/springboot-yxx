package com.myj.service.impl;

import com.myj.entity.UserInfo;
import com.myj.mapper.LoginMapper;
import com.myj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserInfo signIn(UserInfo userInfo) {
        return loginMapper.signIn(userInfo);
    }
}
