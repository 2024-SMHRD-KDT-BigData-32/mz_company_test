package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.entity.Project;

@Mapper
public interface ProjectMapper {

	Project searchProject(int prj_idx);

	List<Project> projectList(String user_idx);

	List<Project> getPrjList();

	boolean createPrj(Project projectData);

	List<Project> getUsrPrjList(@RequestParam("user_id") String user_id);
}