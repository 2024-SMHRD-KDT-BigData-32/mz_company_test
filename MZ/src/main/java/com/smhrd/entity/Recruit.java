package com.smhrd.entity;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Recruit {
	
    private Integer rc_idx;

    @NonNull
    private Integer prj_idx; 

    @NonNull
    private String rc_title; 

    @NonNull
    private String rc_content;

    @NonNull
    private String user_id; 

    @NonNull
    private Timestamp closed_at;
    	
    
    private Timestamp created_at;
    
    private List<String> stacks;
}
