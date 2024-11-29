package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;

public interface IBoardService {

	public Board regist(BoardDto board);
	public List<Board> getList();
	public Board getBoard(int bno);
	public Board midify(BoardDto board);
	public Board delete(int bno);
	
	
}
