package com.smhrd.mapper;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Param;

import com.smhrd.entity.TechStack;
import com.smhrd.entity.User;

@Mapper
public interface UserMapper {

	User getUserByIdPw(@Param("user_id") String user_id, @Param("user_pw") String user_pw);
	
	public int join(User user);

	public User select(User user);
	
	// 프로필 수정 부분
    User findUserById(String user_id);
    int updateUser(User user);
    List<TechStack> findStacksByUserId(String user_id);
    List<TechStack> findAllStacks();
    int deleteStacksByUserId(String user_id);
    int insertUserStack(@Param("user_id") String user_id, @Param("stack_idx") int stack_idx);

	String selectUserIdByPrjIdx(@Param("prj_idx") Integer prj_idx);

	User selectUserById(@Param("user_id") String user_id);

	List<String> selectUserIdByJoiningPrjIdx(@Param("prj_idx") Integer prj_idx);

	Collection<? extends User> selectUsersByIds(@Param("userIdList") List<String> userIdList);

	
}
