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
    private String userId;      // ����� ���̵�

    @NonNull
    private String userPw;      // ����� ��й�ȣ

    @NonNull
    private String userNm;      // ����� �̸�

    @NonNull
    private Date userBirthdate; // ����� �������

    @NonNull
    private String userRole;    // ����� ���� (��: admin, user ��)
    
    private Timestamp joinedAt;  // ���� ����

}