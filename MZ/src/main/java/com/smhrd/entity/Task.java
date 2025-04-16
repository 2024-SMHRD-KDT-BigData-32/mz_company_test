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
    
	
    private Integer task_idx; // ���� �ĺ��� (PK)
    
    @NonNull
    private Integer prj_idx; // ������Ʈ �ĺ��� (Projects ���̺�� ����)
    
    @NonNull
    private String task_nm; // ���� ��
    
    @NonNull
    private String task_desc; // ���� ����
    
    @NonNull
    private String task_priority; // ���� �켱���� (ENUM: '���', '����', '�߰�', '����', '����')
    
    @NonNull
    private Timestamp task_st_dt; // ���� ���� ����
    
    @NonNull
    private Timestamp task_ed_dt; // ���� ���� ����
    
    @NonNull
    private String task_status; // ���� ó������
    
    
    private String alarm_type; // �˶� ����
    
    
    private Timestamp alarm_time; // �˶� �ð�
    
    private Timestamp created_at; // ��� ����
    
    private Timestamp updated_at; // ���� ����
    
    private Integer super_task; // ���� ���� (SELF JOIN ����)

    private int task_per; 
    
    private String user_id;
    
    private String assignee;
	
}