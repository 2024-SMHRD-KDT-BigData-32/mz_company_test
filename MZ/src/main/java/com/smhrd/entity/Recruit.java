package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recruit {
	
	@NonNull
    private Integer rcIdx; // 모집 식별자 (PK)

    @NonNull
    private Integer prjIdx; // 프로젝트 식별자 (Projects 테이블과 관계)

    @NonNull
    private String rcTitle; // 모집 제목

    @NonNull
    private String rcContent; // 모집 내용

    @NonNull
    private String userId; // 작성자 ID

    @NonNull
    private Timestamp closedAt; // 모집 마감일
    	
    @NonNull
    private Timestamp createdAt; // 등록 일자
}
