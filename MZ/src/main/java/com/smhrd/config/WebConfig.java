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
        registry.addMapping("/api/**")  // "/api"�� �����ϴ� ��� ��û ���
                .allowedOrigins("http://localhost:3000")  // React ���� ����
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // ����� HTTP �޼���
                .allowCredentials(true)  // ���� ���� ���� ��û ��� (JWT, ��Ű ��)
                .allowedHeaders("*");  // ��� ��� ���
    }
}
