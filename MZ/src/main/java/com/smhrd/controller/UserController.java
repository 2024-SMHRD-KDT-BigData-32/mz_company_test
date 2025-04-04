package com.smhrd.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.User;
import com.smhrd.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {

   private static final Logger logger = LoggerFactory.getLogger(UserController.class);

   @Autowired
   private UserMapper userMapper;

   @GetMapping("/session-info")
   public Map<String, Object> getSessionInfo(HttpSession session) {
      Map<String, Object> response = new HashMap<String, Object>();
      logger.info("Session ID: " + session.getId());
      String loggedInUserNm = (String) session.getAttribute("loggedInUserNm");

      if (loggedInUserNm != null) {
         response.put("loggedIn", true);
         response.put("userNm", loggedInUserNm);
      } else {
         response.put("loggedIn", false);
         response.put("userNm", null);
      }
      return response;
   }
   
   @PostMapping("/join")
	public int join(@RequestBody User user) { 
		User check = userMapper.select(user);
		
		int result = 0;
		if(check != null) {
			result = -1;
		}
		else {
			result = userMapper.join(user);	
		}
		return result;
	}
	
   
   @PostMapping("/login")
   public Map<String, Object> login(@RequestBody Map<String, String> credentials, HttpSession session) {
      logger.info("userId: {}", credentials.get("userId"));
      logger.info("userPw: {}", credentials.get("userPw"));
      String userId = credentials.get("userId");
      String userPw = credentials.get("userPw");

      User user = userMapper.getUserByIdPw(userId, userPw);

      Map<String, Object> response = new HashMap<String, Object>();
      if (user != null && user.getUser_pw().equals(userPw)) {
         session.setAttribute("loggedInUserNm", user.getUser_nm());
         logger.info("Session ID: " + session.getId());
         response.put("success", true);
         response.put("userNm", user.getUser_nm());
      } else {
         response.put("success", false);
         response.put("message", "아이디 또는 비밀번호를 확인해주세요.");
      }
      return response;
   }

   @PostMapping("/logout")
   public Map<String, Object> logout(HttpSession session) {
      Map<String, Object> response = new HashMap<String, Object>();
      if (session != null) {
         try {
            session.invalidate();
            response.put("isLogout", true);
         } catch (Exception e) {
            logger.error("세션 무효화 중 오류 발생: {}", e.getMessage());
            response.put("isLogout", false);
         }
      } else {
         response.put("isLogout", false);
      }
      
      return response;
   }

}
