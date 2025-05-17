package com.saar.userservice.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
	
	private String msg;
	private boolean success;
	private HttpStatus status;
	
	
//	//without builder 
//	User user = new User("Abas", 25, "India");
//
//	//with builer
//	User user = User.builder()
//            .name("Abas")
//            .age(25)
//            .country("India")
//            .build();


}
