package com.saar.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//This class will use to create Beans - yaha ham jaisa bhi beans define krna chahe kr sakte hai

//@Configuration marks a class as a source of bean definitions for the Spring container.
@Configuration 
public class MyConfig {
	
	
	//@Bean -Registers the return object as a Spring-managed bean
	 //@LoadBalanced is used to enable service-to-service communication using service names 
	//(instead of IPs/URLs) with a client-side load balancer (like Spring Cloud LoadBalancer or Ribbon).
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	
	/*
	 * RestTemplate is an HTTP client
	•	It is used to make RESTful web service calls in Spring Boot.
	•	Supports methods like getForObject, postForEntity, exchange, etc
*/
}
