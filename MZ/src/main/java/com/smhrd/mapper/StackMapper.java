package com.smhrd.mapper;

import java.util.List;
import java.util.Stack;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.TechStack;

@Mapper
public interface StackMapper {

	List<TechStack> getStackList();

}
