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
    private Integer assignIdx; // �Ҵ� �ĺ���
    
    @NonNull 
    private Integer scheIdx; // ������ �ĺ���
    
    @NonNull 
    private String userId; // ����� ���̵�
}
