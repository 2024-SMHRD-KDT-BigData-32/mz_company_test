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

	// room_id蹂꾨줈 �뿰寃곕맂 �겢�씪�씠�뼵�듃 �꽭�뀡 愿�由� - Integer ���엯�쑝濡� �넻�씪
    private Map<Integer, Set<WebSocketSession>> chatRoomSessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper;
    private final ChattingMapper chatMapper;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("�젒�냽: " + session.getId());
        // �떒�닚 �냼耳� �뿰寃� �떆�젏�뿉�뒗 �븘吏� �뼱�뼡 梨꾪똿諛⑹씤吏� 紐⑤쫫 (硫붿떆吏�瑜� �넻�빐 �븣寃� �맖)
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 紐⑤뱺 梨꾪똿諛⑹뿉�꽌 �빐�떦 �꽭�뀡 �젣嫄�
        for (Map.Entry<Integer, Set<WebSocketSession>> entry : chatRoomSessions.entrySet()) {
            Set<WebSocketSession> sessions = entry.getValue();
            if (sessions.remove(session)) {
                System.out.println("梨꾪똿諛� " + entry.getKey() + "�뿉�꽌 �꽭�뀡 �젣嫄�: " + session.getId());
            }
        }
        System.out.println("�빐�젣: " + session.getId());
    }
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Chatting chatMessage = objectMapper.readValue(payload, Chatting.class);
        System.out.println("�닔�떊 硫붿떆吏�: " + chatMessage);
        
        int roomId = chatMessage.getCroom_idx();
        
        // �빐�떦 roomId�쓽 �꽭�뀡 吏묓빀�씠 �뾾�쑝硫� �깉濡� �깮�꽦
        chatRoomSessions.putIfAbsent(roomId, new HashSet<>());
        Set<WebSocketSession> sessions = chatRoomSessions.get(roomId);
        
        if (chatMessage.getMessageType() == Chatting.MessageType.ENTER) {
            // 5紐낃퉴吏�留� �엯�옣 �뿀�슜
            if (sessions.size() < 5) {
                sessions.add(session);
                // �엯�옣 硫붿떆吏��룄 DB�뿉 ���옣�븷 寃쎌슦
                chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
                chatMapper.messageSave(chatMessage);
            } else {
                session.sendMessage(new TextMessage("梨꾪똿諛⑹씠 媛��뱷 李쇱뒿�땲�떎."));
                return;
            }
        } else if (chatMessage.getMessageType() == Chatting.MessageType.QUIT) {
            sessions.remove(session);
            // �눜�옣 硫붿떆吏��룄 DB�뿉 ���옣�븷 寃쎌슦
            chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
            chatMapper.messageSave(chatMessage);
        } else if (chatMessage.getMessageType() == Chatting.MessageType.TALK) {
            // TALK 硫붿떆吏� 泥섎━: �꽌踰꾩뿉�꽌 created_at 媛믪쓣 �꽕�젙 �썑 DB ���옣
            chatMessage.setCreated_at(new Timestamp(System.currentTimeMillis()));
            chatMapper.messageSave(chatMessage);
        }

        
        // 紐⑤뱺 �꽭�뀡�뿉 �뾽�뜲�씠�듃�맂 硫붿떆吏� 釉뚮줈�뱶罹먯뒪�듃 (�꽌踰꾩뿉�꽌 �닔�젙�맂 硫붿떆吏�瑜� 蹂대궡�룄濡�)
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
