package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.ChatRoom;
import com.smhrd.entity.Chatting;

@Mapper
public interface ChattingMapper {

	List<Chatting> chatList();

	int massageSave(Chatting chatting);

	int fileUpload(Chatting chatting);


	
}
