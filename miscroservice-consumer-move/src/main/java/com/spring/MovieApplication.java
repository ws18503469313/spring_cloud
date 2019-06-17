package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.config.RobbinConfig;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="userservice", configuration=RobbinConfig.class)
public class MovieApplication extends SpringBootServletInitializer {

	@Bean
	@LoadBalanced//ribbon客户端负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MovieApplication.class);
		springApplication.run(args);
	}
}
