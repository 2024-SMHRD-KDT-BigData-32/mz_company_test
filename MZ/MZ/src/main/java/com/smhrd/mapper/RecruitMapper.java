package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.smhrd.entity.Contest;
import com.smhrd.entity.Recruit;

@Mapper
public interface RecruitMapper {

	boolean writeRc(Recruit recruitData);

	int insertRecruit(Recruit recruit);

	boolean insertRecruitStacks(@Param("rcIdx") int rcIdx, @Param("requiredSkills") List<Integer> requiredSkills);

	List<Recruit> selectRcAll();

	List<Integer> selectStacksByRcIdx(@Param("rc_idx") int rc_idx);

	String selectStackNameByIdx(@Param("stack_idx") int stack_idx);

	Recruit selectRcByIdx(@Param("rc_idx") int rc_idx);

	int selectPrjIdxByRcIdx(int rc_idx);

	Integer selectContestIdxByPrjIdx(@Param("prj_idx") int prj_idx);

	Contest selectContestByContestIdx(@Param("contest_idx") int contest_idx);

	String getRcTitleByIdx(@Param("rc_idx") Integer rc_idx);

}
