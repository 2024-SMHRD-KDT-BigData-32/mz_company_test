package com.smhrd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // "/api"로 시작하는 모든 요청 허용
                .allowedOrigins("http://localhost:3000")  // React 개발 서버
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
                .allowCredentials(true)  // 인증 정보 포함 요청 허용 (JWT, 쿠키 등)
                .allowedHeaders("*");  // 모든 헤더 허용
    }
}
