package com.smhrd.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Joining;
import com.smhrd.entity.Notification;
import com.smhrd.entity.Recruit;
import com.smhrd.mapper.JoiningMapper;
import com.smhrd.mapper.NotificationMapper;
import com.smhrd.mapper.RecruitMapper;

@RestController
@RequestMapping("/joining")
public class JoiningController {

	private static final Logger logger = LoggerFactory.getLogger(JoiningController.class);

	@Autowired
	private JoiningMapper mapper;

	@Autowired
	private RecruitMapper recruitMapper;

	@Autowired
	private NotificationMapper notificationMapper;

	@PostMapping("/participate")
	public Map<String, Object> participate(@RequestBody Joining joiningData) {
		Map<String, Object> response = new HashMap<String, Object>();

		String user_id = joiningData.getUser_id();
		Integer rc_idx = joiningData.getRc_idx();

		try {
			mapper.insertJoining(joiningData);
			Integer join_idx = joiningData.getJoin_idx();
			Recruit recruit = recruitMapper.selectRcByIdx(rc_idx);

			if (join_idx != null) {
				if (recruit != null) {
					String rc_title = recruit.getRc_title();
					String writerId = recruit.getUser_id();

					Notification notification = new Notification();
					notification.setUser_id(writerId);
					notification.setNotification_type("app_participate");
					notification.setEntity_idx(join_idx);
					notification.setMessage(user_id + " applied to  '" + rc_title + "' .");
					notification.setSender_id(user_id);
					notificationMapper.insertNotification(notification);
				}

			}
		} catch (Exception e) {
			response.put("succes", false);
			logger.info("Error ouccurred while insertJoining : {}", e);
		}

		return response;
	}

	@PostMapping("/approval")
	public Map<String, Object> setApproval(@RequestBody Map<String, Object> data) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		Integer notification_idx = (Integer) data.get("notification_idx");
		String notification_type = (String) data.get("notification_type");
		Integer join_idx = (Integer) data.get("entity_idx");
		String approval_yn_str = (String) data.get("approval_yn");
		Character approval_yn = approval_yn_str.charAt(0);
		String rc_role = (String) data.get("rc_role");
		
		String user_id = (String) data.get("user_id");
		String sender_id = (String) data.get("sender_id");
		
		Notification notification = new Notification();
				
		try {
			Integer rc_idx = mapper.getRcIdxByJoinIdx(join_idx);
			String rc_title = recruitMapper.getRcTitleByIdx(rc_idx);
			
			if(approval_yn.equals('Y')) {
				boolean isUpdated = mapper.updateJoining(join_idx, approval_yn, rc_role);
				notification.setUser_id(user_id);
				notification.setNotification_type("app_participate_approval");
				notification.setEntity_idx(join_idx);
				notification.setMessage("Your application for '" + rc_title + "' was approved!");
				notification.setSender_id(sender_id);
				notificationMapper.insertNotification(notification);

			} else {
				boolean isJoiningDeleted = mapper.deleteJoining(join_idx);
			}
			response.put("success", true);
			boolean isNotificationDeleted = notificationMapper.deleteNotification(notification_idx);
			
		} catch (Exception e) {
			response.put("success", false);
			logger.error("Error occurred during approval process:", e);
		}
		
		
		return response;
	}
	
	@PostMapping("/check")
	public Map<String, Object> checkApplied(@RequestBody Map<String, Object> data){
		Map<String, Object> response = new HashMap<String, Object>();
		
		String user_id = (String) data.get("user_id");
		Integer rc_idx = (Integer) data.get("rc_idx");
		try {
			boolean isApplied = mapper.checkApplied(user_id, rc_idx);
			response.put("applied", isApplied);
		} catch (Exception e) {
			logger.info("{}", e);
		}
		return response;
	}

}
