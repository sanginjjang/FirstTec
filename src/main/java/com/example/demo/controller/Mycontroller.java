package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Mycontroller {

	@RequestMapping("/")
	public String main() {
		System.out.println("메인페이지 ..");
		return "main";
	}
	
	
	
	
}
