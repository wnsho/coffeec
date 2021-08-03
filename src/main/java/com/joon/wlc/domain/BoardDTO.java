package com.joon.wlc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {

	private int id;
	
	private String name;
	
	private String explain;
	
	private String img;
	
	private int likes;
}
