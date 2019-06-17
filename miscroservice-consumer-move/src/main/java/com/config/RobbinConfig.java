package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

@Configuration
public class RobbinConfig {

	@Autowired
	public IClientConfig config;
	
	public IRule ribbonRule(IClientConfig config) {
		return new WeightedResponseTimeRule();
	}
}
