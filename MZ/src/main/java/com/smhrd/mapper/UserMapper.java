package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

import com.smhrd.entity.User;

@Mapper
public interface UserMapper {

	User getUserByIdPw(@Param("user_id") String user_id, @Param("user_pw") String user_pw);
	
	public int join(User user);

	public User select(User user);
	
}
