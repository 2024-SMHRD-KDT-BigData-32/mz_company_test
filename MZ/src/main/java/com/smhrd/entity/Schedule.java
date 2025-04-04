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
    private Integer scheIdx; // 스케쥴 식별자

    @NonNull
    private Integer prjIdx; // 프로젝트 식별자

    @NonNull
    private String scheNm; // 스케쥴 명

    @NonNull
    private String scheDesc; // 스케쥴 설명

    @NonNull
    private Timestamp stDt; // 시작 일자

    @NonNull
    private Timestamp edDt; // 종료 일자

    private Timestamp createdAt; // 등록 일자

    private Timestamp updatedAt; // 수정 일자

    @NonNull 
    private String scheStatus; // 스케쥴 상태

    @NonNull 
    private String scheColor; // 스케쥴 칼라
}
