package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechStack {
	
	@NonNull
	private Integer stackIdx;	// 스텍 식별자
	
	@NonNull
	private String stackType;	// 스텍 구분
	
	@NonNull
	private String stackNm;	// 스텍 명
}
