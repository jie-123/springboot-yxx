package com.myj.mapper;

import com.myj.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LoginMapper {

    UserInfo signIn(@Param("user") UserInfo userInfo);
}
