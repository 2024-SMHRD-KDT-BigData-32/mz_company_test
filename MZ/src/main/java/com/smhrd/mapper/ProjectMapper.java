package com.smhrd.mapper;

<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper {

	
	
=======
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.entity.Project;

@Mapper
public interface ProjectMapper {

	List<Project> getPrjList();

	boolean createPrj(Project projectData);

	List<Project> getUsrPrjList(@RequestParam("user_id") String user_id);

>>>>>>> branch 'master' of https://github.com/2024-SMHRD-KDT-BigData-32/mz_company_test.git
}
