package com.smhrd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  
                .allowedOrigins("http://localhost:3000")  
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") 
                .allowCredentials(true)  
                .allowedHeaders("*");  
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 실제 로컬 저장 경로를 웹에서 접근 가능하게 함
        registry.addResourceHandler("/resources/workFile/**")
        		.addResourceLocations("file:" + System.getProperty("user.dir") + "/src/main/webapp/resources/workFile/");    }
}