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
    private Integer croomIdx; // �� �ĺ���

    @NonNull
    private Integer prjIdx; // ������Ʈ �ĺ���

    @NonNull
    private String croomTitle; // �� ����

    @NonNull
    private String croomDesc; // �� �Ұ�

    private Timestamp openedAt; // �� ��������

    @NonNull
    private Integer croomLimit; // �� �ο���

    @NonNull
    private String userId; // �� ������

    @NonNull
    private String croomStatus; // �� ����
}
