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
	private Integer uStack_idx;	// ����� ���� �ĺ���
	
	@NonNull
	private Integer Stack_idx;	// ���� �ĺ���
	
	@NonNull
	private String user_id;	// ����� ���̵�
}
