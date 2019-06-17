package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.feginApi.UserFeginClient;
import com.spring.model.User;
@RestController
public class MoveContoller {
	
	@Autowired
	private UserFeginClient userFeginClient;
	
	@GetMapping("/movie/{id}")
	public User getUser(@PathVariable Long id) {
		return userFeginClient.findById(id);
	}
}
