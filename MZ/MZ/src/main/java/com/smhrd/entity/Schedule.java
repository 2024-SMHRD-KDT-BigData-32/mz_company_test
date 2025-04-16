package com.smhrd.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Schedule {
	
	private Integer sche_idx;  // null ��� (�ڵ� ������ ����)
    @NonNull private Integer prj_idx;  // FK
    @NonNull private String sche_nm;  // ������ ����
    private String sche_desc;  // ������ ���� (null ���)
    @NonNull private Timestamp st_dt;
    @NonNull private Timestamp ed_dt;
    private Timestamp created_at;  // ���� �ð�
    private Timestamp updated_at;   // ������ ��� ���� �ð�
    @NonNull private String sche_status;  // ������ ����
    @NonNull private String sche_color;  // ������ ����

    
}