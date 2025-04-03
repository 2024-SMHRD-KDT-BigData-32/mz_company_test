package com.smhrd.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
	

	@RequestMapping("/test")
	public String sayHello() {
		String i = "4444";
		return i;
	}
	
	@RequestMapping("/send")
    public String receiveData(@RequestBody Map<String, String> data) {
        String receivedMessage = data.get("message2");
        System.out.println("Received from React: " + receivedMessage);
        return " 나는 김현수다 : " + receivedMessage;
    }
	
	@PostMapping("/register")
	public String Register() {
		
		
		return null;
	}
}
