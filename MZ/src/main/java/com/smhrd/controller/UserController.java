package com.smhrd.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.User;
import com.smhrd.mapper.UserMapper;


@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserMapper mapper;
	
		
	@PostMapping("/join")
	public int join(@RequestBody User user) { 
		User check = mapper.select(user);
		
		int result = 0;
		if(check != null) {
			result = -1;
		}
		else {
			result = mapper.join(user);	
		}
		return result;
	}
	
	

	
	
}
