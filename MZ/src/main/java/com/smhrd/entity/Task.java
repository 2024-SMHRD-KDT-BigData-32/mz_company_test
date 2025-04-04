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
public class Task {
    
	@NonNull
    private Integer taskIdx; // 업무 식별자 (PK)
    
    @NonNull
    private Integer prjIdx; // 프로젝트 식별자 (Projects 테이블과 관계)
    
    @NonNull
    private String taskNm; // 업무 명
    
    @NonNull
    private String taskDesc; // 업무 설명
    
    @NonNull
    private String taskPriority; // 업무 우선순위 (ENUM: '긴급', '높음', '중간', '낮음', '보류')
    
    @NonNull
    private Timestamp taskStDt; // 업무 시작 일자
    
    @NonNull
    private Timestamp taskEdDt; // 업무 마감 일자
    
    @NonNull
    private String taskStatus; // 업무 처리상태
    
    @NonNull
    private String alarmType; // 알람 구분
    
    @NonNull
    private Timestamp alarmTime; // 알람 시간
    
    @NonNull
    private Timestamp createdAt; // 등록 일자
    
    @NonNull
    private Timestamp updatedAt; // 수정 일자
    
    private Integer superTask; // 상위 업무 (SELF JOIN 관계)
}
