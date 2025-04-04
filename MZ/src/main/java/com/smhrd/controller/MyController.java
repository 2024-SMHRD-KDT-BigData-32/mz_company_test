package com.smhrd.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
   
   @GetMapping("/test")  // GET ��û�� �޵��� ��Ȯ�� ����
   public String sayHello() {
      return "Hello from Spring";
   }
   
   @PostMapping("/send") // POST ��û�� ��Ȯ�� ����
   public String receiveData(@RequestBody Map<String, String> data) {
       String receivedMessage = data.get("message2");
       System.out.println("Received from React: " + receivedMessage);
       return "Data received: " + receivedMessage;
   }
}
