package com.smhrd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Notification;
import com.smhrd.mapper.NotificationMapper;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

	@Autowired
	private NotificationMapper mapper;

	@PostMapping("/check")
	public Map<String, Object> checkNotification(@RequestBody Map<String, Object> data) {
		Map<String, Object> response = new HashMap<String, Object>();

		String userId = (String) data.get("user_id");
		List<Notification> notifyList = mapper.selectNotifyByUserId(userId);
		response.put("notification", notifyList);

		return response;
	}

	@PostMapping("/read")
	public Map<String, Object> readNotification(@RequestBody Map<String, Object> notificationData) {
		Map<String, Object> response = new HashMap<String, Object>();

		Integer notification_idx = (Integer) notificationData.get("notification_idx");
		boolean is_read = (boolean) notificationData.get("is_read");
		boolean updated = false;
		try {
			updated = mapper.updateNotification(notification_idx, is_read);
			logger.info("Update Result (Controller): {}", updated);
			if (updated) {
				response.put("success", true);
			}
		} catch (Exception e) {
			response.put("error", e);
		}
		return response;
	}
}
