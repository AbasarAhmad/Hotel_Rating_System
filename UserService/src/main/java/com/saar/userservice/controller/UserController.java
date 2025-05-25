package com.saar.userservice.controller;

import java.util.List;

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

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
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

	@GetMapping("/get/{userId}")
	public ResponseEntity<User> getByIdUser(@PathVariable String userId)
	{
		User user1=userService.getUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User>ls=userService.getAllUser()		;
		return ResponseEntity.status(HttpStatus.CREATED).body(ls);
	}
}
