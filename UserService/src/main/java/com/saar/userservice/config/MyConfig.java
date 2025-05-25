package com.saar.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // @Configuration marks a class as a source of bean definitions for the Spring container.
public class MyConfig {
	
	// This class will use to create Beans - yaha ham jaisa bhi beans define krna chahe kr sakte hai

	@Bean  //Registers the return object as a Spring-managed bean
	
	@LoadBalanced //@LoadBalanced is used to enable service-to-service communication using service names 
	//(instead of IPs/URLs) with a client-side load balancer (like Spring Cloud LoadBalancer or Ribbon).
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
