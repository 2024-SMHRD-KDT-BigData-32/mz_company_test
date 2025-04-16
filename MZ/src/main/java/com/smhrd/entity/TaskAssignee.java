package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskAssignee {
    
	@NonNull
    private Integer assignIdx; // 할당 식별자
    
    @NonNull
    private Integer taskIdx; // 업무 식별자
    
    @NonNull
    private String userId; // 사용자 아이디
    
}
