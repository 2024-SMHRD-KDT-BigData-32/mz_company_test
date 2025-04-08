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
public class Project {
<<<<<<< HEAD
    
	@NonNull
    private Integer prj_idx; // ������Ʈ �ĺ��� (PK)
=======
   
    private Integer prj_idx; 
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
    
    @NonNull
<<<<<<< HEAD
    private String prj_nm; // ������Ʈ ��
=======
    private String prj_nm;   
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
    
    @NonNull 
<<<<<<< HEAD
    private String prj_desc; // ������Ʈ ����
=======
    private String prj_desc; 
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
    
<<<<<<< HEAD
    @NonNull 
    private String user_id; // ������ ���̵� (Users ���̺�� ����)
=======
    @NonNull
    private String user_id; 
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
    
<<<<<<< HEAD
    private Integer contest_idx; // ������ �ĺ��� (Contests ���̺�� ����)
=======
    private Integer contest_idx; 
     
    private Timestamp created_at; 
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
    
<<<<<<< HEAD
    @NonNull 
    private Timestamp created_at; // ��� ��¥
    
    private Timestamp updated_at; // ���� ��¥
=======
    private Timestamp updated_at; 
>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
}

