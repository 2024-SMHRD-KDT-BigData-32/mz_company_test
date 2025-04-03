package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.User;

@Mapper
public interface UserMapper {

	public int join(User user);

	public User select(User user);

	
}
