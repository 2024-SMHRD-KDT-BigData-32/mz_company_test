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
    private Integer assignIdx; // �Ҵ� �ĺ���
    
    @NonNull
    private Integer taskIdx; // ���� �ĺ���
    
    @NonNull
    private String userId; // ����� ���̵�
    
}
