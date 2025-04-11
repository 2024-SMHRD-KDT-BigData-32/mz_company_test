package com.smhrd.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.smhrd.entity.Recruit;
import com.smhrd.mapper.RecruitMapper;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

	private static final Logger logger = LoggerFactory.getLogger(RecruitController.class);

	@Autowired
	private RecruitMapper mapper;

	@PostMapping("/write")
	public Map<String, Object> writeRc(@RequestBody Map<String, Object> recruitData) {
		Map<String, Object> response = new HashMap<String, Object>();
		logger.info("recruitData: {}", recruitData);

		int prjIdx = Integer.parseInt(recruitData.get("prj_idx").toString());
		String rcTitle = (String) recruitData.get("rc_title");
		String rcContent = (String) recruitData.get("rc_content");
		String userId = (String) recruitData.get("user_id");
		Timestamp closedAt = null;
		String closedAtStr = (String) recruitData.get("closed_at");
		closedAt = Timestamp.valueOf(closedAtStr + " 00:00:00");

		List<Integer> requiredSkills = (List<Integer>) recruitData.get("required_skills");

		try {
			Recruit recruit = new Recruit(prjIdx, rcTitle, rcContent, userId, closedAt);
			mapper.insertRecruit(recruit);
			int rcIdx = recruit.getRc_idx();

			logger.info("rcIdx: {}", rcIdx);

			if (rcIdx > 0 && requiredSkills != null && !requiredSkills.isEmpty()) {
				boolean isSuccess = mapper.insertRecruitStacks(rcIdx, requiredSkills);
				if (isSuccess) {
					response.put("success", true);
				} else {
					response.put("success", false);
					response.put("message", "공고글 기술 스택 저장에 실패했습니다.");
				}
			} else if (rcIdx > 0) {
				response.put("success", true); // 기술 스택이 없는 경우에도 성공으로 처리할지 여부 결정
			} else {
				response.put("success", false);
				response.put("message", "모집 게시글 저장에 실패했습니다.");
			}

		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "서버 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping("/list")
	public Map<String, Object> getRcList() {
		Map<String, Object> response = new HashMap<String, Object>();

		try {
			List<Recruit> list = mapper.selectRcAll();

			if (list != null) {
				response.put("rcList", list);
				response.put("success", true);
			} else {
				response.put("success", false);
				response.put("message", "등록된 공고 글이 없습니다.");
			}
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", e);
		}

		return response;
	}

	@PostMapping("/stacks")
	public Map<String, Object> getStacksByRcIdx(@RequestBody Map<String, Object> rcData){
		Map<String, Object> response = new HashMap<String, Object>();
		int rc_idx = (int) rcData.get("rc_idx");
		
		try {
			List<Integer> list =  mapper.selectStacksByRcIdx(rc_idx);
			if (list != null && !list.isEmpty()) {
				List<String> stackNames = new ArrayList<String>();
				for(int stack_idx : list) {
					String stackName = mapper.selectStackNameByIdx(stack_idx);
					if(stackName != null) {
						stackNames.add(stackName);
					}
				}
				response.put("stackNames", stackNames);
				response.put("success", true);
			} else {
				response.put("success", new ArrayList<String>());
				response.put("message", "등록된 기술 스택이 없습니다.");
			}
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", e);
		}
		
		return response;
	}
	
	
	@PostMapping("/contestIdx")
	public Map<String, Object> selectContestIdxByPrjIdx(@RequestBody Map<String, Object> data){
		Map<String, Object> response = new HashMap<String, Object>();
		
		int prj_idx = (int) data.get("prj_idx");
		
		try {
			Integer contest_idx = mapper.selectContestIdxByPrjIdx(prj_idx);
			if(contest_idx != null) {
				response.put("contest_idx", contest_idx);
			} else {
				response.put("contest_idx", null);
			}
		} catch (Exception e) {
			response.put("contest_idx", null);
//			logger.info("An error occurred while fetching contest_idx", e);
		}
		
		return response;
	}
	
	@GetMapping("/{rc_idx}")
    public Map<String, Object> rcDetail(@PathVariable int rc_idx) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Integer> list =  mapper.selectStacksByRcIdx(rc_idx);
		int prj_idx;
		
		try {
			Recruit rc = mapper.selectRcByIdx(rc_idx);
			if(rc != null) {
				response.put("recruit", rc);
				
				if (list != null && !list.isEmpty()) {
					List<String> stackNames = new ArrayList<String>();
					for(int stack_idx : list) {
						String stackName = mapper.selectStackNameByIdx(stack_idx);
						if(stackName != null) {
							stackNames.add(stackName);
						}
					}
					response.put("stackNames", stackNames);
				} else {
					response.put("success", new ArrayList<String>());
				}
				
				prj_idx = rc.getPrj_idx();
				logger.info("prj_idx : {}", prj_idx);
				Integer contest_idx = mapper.selectContestIdxByPrjIdx(prj_idx);
				if(contest_idx != null) {
					logger.info("contest_idx that was taken by prj_idx : {}", contest_idx);
					
					Contest contest = null;
	                try {
	                    contest = mapper.selectContestByContestIdx(contest_idx);
	                    logger.info("contest that was taken by contest_idx : {}", contest.toString());
	                    response.put("contest", contest);
	                } catch (Exception e) {
	                    logger.error("Error while fetching Contest by contest_idx: {}", contest_idx, e);
	                    response.put("contest", null); // 또는 다른 오류 처리
	                }
				} else {
					response.put("contest", null);
				}
			} else {
				response.put("success", false);
			}
			
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", e);
		}
        
		return response;
    }

}
