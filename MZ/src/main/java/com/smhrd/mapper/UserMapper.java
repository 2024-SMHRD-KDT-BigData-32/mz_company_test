package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.smhrd.entity.User;

@Mapper
public interface UserMapper {

	User getUserByIdPw(@Param("userId") String userId, @Param("userPw") String userPw);

}
