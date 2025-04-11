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
	
	private Integer sche_idx;  // null 허용 (자동 생성을 위해)
    @NonNull private Integer prj_idx;  // FK
    @NonNull private String sche_nm;  // 스케쥴 제목
    private String sche_desc;  // 스케쥴 내용 (null 허용)
    @NonNull private Timestamp st_dt;
    @NonNull private Timestamp ed_dt;
    private Timestamp created_at;  // 생성 시간
    private Timestamp updated_at;   // 수정할 경우 수정 시간
    @NonNull private String sche_status;  // 스케쥴 상태
    @NonNull private String sche_color;  // 스케쥴 색상

    
}