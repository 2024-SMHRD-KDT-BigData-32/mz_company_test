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

	@NonNull 
    private Integer joinIdx; // ���� �ĺ��� (PK)

    @NonNull 
    private Integer rcIdx; // ���� �ĺ��� (Recruits ���̺�� ����)

    @NonNull 
    private String userId; // ������ ���̵� (Users ���̺�� ����)

    @NonNull 
    private Timestamp joinedAt; // ��û ��¥

    @NonNull 
    private Character approvalYn; // ���� ���� ('Y' �Ǵ� 'N')

    @NonNull 
    private Timestamp approvedAt; // ���� ��¥

    private String rcRole; // ������ ����

    @NonNull 
    private Integer prjIdx; // ������Ʈ �ĺ��� (Projects ���̺�� ����)
}
