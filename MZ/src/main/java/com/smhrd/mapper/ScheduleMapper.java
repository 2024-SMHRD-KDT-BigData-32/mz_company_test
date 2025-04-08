package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Schedule;

@Mapper
public interface ScheduleMapper {

	public List<Schedule> scheduleList();
	public int insertSchedule(Schedule schedule);
	public void updateSchedule(Schedule schedule);
	public int deleteSchedule(int sche_idx);
}
