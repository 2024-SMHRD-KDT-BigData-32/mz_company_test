package com.smhrd.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.ChatRoom;
import com.smhrd.entity.Chatting;
import com.smhrd.entity.Schedule;
import com.smhrd.mapper.ChattingMapper;

@RestController
@RequestMapping("/chat")
public class ChattingController {

	private static final Logger logger = LoggerFactory.getLogger(ChattingController.class);
	
	@Autowired
	private ChattingMapper mapper;
	
	@GetMapping("/list/{project_idx}/history")
	public List<Chatting> ChattingList() {

		return mapper.chatList();
	}
	
	@PostMapping("/massage")
	public ResponseEntity<String> massageSave(@RequestBody Chatting chatting) {
		try {
			logger.info("일정 추가: {}", chatting);
			int result = mapper.massageSave(chatting);
			logger.info("일정 추가 결과: {}", result);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 추가 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/upload")
	public ResponseEntity<String> fileUpload(@RequestBody Chatting chatting) {
		try {
			logger.info("일정 추가: {}", chatting);
			int result = mapper.fileUpload(chatting);
			logger.info("일정 추가 결과: {}", result);
			return new ResponseEntity<>("success", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("일정 추가 실패: {}", e.getMessage());
			return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
