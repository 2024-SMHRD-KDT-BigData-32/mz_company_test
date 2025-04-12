package com.smhrd.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Chatting;

@Mapper
public interface ChattingMapper {

	List<Chatting> chatList(int prj_idx);

	int fileUpload(Chatting chatting);

	int messageSave(Chatting chatMessage);

	void insertChatFile(Chatting chat);

	List<Chatting> findFilesByPrjIdx(Map<String, Object> params); // 메서드 이름은 의미를 반영
}