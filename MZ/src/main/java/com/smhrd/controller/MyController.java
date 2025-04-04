package com.smhrd.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {
   
   @GetMapping("/test")  // GET 요청만 받도록 명확히 변경
   public String sayHello() {
      return "Hello from Spring";
   }
   
   @PostMapping("/send") // POST 요청을 명확히 지정
   public String receiveData(@RequestBody Map<String, String> data) {
       String receivedMessage = data.get("message2");
       System.out.println("Received from React: " + receivedMessage);
       return "Data received: " + receivedMessage;
   }
}
