package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data

public class Board {
	
	private int idx;
	@NonNull private String title;
	@NonNull private String writer;
	@NonNull private String filename;
	@NonNull private String content;
	private String b_date;
	
}
