package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class ChatbotApi {
    
    @NonNull 
    private Integer apiIdx; // 챗봇 식별자 (PK)
    
    @NonNull 
    private String apiUrl; // API 주소
    
    @NonNull 
    private String apiReq; // 질의
    
    @NonNull 
    private String apiRes; // 응답
    
    @NonNull 
    private Timestamp createdAt; // 질의 시간
    
    private String apiFile; // 파일
    
    @NonNull 
    private String adminId; // 관리자 아이디
}
