package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest {
   
	@NonNull
    private Integer contestIdx; // 공모전 식별자 (PK)
    
    @NonNull
    private String title; // 공모전 제목
    
    @NonNull
    private String content; // 공모전 내용
    
    @NonNull
    private String hostOrg; // 주최 기관
    
    @NonNull
    private String category; // 공모전 분야
    
    @NonNull
    private String appMethod; // 접수 방법
    
    @NonNull
    private Timestamp stDt; // 접수 시작 날짜
    
    @NonNull
    private Timestamp edDt; // 접수 마감 날짜
    
    @NonNull
    private String appQualification; // 참가 자격
    
    @NonNull
    private String posterImg; // 포스터 이미지 URL
    
    @NonNull
    private String prize; // 시상금 정보
}
