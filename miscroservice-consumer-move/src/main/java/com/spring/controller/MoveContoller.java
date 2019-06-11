package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.model.User;
@RestController
public class MoveContoller {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	public User getUser(@PathVariable Long id) {
		return restTemplate.getForObject("http://localhost:8000/user/"+id, User.class);
	}
}
