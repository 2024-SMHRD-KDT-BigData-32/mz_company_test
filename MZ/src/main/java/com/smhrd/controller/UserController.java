package com.smhrd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.TechStack;
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
//		logger.info("Session ID: " + session.getId());
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		String loggedInUserNm = (String) session.getAttribute("loggedInUserNm");

		if (loggedInUserNm != null) {
			response.put("loggedIn", true);
			response.put("user_id", loggedInUserId);
			response.put("user_nm", loggedInUserNm);
		} else {
			response.put("loggedIn", false);
			response.put("user_id", null);
			response.put("user_nm", null);
		}
		return response;
	}

	@PostMapping("/join")
	public int join(@RequestBody User user) {
		User check = userMapper.select(user);

		int result = 0;
		if (check != null) {
			result = -1;
		} else {
			result = userMapper.join(user);
		}
		return result;
	}

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody Map<String, String> credentials, HttpSession session) {
		logger.info("userId: {}", credentials.get("user_id"));
		logger.info("userPw: {}", credentials.get("user_pw"));
		String userId = credentials.get("user_id");
		String userPw = credentials.get("user_pw");

		User user = userMapper.getUserByIdPw(userId, userPw);

		Map<String, Object> response = new HashMap<String, Object>();
		if (user != null && user.getUser_pw().equals(userPw)) {
			session.setAttribute("loggedInUserId", user.getUser_id());
			session.setAttribute("loggedInUserNm", user.getUser_nm());
			logger.info("Session ID: " + session.getId());
			response.put("success", true);
			response.put("user_id", user.getUser_id());
			response.put("user_nm", user.getUser_nm());
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

   
   // 프로필 수정 부분
   @GetMapping("/{user_id}")
   public ResponseEntity<?> getUserProfile(@PathVariable String user_id) {
       User user = userMapper.findUserById(user_id);
       List<TechStack> userStacks = userMapper.findStacksByUserId(user_id);
       List<TechStack> allStacks = userMapper.findAllStacks();

       Map<String, Object> response = new HashMap<>();
       response.put("user", user);
       response.put("userStacks", userStacks);
       response.put("allStacks", allStacks);

       return ResponseEntity.ok(response);
   }

   @PostMapping("/updateProfile")
   public ResponseEntity<?> updateUserProfile(@RequestBody Map<String, Object> payload) {
       String user_id = (String) payload.get("user_id");
       String user_nm = (String) payload.get("user_nm");
       String newPw = (String) payload.get("user_pw"); // optional
       List<String> skills = (List<String>) payload.get("skills");

       User user = new User();
       user.setUser_id(user_id);
       user.setUser_nm(user_nm);
       if (newPw != null && !newPw.isEmpty()) {
           user.setUser_pw(newPw);
       }

       userMapper.updateUser(user);
       userMapper.deleteStacksByUserId(user_id);

       List<TechStack> allStacks = userMapper.findAllStacks();
       if (skills != null) {
           for (String skillName : skills) {
               for (TechStack stack : allStacks) {
                   if (stack.getStack_nm().equals(skillName)) {
                       userMapper.insertUserStack(user_id, stack.getStack_idx());
                   }
               }
           }
       }

       return ResponseEntity.ok("Profile updated successfully");
   }


}
