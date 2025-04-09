package com.smhrd.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.entity.Chatting;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//소켓 통신 : 1(서버) : N(클라이언트) 관계
//한 서버에서 여러 클라이언트가 발송한 메시지를 받아 처리해주는 역할 -> Handler (접속, 접속해제, 메시지처리)
//Spring 5버전 이상에 버전을 사용시에는 @RequiredArgsConstructor 를 쓰는 것을 권장
//Autowired => 순환 참조 방지 
//final 지원 => 값이 마음대로 변경되지 않도록 막을 수 있음
@Component //따로 객체(bean)를 등록할 필요 없이 객체(bean) 생성 어노테이션
@RequiredArgsConstructor //초기화가 되지 않은 필드 초기화하는 생성자 만들어 줌 -> objectMapper 객체 생성(@Autowired
public class WebSocketChatHandler extends TextWebSocketHandler {
	
    // 현재까지 접속한 모든 클라이언트 정보 저장 Set
    private Set<WebSocketSession> sessions = new HashSet<>();
    
    // 각 채팅 룸별(key) 클라이언트 정보 따로 저장 
    private Map<Integer, Set<WebSocketSession>> chatRoomSessions = new HashMap<>();
    
    private final ObjectMapper objectMapper;
    
//    afterConnectionEstablished(WebSocketSession session): 클라이언트와의 연결이 수립된 후에 호출됩니다.

    
//    @Override    // : 클라이언트로부터 메시지를 수신했을 때 호출됩니다.
//	public void  handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
//    } 

//    handleTransportError(WebSocketSession session, Throwable exception): 전송 오류가 발생했을 때 호출됩니다.

//    afterConnectionClosed(WebSocketSession session, CloseStatus status): 클라이언트와의 연결이 끊어졌을 때 호출됩니다.
    
    // 클라이언트 접속 시 호출
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("접속 : " + session.getId());
    }
    
    // 클라이언트 접속 해제 시 호출
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        
        // 모든 채팅방에서 해당 세션 제거
        for (Set<WebSocketSession> roomSessions : chatRoomSessions.values()) {
            roomSessions.remove(session);
        }
        
        System.out.println("해제 : " + session.getId());
    }
    
    // 메세지 처리
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트가 보낸 메세지 확인하기
        String payload = message.getPayload();
        // String -> Java Class(Chatting) 형태로 변환
        Chatting chatMessage = objectMapper.readValue(payload, Chatting.class);
        System.out.println(chatMessage.toString());
        
        Integer croom_idx = chatMessage.getCroom_idx();
        
        // 해당 채팅방이 MAP에 등록되어 있지 않으면 추가
        if (!chatRoomSessions.containsKey(croom_idx)) {
            chatRoomSessions.put(croom_idx, new HashSet<>());
        }
        
        // 채팅방에 접속된 클라이언트 정보 저장해놓은 set 가져오기
        Set<WebSocketSession> chatRoomSession = chatRoomSessions.get(croom_idx);
        
        // 메시지 타입에 따른 처리
        if (chatMessage.getMessageType() != null) {
            if (chatMessage.getMessageType().equals("ENTER")) {
                chatRoomSession.add(session);
            } else if (chatMessage.getMessageType().equals("QUIT")) {
                chatRoomSession.remove(session);
            }
        }
        
        // 해당 채팅방에 있는 모든 클라이언트에게 메시지 전송
        chatRoomSession.parallelStream().forEach(cSession -> {
            try {
                cSession.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}




