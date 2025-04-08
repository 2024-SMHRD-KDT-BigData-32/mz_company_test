package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Task;

@Mapper
public interface TaskMapper {

	List<Task> workList();

	int deleteWork(int task_idx);

	void updateWork(Task task);

	int addWork(Task task);
}
