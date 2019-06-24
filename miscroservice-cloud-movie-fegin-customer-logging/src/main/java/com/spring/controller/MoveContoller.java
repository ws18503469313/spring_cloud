package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.feginApi.FeginClient2;
import com.spring.feginApi.UserFeginClient;
import com.spring.model.User;
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MoveContoller {
	
	@Autowired
	private UserFeginClient userFeginClient;
	@Autowired
	private FeginClient2 feignClient2;
	
	@RequestMapping( "/movie/{id}")
	public User getUser(@PathVariable Long id) {
		return userFeginClient.findById(id);
	}
	@GetMapping(value = "/{serviceName}", produces = MediaType.APPLICATION_XML_VALUE)
	public String findServiceInfoByServiceName(@PathVariable("serviceName") String serviceName) {
		return this.feignClient2.findServiceInfoByServiceName(serviceName);
	}
}
