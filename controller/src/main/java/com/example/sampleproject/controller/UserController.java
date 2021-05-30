package com.example.sampleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampleproject.daoservice.UserService;
import com.example.sampleproject.reqpayloads.UserCreationRequest;
import com.example.sampleproject.respayloads.UserCreationResponse;
import com.example.sampleproject.service.UserCreationService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserCreationService userCreationService;
	
	@PostMapping("/createUser")
	public UserCreationResponse createUser(@RequestBody UserCreationRequest userCreationRequest) {
		return userCreationService.createNewUser(userCreationRequest);
	}
	
	@PostMapping("/getUser")
	public UserCreationResponse getUser(@RequestBody UserCreationRequest userCreationRequest) {
		return userCreationService.getUser(userCreationRequest);
	}
	
	@GetMapping("/hello")
	public UserCreationResponse getUser() {
		return new UserCreationResponse("hello");
		//throw new RuntimeException("something gone wrong");
	}
}
