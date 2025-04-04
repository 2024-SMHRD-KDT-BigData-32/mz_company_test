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
    private Integer taskIdx; // ���� �ĺ��� (PK)
    
    @NonNull
    private Integer prjIdx; // ������Ʈ �ĺ��� (Projects ���̺�� ����)
    
    @NonNull
    private String taskNm; // ���� ��
    
    @NonNull
    private String taskDesc; // ���� ����
    
    @NonNull
    private String taskPriority; // ���� �켱���� (ENUM: '���', '����', '�߰�', '����', '����')
    
    @NonNull
    private Timestamp taskStDt; // ���� ���� ����
    
    @NonNull
    private Timestamp taskEdDt; // ���� ���� ����
    
    @NonNull
    private String taskStatus; // ���� ó������
    
    @NonNull
    private String alarmType; // �˶� ����
    
    @NonNull
    private Timestamp alarmTime; // �˶� �ð�
    
    @NonNull
    private Timestamp createdAt; // ��� ����
    
    @NonNull
    private Timestamp updatedAt; // ���� ����
    
    private Integer superTask; // ���� ���� (SELF JOIN ����)
}
