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
	private Integer stackIdx;	// ���� �ĺ���
	
	@NonNull
	private String stackType;	// ���� ����
	
	@NonNull
	private String stackNm;	// ���� ��
}
