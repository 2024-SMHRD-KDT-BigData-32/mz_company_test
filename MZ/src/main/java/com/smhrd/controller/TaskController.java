package com.smhrd.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Project;
import com.smhrd.entity.Schedule;
import com.smhrd.entity.Task;
import com.smhrd.mapper.TaskMapper;

@RestController
@RequestMapping("/task")
public class TaskController {

	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TaskMapper mapper;
	
	
//	@GetMapping("/list")
//	public List<Task> workList(){
//		
//		return mapper.workList();
//	}
//	
	@GetMapping("/list")
	public List<Task> workList(@RequestParam("prjIdx") int prj_idx){
		
		return mapper.workList(prj_idx);
	}
	
	
	@DeleteMapping("/delete/{task_idx}")
	public ResponseEntity<String> deleteWork(@PathVariable("task_idx") int task_idx) {
		try {
			logger.info("일정 삭제: ID {}", task_idx);
			int result = mapper.deleteWork(task_idx);
			if (result == 0) {
				logger.warn("삭제할 일정을 찾을 수 없음: ID {}", task_idx);
				return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 삭제 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{task_idx}")
	public ResponseEntity<String> updateWork(@PathVariable("task_idx") int task_idx, @RequestBody Task task) {
		
		try {
			task.setTask_idx(task_idx);
			mapper.updateWork(task);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@PostMapping("/add")
	public ResponseEntity<String> addWork(@RequestBody Task task) {
		try {
			logger.info("일정 추가: {}", task);
			int result = mapper.addWork(task);
			logger.info("일정 추가 결과: {}", result);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 추가 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}