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
public class Chatting {
    
	@NonNull 
    private Integer chatIdx; // ��ȭ �ĺ���
    
    @NonNull 
    private Integer croomIdx; // �� �ĺ���
    
    @NonNull 
    private String chatter; // ��ȭ��
    
    private String chatContent; // ��ȭ ����
    
    private String chatEmoticon; // ��ȭ �̸�Ƽ��
    
    private String chatFile; // ��ȭ ����
    
    private Timestamp createdAt; // ��ȭ �ð�
}
