package com.joon.wlc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joon.wlc.model.User;

//DAO
//자동으로 bean등록이 된다.
//@repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
