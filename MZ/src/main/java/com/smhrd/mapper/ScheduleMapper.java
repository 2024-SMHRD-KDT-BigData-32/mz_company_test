package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Schedule;

@Mapper
public interface ScheduleMapper {

	public List<Schedule> scheduleList();
    public String insertSchedule(Schedule schedule);
    public String updateSchedule(Schedule schedule);
    public String deleteSchedule(String sche_idx);
}
