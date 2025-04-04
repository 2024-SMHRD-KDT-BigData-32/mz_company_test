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
    private Integer prjIdx; // ������Ʈ �ĺ��� (PK)
    
    @NonNull
    private String prjNm; // ������Ʈ ��
    
    @NonNull 
    private String prjDesc; // ������Ʈ ����
    
    @NonNull 
    private String userId; // ������ ���̵� (Users ���̺�� ����)
    
    private Integer contestIdx; // ������ �ĺ��� (Contests ���̺�� ����)
    
    @NonNull 
    private Timestamp createdAt; // ��� ��¥
    
    private Timestamp updatedAt; // ���� ��¥
}

