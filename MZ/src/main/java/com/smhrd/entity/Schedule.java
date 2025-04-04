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
	
    @NonNull private String sche_idx;
    @NonNull private String prj_idx;  // FK
    @NonNull private String sche_nm;
    @NonNull private String sche_desc;
    @NonNull private Timestamp st_dt;
    @NonNull private Timestamp ed_dt;
    private Timestamp create_at;
    private Timestamp updated_at;  
    @NonNull private String sche_status;  // 스케쥴 상태
    @NonNull private String sche_color;  // 스케쥴 색상
	 

    
}
