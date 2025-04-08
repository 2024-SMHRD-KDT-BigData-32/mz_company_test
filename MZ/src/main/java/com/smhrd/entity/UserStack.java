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
	private Integer uStackIdx;	// 사용자 스텍 식별자
	
	@NonNull
	private Integer StackIdx;	// 스텍 식별자
	
	@NonNull
	private String userId;	// 사용자 아이디
}
