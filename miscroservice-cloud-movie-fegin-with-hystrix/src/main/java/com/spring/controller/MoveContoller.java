package com.spring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.feginApi.UserFeginClient;
import com.spring.model.User;
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MoveContoller {
	
	private static final Logger log = LoggerFactory.getLogger(MoveContoller.class);
	@Autowired
	private UserFeginClient userFeginClient;
	
	@GetMapping("/movie/{id}")
	public User getUser(@PathVariable Long id) {
		log.debug("dubug-message");
		log.info("info-message:");
		return userFeginClient.findById(id);
	}
}
