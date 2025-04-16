package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStack {
	
	@NonNull
	private Integer uStackIdx;	// ����� ���� �ĺ���
	
	@NonNull
	private Integer StackIdx;	// ���� �ĺ���
	
	@NonNull
	private String userId;	// ����� ���̵�
}
