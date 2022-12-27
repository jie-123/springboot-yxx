package com.myj.service.impl;

import com.myj.entity.User;
import com.myj.mapper.ImportMapper;
import com.myj.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportServiceImpl implements ImportService {

    @Autowired
    private ImportMapper importMapper;

    /**
     * 测试mybatis
     * @return
     */
    @Override
    public List<User> testMybatis() {
        return importMapper.testMybatis();
    }
}
