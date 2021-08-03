package com.joon.wlc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joon.wlc.domain.BoardDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> selectBoardList();
	
	public BoardDTO selectBoardDetail(int id);
}
