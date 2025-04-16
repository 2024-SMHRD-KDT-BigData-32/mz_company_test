package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechStack {
	
	private Integer stack_idx;	// PK(AUTO_INCREMENT)
	
	@NonNull
	private String stack_type; // 
	
	@NonNull
	private String stack_nm;
}
