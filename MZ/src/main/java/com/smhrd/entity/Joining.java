package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Joining {

    private Integer join_idx;

    @NonNull 
    private Integer rc_idx;

    @NonNull 
    private String user_id;
 
    private Timestamp joined_at;

    private Character approval_yn; 

    private Timestamp approved_at; 

    private String rc_role; 

    @NonNull 
    private Integer prj_idx; 
}
