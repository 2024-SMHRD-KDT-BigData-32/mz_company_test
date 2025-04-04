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
public class Chatting {
    
	@NonNull 
    private Integer chatIdx; // 대화 식별자
    
    @NonNull 
    private Integer croomIdx; // 방 식별자
    
    @NonNull 
    private String chatter; // 발화자
    
    private String chatContent; // 발화 내용
    
    private String chatEmoticon; // 발화 이모티콘
    
    private String chatFile; // 발화 파일
    
    private Timestamp createdAt; // 발화 시간
}
