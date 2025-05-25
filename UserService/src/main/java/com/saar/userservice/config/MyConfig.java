package com.saar.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
	
	// This class will use to create Beans - yaha ham jaisa bhi beans define krna chahe kr sakte hai

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
