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
    private Integer prj_idx; // ������Ʈ �ĺ��� (PK)
    
    @NonNull
    private String prj_nm; // ������Ʈ ��

    @NonNull 
    private String prj_desc; // ������Ʈ ����

    @NonNull 
    private String user_id; // ������ ���̵� (Users ���̺�� ����)

    private Integer contest_idx; 
     

    @NonNull 
    private Timestamp created_at; // ��� ��¥
    
    private Timestamp updated_at; // ���� ��¥


}

