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
	private Integer stack_idx;	
	
	@NonNull
	private String stack_type;	
	
	@NonNull
	private String stack_nm;	
}
