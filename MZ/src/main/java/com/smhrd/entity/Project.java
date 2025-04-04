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
public class Project {
    
	@NonNull
    private Integer prjIdx; // 프로젝트 식별자 (PK)
    
    @NonNull
    private String prjNm; // 프로젝트 명
    
    @NonNull 
    private String prjDesc; // 프로젝트 설명
    
    @NonNull 
    private String userId; // 개설자 아이디 (Users 테이블과 관계)
    
    private Integer contestIdx; // 공모전 식별자 (Contests 테이블과 관계)
    
    @NonNull 
    private Timestamp createdAt; // 등록 날짜
    
    private Timestamp updatedAt; // 수정 날짜
}

