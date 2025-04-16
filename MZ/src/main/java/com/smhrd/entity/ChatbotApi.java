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
public class ChatbotApi {
    
    @NonNull 
    private Integer apiIdx; // ê�� �ĺ��� (PK)
    
    @NonNull 
    private String apiUrl; // API �ּ�
    
    @NonNull 
    private String apiReq; // ����
    
    @NonNull 
    private String apiRes; // ����
    
    @NonNull 
    private Timestamp createdAt; // ���� �ð�
    
    private String apiFile; // ����
    
    @NonNull 
    private String adminId; // ������ ���̵�
}
