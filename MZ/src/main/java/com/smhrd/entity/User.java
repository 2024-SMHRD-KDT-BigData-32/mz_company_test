
package com.smhrd.entity;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @NonNull
    private String user_id;      

    @NonNull
    private String user_pw;     
    @NonNull
    private String user_nm;      
    @NonNull
    private Date user_birthdate; 
    
    private String user_role;    
    
    private Timestamp joined_at;  
}