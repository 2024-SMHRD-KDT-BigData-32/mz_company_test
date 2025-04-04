package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Contest;
import com.smhrd.mapper.ContestMapper;

@RestController
@RequestMapping("/contest")
public class ContestController {

	@Autowired
	private ContestMapper mapper;
	
	@GetMapping("/list")
	public List<Contest> contestList () {
		
		return mapper.contestList();		
	}
	
	@GetMapping("/{contest_idx}")
    public Contest contestDetail(@PathVariable int contest_idx) {
		
        return mapper.contestDetail(contest_idx);
    }
	

}
