package com.smhrd.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Notification {
	
	private Integer notification_idx;
	
	@NonNull
	private String user_id;
	
	@NonNull
	private String notification_type;
	
	@NonNull
	private Integer entity_idx;
	
	@NonNull
	private String message;
	
	private boolean is_read;
	
	private Timestamp created_at;
	
	private String sender_id;
}
