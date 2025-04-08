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
public class Joining {

	@NonNull 
    private Integer joinIdx; // 가입 식별자 (PK)

    @NonNull 
    private Integer rcIdx; // 모집 식별자 (Recruits 테이블과 관계)

    @NonNull 
    private String userId; // 지원자 아이디 (Users 테이블과 관계)

    @NonNull 
    private Timestamp joinedAt; // 신청 날짜

    @NonNull 
    private Character approvalYn; // 승인 여부 ('Y' 또는 'N')

    @NonNull 
    private Timestamp approvedAt; // 승인 날짜

    private String rcRole; // 지원자 역할

    @NonNull 
    private Integer prjIdx; // 프로젝트 식별자 (Projects 테이블과 관계)
}
