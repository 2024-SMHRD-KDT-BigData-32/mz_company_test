package com.smhrd.entity;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String userId;      // 사용자 아이디

    @NonNull
    private String userPw;      // 사용자 비밀번호

    @NonNull
    private String userNm;      // 사용자 이름

    @NonNull
    private Date userBirthdate; // 사용자 생년월일

    @NonNull
    private String userRole;    // 사용자 구분 (예: admin, user 등)
    
    private Timestamp joinedAt;  // 가입 일자

}