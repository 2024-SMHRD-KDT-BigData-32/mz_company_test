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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smhrd.entity.Project;
import com.smhrd.mapper.ProjectMapper;

@RestController
@RequestMapping("/project")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	private ProjectMapper mapper;

	@PostMapping("/myList")
	public List<Project> projectList(@RequestBody Map<String, String> paramMap) {
		String userId = paramMap.get("user_id");
		return mapper.projectList(userId);
	}

	@GetMapping("{prj_idx}")
	public Project searchProject(@PathVariable int prj_idx) {

		return mapper.searchProject(prj_idx);
	}

	@GetMapping("/list")
	public Map<String, Object> prjList() {
		Map<String, Object> response = new HashMap<String, Object>();

		List<Project> list = mapper.getPrjList();
		if (list != null) {
			response.put("prjList", list);
		} else {
			response.put("prjList", null);
		}
		return response;
	}

	@PostMapping("/list")
	public Map<String, Object> usrPrjList(@RequestBody Map<String, String> requestBody) {
		Map<String, Object> response = new HashMap<String, Object>();
		String user_id = requestBody.get("user_id");
		System.out.println("Received userId from frontend: " + user_id);
		List<Project> list = mapper.getUsrPrjList(user_id);
		if (list != null) {
			response.put("usrPrjList", list);
		} else {
			response.put("usrPrjList", null);
		}
		return response;
	}

	@PostMapping("/make")
	public Map<String, Object> makePrj(@RequestBody Project projectData) {
		Map<String, Object> response = new HashMap<String, Object>();
		logger.info("makePrj 硫붿꽌�뱶 �샇異쒕맖: {}", projectData);
		try {
			boolean isSuccess = mapper.createPrj(projectData);

			if (isSuccess) {
				response.put("success", true);
			} else {
				response.put("success", false);
				response.put("message", "Failed to create project.");
			}
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", e);
		}
		return response;
	}
}
