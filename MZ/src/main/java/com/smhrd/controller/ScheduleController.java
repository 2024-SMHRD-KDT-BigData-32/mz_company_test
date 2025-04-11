package com.smhrd.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/list")
	public List<Schedule> scheduleList(@RequestBody Map<String, String> paramMap) {
		String userId = paramMap.get("prjIdx");
		return mapper.scheduleList(userId);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addSchedule(@RequestBody Schedule schedule) {
		try {
			logger.info("일정 추가: {}", schedule);
			int result = mapper.insertSchedule(schedule);
			logger.info("일정 추가 결과: {}", result);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 추가 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{sche_idx}")
	public ResponseEntity<String> updateSchedule(@PathVariable("sche_idx") int scheIdx,
			@RequestBody Schedule schedule) {
		try {
			logger.info("일정 수정: {}, ID: {}", schedule, scheIdx);
			schedule.setSche_idx(scheIdx);
			mapper.updateSchedule(schedule);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 수정 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{sche_idx}")
	public ResponseEntity<String> deleteSchedule(@PathVariable("sche_idx") int scheIdx) {
		try {
			logger.info("일정 삭제: ID {}", scheIdx);
			int result = mapper.deleteSchedule(scheIdx);
			if (result == 0) {
				logger.warn("삭제할 일정을 찾을 수 없음: ID {}", scheIdx);
				return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 삭제 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}