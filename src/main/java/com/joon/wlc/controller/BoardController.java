package com.joon.wlc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joon.wlc.domain.BoardDTO;
import com.joon.wlc.mapper.BoardMapper;

@Controller
public class BoardController {
	
//	@Autowired
//	BoardService boardService;
	
	
	@GetMapping({"","/"})
	public String index() { //컨트롤러에서 세션 찾기
	  
		return "index"; 
	}
  
	@Autowired
	private BoardMapper boardmapper;
	
	@GetMapping(value="/board/showCoffeeRandom1")
	public List<BoardDTO> ListPage(@ModelAttribute BoardDTO dto, Model model) throws Exception {
		
		return boardmapper.selectBoardList();
	}
	
	
	@RequestMapping(value="/board/showCoffeeRandom", method = RequestMethod.GET)
	public void getRandom(Model model) throws Exception {
		
		
		
		
		//return "board/showCoffeeRandom";
	}
	
}
