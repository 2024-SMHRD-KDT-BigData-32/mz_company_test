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
    private Integer croom_idx; // �� �ĺ���

    @NonNull
    private Integer prj_idx; // ������Ʈ �ĺ���

    @NonNull
    private String croom_title; // �� ����

    @NonNull
    private String croom_desc; // �� �Ұ�

    private Timestamp opened_at; // �� ��������

    @NonNull
    private Integer croom_limit; // �� �ο���

    @NonNull
    private String user_id; // �� ������

    @NonNull
    private String croom_status; // �� ����
}
