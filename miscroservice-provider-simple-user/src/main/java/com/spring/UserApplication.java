package com.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(UserApplication.class);
    	springApplication.run(args);
	}
}
