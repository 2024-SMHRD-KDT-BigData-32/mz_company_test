package com.smhrd.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Contest {
	@NonNull int contest_idx;
	@NonNull String title;
	@NonNull String content;
	@NonNull String host_org;
	@NonNull String category;
	@NonNull String app_methos;
	Timestamp st_dt;
	Timestamp ed_dt;
	@NonNull String app_qualification;
	@NonNull String poster_img;
	@NonNull String prize;
}
