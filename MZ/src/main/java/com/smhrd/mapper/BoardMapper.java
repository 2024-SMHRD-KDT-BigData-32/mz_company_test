package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Board;

@Mapper
public interface BoardMapper {

	List<Board> showBoard();

	void deleteBoard(int idx);

	int boardInsert(Board board);

	Board boardContent(int idx);
	
}
