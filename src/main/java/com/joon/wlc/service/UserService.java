package com.joon.wlc.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joon.wlc.model.User;
import com.joon.wlc.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/*
	 * @Transactional public int save(User user) { try { userRepository.save(user);
	 * return 1; } catch (Exception e) { e.printStackTrace();
	 * System.out.println("UserService:save():"+e.getMessage()); } return -1; }
	 */
	
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
	
}
