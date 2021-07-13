package com.joon.wlc.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joon.wlc.dto.ResponseDto;
import com.joon.wlc.model.RoleType;
import com.joon.wlc.model.User;
import com.joon.wlc.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { // username,password,email
		System.out.println("UserApiController:save호출됨");
		//실제로 db에 insert하고 아래서 return
		user.setRole(RoleType.USER);
		userService.save(user);
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
	
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user){
		System.out.println("UserApiController:login호출됨");
		User principal = userService.login(user); //principal(접근주체)
		
		if(principal!=null) {
			session.setAttribute("principal", principal);
		}
		return new ResponseDto<Integer>(HttpStatus.OK,1);
	}
}
