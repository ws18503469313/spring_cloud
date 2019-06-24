package com.spring.feginApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.model.User;

@FeignClient("userservice")
public interface UserFeginClient {

	@RequestMapping(value = "/user/{id}", method= RequestMethod.GET)
	public User findById(@PathVariable(value = "id") Long id);
}
