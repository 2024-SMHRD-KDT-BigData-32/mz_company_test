package com.smhrd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.smhrd.handler.WebSocketChatHandler;
import lombok.RequiredArgsConstructor;


@Configuration //설정파일
@EnableWebSocket //웹소켓 활성화
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
	
	@Autowired
	private final WebSocketChatHandler webSocketChatHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//EndPoint : 서비스의 끝자락(핸드폰/PC) / WebSocket 에서는 URI(경로)의 끝자락
		// => 채팅을 하기위해서 접근해야하는 URL /  localhost:8090/myapp/ws/chat
		//setAllowedOrigins : CORS 설정 -> 접근 권한 부여
		// EndPoint 설정: /ws/chat
        // CORS 설정: 모든 출처 허용
		// registry.addHandler(webSocketChatHandler, "/ws/chat").setAllowedOrigins("*");
		registry.addHandler(webSocketChatHandler, "/websocket/chat/{project_idx}")
        .setAllowedOrigins("*"); // 실제 환경에서는 특정 도메인만 허용하는 것이 좋습니다
	}
}

