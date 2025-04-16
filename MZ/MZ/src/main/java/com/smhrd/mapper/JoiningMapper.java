package com.smhrd.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.smhrd.entity.Joining;

@Mapper
public interface JoiningMapper {

	Integer insertJoining(Joining joiningData);

	boolean updateJoining(@Param("join_idx") Integer join_idx, 
			@Param("approval_yn") Character approval_yn,@Param("rc_role") String rc_role);

	boolean deleteJoining(@Param("join_idx") Integer join_idx);

	boolean checkApplied(@Param("user_id") String user_id, @Param("rc_idx") Integer rc_idx);

	Integer getRcIdxByJoinIdx(@Param("join_idx") Integer join_idx);

}
