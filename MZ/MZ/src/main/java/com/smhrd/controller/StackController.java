package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.TechStack;
import com.smhrd.mapper.StackMapper;

@RestController
@RequestMapping("/stack")
public class StackController {
	
	@Autowired
	private StackMapper mapper;
	
	@GetMapping("/list")
	public List<TechStack> getStacks(){
		List<TechStack> list = mapper.getStackList();
		return list;
	}
}
