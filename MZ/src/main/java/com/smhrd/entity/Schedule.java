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
public class Schedule {

   
	@NonNull
    private Integer scheIdx; // ������ �ĺ���

    @NonNull
    private Integer prjIdx; // ������Ʈ �ĺ���

    @NonNull
    private String scheNm; // ������ ��

    @NonNull
    private String scheDesc; // ������ ����

    @NonNull
    private Timestamp stDt; // ���� ����

    @NonNull
    private Timestamp edDt; // ���� ����

    private Timestamp createdAt; // ��� ����

    private Timestamp updatedAt; // ���� ����

    @NonNull 
    private String scheStatus; // ������ ����

    @NonNull 
    private String scheColor; // ������ Į��
}
