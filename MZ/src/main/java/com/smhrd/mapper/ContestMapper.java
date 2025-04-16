package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Contest;

@Mapper
public interface ContestMapper {

	public List<Contest> contestList();

	public Contest contestDetail(int contest_idx);

	public Contest getByPrjIdx(int prj_idx);
	
}
