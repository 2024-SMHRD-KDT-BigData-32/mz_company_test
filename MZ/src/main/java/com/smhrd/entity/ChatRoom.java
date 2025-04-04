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
public class ChatRoom {

	@NonNull
    private Integer croomIdx; // 방 식별자

    @NonNull
    private Integer prjIdx; // 프로젝트 식별자

    @NonNull
    private String croomTitle; // 방 제목

    @NonNull
    private String croomDesc; // 방 소개

    private Timestamp openedAt; // 방 개설일자

    @NonNull
    private Integer croomLimit; // 방 인원수

    @NonNull
    private String userId; // 방 개설자

    @NonNull
    private String croomStatus; // 방 상태
}
