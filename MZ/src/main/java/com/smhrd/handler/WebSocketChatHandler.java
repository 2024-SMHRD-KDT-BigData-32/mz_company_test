package com.smhrd.handler;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.entity.Chatting;
import com.smhrd.mapper.ChattingMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebSocketChatHandler extends TextWebSocketHandler {

	// room_id별로 연결된 클라이언트 세션 관리 - Integer 타입으로 통일
    private Map<Integer, Set<WebSocketSession>> chatRoomSessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper;
    private final ChattingMapper chatMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속: " + session.getId());
        // 단순 소켓 연결 시점에는 아직 어떤 채팅방인지 모름 (메시지를 통해 알게 됨)
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 모든 채팅방에서 해당 세션 제거
        for (Map.Entry<Integer, Set<WebSocketSession>> entry : chatRoomSessions.entrySet()) {
            Set<WebSocketSession> sessions = entry.getValue();
            if (sessions.remove(session)) {
                System.out.println("채팅방 " + entry.getKey() + "에서 세션 제거: " + session.getId());
            }
        }
        System.out.println("해제: " + session.getId());
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Chatting chatMessage = objectMapper.readValue(payload, Chatting.class);
        System.out.println("수신 메시지: " + chatMessage);
        
        int roomId = chatMessage.getCroom_idx();
        
        // 해당 roomId의 세션 집합이 없으면 새로 생성
        chatRoomSessions.putIfAbsent(roomId, new HashSet<>());
        Set<WebSocketSession> sessions = chatRoomSessions.get(roomId);
        
        if (chatMessage.getMessageType() == Chatting.MessageType.ENTER) {
            // 5명까지만 입장 허용
            if (sessions.size() < 5) {
                sessions.add(session);
                // 입장 메시지도 DB에 저장할 경우
                chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
                chatMapper.messageSave(chatMessage);
            } else {
                session.sendMessage(new TextMessage("채팅방이 가득 찼습니다."));
                return;
            }
        } else if (chatMessage.getMessageType() == Chatting.MessageType.QUIT) {
            sessions.remove(session);
            // 퇴장 메시지도 DB에 저장할 경우
            chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
            chatMapper.messageSave(chatMessage);
        } else if (chatMessage.getMessageType() == Chatting.MessageType.TALK) {
            // TALK 메시지 처리: 서버에서 created_at 값을 설정 후 DB 저장
            chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
            chatMapper.messageSave(chatMessage);
        }

        
        // 모든 세션에 업데이트된 메시지 브로드캐스트 (서버에서 수정된 메시지를 보내도록)
        String broadcastMsg = objectMapper.writeValueAsString(chatMessage);
        for (WebSocketSession ws : sessions) {
            try {
                ws.sendMessage(new TextMessage(broadcastMsg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
