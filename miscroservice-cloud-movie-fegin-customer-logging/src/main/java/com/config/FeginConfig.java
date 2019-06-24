package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;
@Configuration
public class FeginConfig {
	
	@Bean
	public Contract feginContract() {
		return new feign.Contract.Default();
	}
	@Bean
	Logger.Level feginLoggerLever(){
		return Logger.Level.FULL;
	}
}
