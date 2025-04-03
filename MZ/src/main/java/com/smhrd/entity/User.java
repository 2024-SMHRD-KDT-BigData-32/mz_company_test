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
    private String user_id;      // 사용자 아이디

    @NonNull
    private String user_pw;      // 사용자 비밀번호

    @NonNull
    private String user_nm;      // 사용자 이름

    @NonNull
    private Date user_birthdate; // 사용자 생년월일

    
    private String user_role;    // 사용자 구분 (예: admin, user 등)
    
    private Timestamp joined_at;  // 가입 일자

}