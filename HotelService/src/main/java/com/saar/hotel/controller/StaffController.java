package com.saar.hotel.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
	
	@PostMapping("/staffs")
	public ResponseEntity<List<String>> getStaffs()
	{
		List<String>list=Arrays.asList("Ram","Shyam","Sita","Krishna");
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
