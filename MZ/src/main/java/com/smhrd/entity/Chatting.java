package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Chatting {
    
    private Integer chat_idx; // 대화 식별자
    
    private Integer croom_idx; // 방 식별자
    
    @NonNull 
    private String chatter; // 대화자
    
    private String chat_content; // 대화 내용
    
    private String chat_emoticon; // 대화 이모티콘
    
    private String chat_file; // 대화 파일
    
    private Timestamp created_at; // 대화 시간
    
    private String file_url;  // 파일 경로
    
    // 메시지 타입 필드 추가
    private String messageType; // ENTER, QUIT, TALK
    
    // 메시지 타입 상수 정의
    public static class MessageType {
        public static final String ENTER = "ENTER";
        public static final String QUIT = "QUIT";
        public static final String TALK = "TALK";
    }
}