package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;


@Service
public class BoardService implements IBoardService {

    private final BoardRepository  boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board regist(BoardDto boardDto) { 
    	
    	Board board = Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())  // DTO의 데이터로 Board 엔티티 생성
                .build();

        return boardRepository.save(board);  // BoardRepository를 통해 데이터베이스에 저장
    }

	@Override
	public List<Board> getList() {
		return boardRepository.findAll();
	}

	@Override
	public Board getBoard(int bno) {
	    // findById()는 Optional을 반환
	    Optional<Board> result = boardRepository.findById(bno);
	    
	    // 값이 존재하면 반환, 없으면 null 반환
	    return result.orElse(null);
	}

	@Override
	public Board midify(BoardDto boardDto) {
		
		Board board1 =Board.builder()
				.bno(boardDto.getBno())
				.title(boardDto.getTitle())
				.content(boardDto.getContent())
				.writer(boardDto.getWriter())
				.build();
		return boardRepository.save(board1);
	}

	@Override
	public Board delete(int bno) {
	    // 먼저 Board 객체를 조회
	    Optional<Board> boardOptional = boardRepository.findById(bno);
	    System.out.println("sdfsdfsdf");
	    // 객체가 존재하면 삭제하고, 해당 객체를 반환
	    if (boardOptional.isPresent()) {
	        Board board = boardOptional.get();  // 삭제할 객체
	        boardRepository.deleteById(bno);    // 객체 삭제
	        return board;                       // 삭제된 객체 반환
	    } else {
	        // 해당 bno에 해당하는 Board가 없으면 null 또는 예외를 반환
	        return null;  // 또는 throw new EntityNotFoundException("Board not found with id " + bno);
	    }
	}


	


}



   
	

