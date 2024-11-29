package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.service.IBoardService;
import com.example.demo.vo.BoardVo;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	IBoardService boardService;
	
	
	@RequestMapping("/registerForm")
	public String registerForm() {
		return "/board/registerForm";
	}
	
	
	@RequestMapping("/regist")
	public String request(BoardDto board) {
		boardService.regist(board);
		return "redirect:/board/list";
	}
	
	
	@RequestMapping("list")
	public String list(Model model) {
		List<Board> boardlist = boardService.getList();
		return "/board/list";
	}
	
	
	@RequestMapping("/detail/{bno}")
	public String detail(@PathVariable("bno") int bno, Model model) {
		Board board = boardService.getBoard(bno);
		model.addAttribute("board",board);
		return "/board/detail";
	}
	
	
	@RequestMapping("/modify")
	public String modify(BoardDto board) {
		boardService.midify(board);
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping("/delete/{bno}")
	public String delete(@PathVariable("bno") int bno, Model model) {
	
		boardService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	
	
	
	
	
}
