package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Contest;

@Mapper
public interface ContestMapper {

	List<Contest> contestList();

	
	
}
