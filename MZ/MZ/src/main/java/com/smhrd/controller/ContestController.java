package com.smhrd.controller;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Contest;
import com.smhrd.mapper.ContestMapper;

@RestController
@RequestMapping("/contest")
public class ContestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

	@Autowired
	private ContestMapper mapper;
	
	// 검색 필터를 위한 리스트 컨트롤러 수정
	
	@GetMapping("/list")
    @ResponseBody
    public List<Contest> contestList(
            @RequestParam(value = "q", required = false) String searchQuery,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "app_qualification", required = false) String appQualification,
            @RequestParam(value = "prize", required = false) String prize,
            @RequestParam(value = "app_method", required = false) String appMethod) {
        Map<String, Object> params = new HashMap<>();

        if (searchQuery != null && !searchQuery.isEmpty()) {
            params.put("searchQuery", searchQuery);
        }
        if (category != null && !category.isEmpty()) {
            params.put("category", Arrays.asList(category.split(",")));
        }
        if (appQualification != null && !appQualification.isEmpty()) {
            params.put("app_qualification", Arrays.asList(appQualification.split(",")));
        }
        if (prize != null && !prize.isEmpty()) {
            params.put("prize", Arrays.asList(prize.split(",")));
        }
        if (appMethod != null && !appMethod.isEmpty()) {
            params.put("app_method", Arrays.asList(appMethod.split(",")));
        }

        return mapper.findContestsByFilters(params);
    }
 
	
//	@GetMapping("/list")
//	public List<Contest> contestList () {
//		return mapper.contestList();		
//	}
	
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
