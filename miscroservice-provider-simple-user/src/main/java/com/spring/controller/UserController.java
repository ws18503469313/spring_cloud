package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.UserDAO;
import com.spring.model.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDAO userDAO; 
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User user =  this.userDAO.getOne(id);
		return user;
	}
}
