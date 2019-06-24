package com.spring.feginApi;

import org.springframework.cloud.openfeign.FeignClient;

import com.config.FeginConfig;
import com.spring.model.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(value = "userservice", configuration = FeginConfig.class)
public interface UserFeginClient {

	@RequestLine("GET /user/{id}")
	public User findById(@Param(value = "id") Long id);
}
