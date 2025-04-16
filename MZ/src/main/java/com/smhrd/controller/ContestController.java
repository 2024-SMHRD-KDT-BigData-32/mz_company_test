package com.smhrd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Contest;
import com.smhrd.mapper.ContestMapper;

@RestController
@RequestMapping("/contest")
public class ContestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

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
	
	@PostMapping("/get")
	public Map<String, Object> get(@RequestBody Map<String, Integer> requestBody){
	    int contest_idx = requestBody.get("contest_idx");
	    Map<String, Object> response = new HashMap<String, Object>();

	    Contest contest = mapper.contestDetail(contest_idx);
	    if(contest != null) {
	        response.put("contest", contest);
	    } else {
	        response.put("contest", null);
	    }
	    return response;
	}
}
