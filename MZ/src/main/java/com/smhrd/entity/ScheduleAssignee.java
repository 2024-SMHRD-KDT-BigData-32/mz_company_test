package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScheduleAssignee {

	@NonNull 
    private Integer assignIdx; // 할당 식별자
    
    @NonNull 
    private Integer scheIdx; // 스케줄 식별자
    
    @NonNull 
    private String userId; // 사용자 아이디
}
