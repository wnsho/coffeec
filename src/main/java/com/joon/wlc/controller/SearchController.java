package com.joon.wlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

	@GetMapping("/searchCoffee")
	public String searchCoffee() {
		return "searchCoffee";
	}
	
	@GetMapping("/coffees/1")
	public String coffeeDetails1() {
		return "coffees/c1";
	}
	
	@GetMapping("/coffees/2")
	public String coffeeDetails2() {
		return "coffees/c2";
	}
	
	@GetMapping("/coffees/3")
	public String coffeeDetails3() {
		return "coffees/c3";
	}
	
	@GetMapping("/coffees/4")
	public String coffeeDetails4() {
		return "coffees/c4";
	}
}
