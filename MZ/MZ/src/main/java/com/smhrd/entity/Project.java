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
   
    private Integer prj_idx; 
    
    @NonNull
    private String prj_nm;   
    
    @NonNull 
    private String prj_desc; 
    
    @NonNull
    private String user_id; 
    
    private Integer contest_idx; 
     
    private Timestamp created_at; 
    
    private Timestamp updated_at; 
}

