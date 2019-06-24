package com.spring.feginApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.RequestLine;

@FeignClient(name="xxx", url = "http://localhost:8200/")
public interface FeginClient2 {
	
	@RequestMapping(value="/eureka/apps/{serviceName}")
	public String findServiceInfoByServiceName(@PathVariable("serviceName") String serviceName);
}
