package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recruit {
	
	@NonNull
    private Integer rcIdx; // ���� �ĺ��� (PK)

    @NonNull
    private Integer prjIdx; // ������Ʈ �ĺ��� (Projects ���̺�� ����)

    @NonNull
    private String rcTitle; // ���� ����

    @NonNull
    private String rcContent; // ���� ����

    @NonNull
    private String userId; // �ۼ��� ID

    @NonNull
    private Timestamp closedAt; // ���� ������
    	
    @NonNull
    private Timestamp createdAt; // ��� ����
}
