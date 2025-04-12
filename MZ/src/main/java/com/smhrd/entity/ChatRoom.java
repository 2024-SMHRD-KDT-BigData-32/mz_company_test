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
    private String croom_status; // �� ����
    
    // 메시지 타입 상수 정의
    public static class MessageType {
        public static final String ENTER = "ENTER";
        public static final String QUIT = "QUIT";
        public static final String TALK = "TALK";
    }
}
