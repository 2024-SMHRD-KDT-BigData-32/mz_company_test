package com.smhrd.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Schedule;
import com.smhrd.mapper.ScheduleMapper;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Autowired
	private ScheduleMapper mapper;	
	
	@GetMapping("/list")
    public List<Schedule> scheduleList() {
		
        return mapper.scheduleList();
    }

    @PostMapping("/add")
    @ResponseBody
    public String addSchedule(@RequestBody Schedule schedule) {
       
        try {
            mapper.insertSchedule(schedule);
            return "success";
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }

    @PutMapping("/update/{sche_idx}")
    @ResponseBody
    public String updateEvent(@RequestBody Schedule schedule) {
    	try {
            mapper.updateSchedule(schedule);
            return "success";
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }

    @DeleteMapping("/delete/{sche_idx}")
    @ResponseBody
    public String deleteEvent(@PathVariable String sche_idx) {
    	try {
            mapper.deleteSchedule(sche_idx);
            return "success";
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }
    
}
