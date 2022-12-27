package com.myj.mapper;

import com.myj.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImportMapper {

    List<User> testMybatis();
}
