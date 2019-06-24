package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.model.User;
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class MoveContoller {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient balancerClient;
	/**
	 * 请求线程和fallback线程是同一个线程
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod = "getUserFallBack", commandProperties=@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
	public User getUser(@PathVariable Long id) {
		return restTemplate.getForObject("http://userservice/user/"+id, User.class);
	}
	public User getUserFallBack(Long id) {
		return new User(-1L);
	}
	
	@GetMapping("/test")
	public String testLoadBalance() {
		ServiceInstance instance = this.balancerClient.choose("userservice");
		System.out.println("111:"+instance.getScheme()+instance.getPort());
		
		ServiceInstance instance1 = this.balancerClient.choose("userservice");
		System.out.println("222:"+instance1.getScheme()+instance1.getPort());
		return "1";
	}
}
