package com.joon.wlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	

	@GetMapping({"","/"})
	public String index() { //컨트롤러에서 세션 찾기
		
		return "index";
	}
	
}
