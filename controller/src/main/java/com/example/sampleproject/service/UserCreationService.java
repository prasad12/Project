package com.example.sampleproject.service;

import com.example.sampleproject.reqpayloads.UserCreationRequest;
import com.example.sampleproject.respayloads.UserCreationResponse;

public interface UserCreationService {
	
	UserCreationResponse createNewUser(UserCreationRequest userCreationRequest);
	
	UserCreationResponse getUser(UserCreationRequest userCreationRequest);
}
