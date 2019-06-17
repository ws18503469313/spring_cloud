package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(EurekaApplication.class);
    	springApplication.run(args);
	}
}
