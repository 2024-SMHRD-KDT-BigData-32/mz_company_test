package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contest {
   
	@NonNull
    private Integer contestIdx; // ������ �ĺ��� (PK)
    
    @NonNull
    private String title; // ������ ����
    
    @NonNull
    private String content; // ������ ����
    
    @NonNull
    private String hostOrg; // ���� ���
    
    @NonNull
    private String category; // ������ �о�
    
    @NonNull
    private String appMethod; // ���� ���
    
    @NonNull
    private Timestamp stDt; // ���� ���� ��¥
    
    @NonNull
    private Timestamp edDt; // ���� ���� ��¥
    
    @NonNull
    private String appQualification; // ���� �ڰ�
    
    @NonNull
    private String posterImg; // ������ �̹��� URL
    
    @NonNull
    private String prize; // �û�� ����
}
