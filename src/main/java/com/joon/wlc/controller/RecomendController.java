package com.joon.wlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecomendController {

	@GetMapping("/recomend")
	public String recomendPage() {
		
		return "/recomend";
	}
}
