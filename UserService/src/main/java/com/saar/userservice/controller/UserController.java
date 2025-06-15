package com.saar.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saar.userservice.entity.User;
import com.saar.userservice.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1=userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user)
	{
		User user1=userService.updateUser(userId,user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId)
	{
		String str=userService.deleteUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(str);
	}
	
	int retryCount=1;
	@GetMapping("/get/{userId}")
//	@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getByIdUser(@PathVariable String userId)
	{
		logger.info("Get Single User Handler: UserController ");
		logger.info("Retry count: {} ", retryCount);
		retryCount ++;
		User user1=userService.getUser(userId);
		retryCount ++;
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex)
	{
		logger.info("Fallback is executed because service is down : ",ex.getMessage());
		User user1=User.builder().name("Default").email("Default43t@gmail.com")
		.about("It will run when Rating or Hotel Project will be down")
		.userId("123456789").build();
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User>ls=userService.getAllUser()		;
		return ResponseEntity.status(HttpStatus.CREATED).body(ls);
	}
}
