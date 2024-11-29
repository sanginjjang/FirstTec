package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	List<Board> findByWriter(String wirter);
	
	List<Board> findByTitleContaining(String keyword);
}
