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

    private Map<Integer, Set<WebSocketSession>> chatRoomSessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper;
    private final ChattingMapper chatMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("접속: " + session.getId());
        Map<String, String> params = getQueryParameters(session.getUri().getQuery());
        int prjIdx = -1;
        if (params.containsKey("prj_idx")) {
            prjIdx = Integer.parseInt(params.get("prj_idx"));
            chatRoomSessions.putIfAbsent(prjIdx, new HashSet<>());
            chatRoomSessions.get(prjIdx).add(session);
            System.out.println("세션 " + session.getId() + "을 채팅방 " + prjIdx + "에 추가");
        } else {
            System.out.println("채팅방 ID가 없어 세션을 추가하지 못했습니다.");
        }
        System.out.println("현재 chatRoomSessions 상태 (접속 후): " + chatRoomSessions);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        for (Map.Entry<Integer, Set<WebSocketSession>> entry : chatRoomSessions.entrySet()) {
            Set<WebSocketSession> sessions = entry.getValue();
            if (sessions.remove(session)) {
                System.out.println("채팅방 " + entry.getKey() + "에서 세션 제거: " + session.getId());
            }
        }
        System.out.println("해제: " + session.getId());
        System.out.println("현재 chatRoomSessions 상태 (해제 후): " + chatRoomSessions);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Chatting chatMessage = objectMapper.readValue(payload, Chatting.class);
        System.out.println("수신 메시지: " + chatMessage);

        int roomId = chatMessage.getCroom_idx();

        chatRoomSessions.putIfAbsent(roomId, new HashSet<>());
        Set<WebSocketSession> sessions = chatRoomSessions.get(roomId);

        System.out.println("채팅방 " + roomId + "의 현재 세션 목록 (메시지 처리 전): " + sessions);

        if (chatMessage.getMessageType() == Chatting.MessageType.ENTER) {
            if (sessions.size() < 5) {
                sessions.add(session);
                chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
                chatMapper.messageSave(chatMessage);
                System.out.println("세션 " + session.getId() + "을 채팅방 " + roomId + "에 추가 (ENTER)");
            } else {
                session.sendMessage(new TextMessage("채팅방이 가득 찼습니다."));
                return;
            }
        } else if (chatMessage.getMessageType() == Chatting.MessageType.QUIT) {
            sessions.remove(session);
            chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
            chatMapper.messageSave(chatMessage);
            System.out.println("세션 " + session.getId() + "을 채팅방 " + roomId + "에서 제거 (QUIT)");
        } else if (chatMessage.getMessageType() == Chatting.MessageType.TALK) {
            chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
            chatMapper.messageSave(chatMessage);
        }

        String broadcastMsg = objectMapper.writeValueAsString(chatMessage);
        System.out.println("채팅방 " + roomId + "에 브로드캐스팅할 메시지: " + broadcastMsg);
        System.out.println("채팅방 " + roomId + "의 현재 세션 목록 (브로드캐스팅 전): " + sessions);
        for (WebSocketSession ws : sessions) {
            try {
                System.out.println("세션 " + ws.getId() + "에 메시지 전송 시도");
                ws.sendMessage(new TextMessage(broadcastMsg));
                System.out.println("세션 " + ws.getId() + "에 메시지 전송 성공");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("채팅방 " + roomId + "의 현재 세션 목록 (브로드캐스팅 후): " + sessions);
    }

    private Map<String, String> getQueryParameters(String query) {
        Map<String, String> params = new HashMap<>();
        if (query != null && !query.isEmpty()) {
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] parts = pair.split("=");
                if (parts.length == 2) {
                    params.put(parts[0], parts[1]);
                }
            }
        }
        return params;
    }
}