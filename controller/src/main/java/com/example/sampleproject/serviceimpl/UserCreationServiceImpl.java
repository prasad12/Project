package com.example.sampleproject.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import com.example.sampleproject.daoservice.UserService;
import com.example.sampleproject.datamodel.User;
import com.example.sampleproject.reqpayloads.UserCreationRequest;
import com.example.sampleproject.respayloads.UserCreationResponse;
import com.example.sampleproject.service.MailService;
import com.example.sampleproject.service.UserCreationService;

@Service
public class UserCreationServiceImpl implements UserCreationService{

	@Autowired
	UserService userService;

	@Autowired
	MailService mailService;

	@Override
	public UserCreationResponse createNewUser(UserCreationRequest userCreationRequest) {

		UserCreationResponse userCreationResponse = new UserCreationResponse();
		if(userCreationRequest != null && userCreationRequest.getMobileNumber() != null) {
			User user = new User();
			user.setCreatedDate(new Date());
			user.setMobileNumber(userCreationRequest.getMobileNumber());
			if(userCreationRequest.getEmail() != null) {
				user.setEmail(userCreationRequest.getEmail());
			}
			if(userCreationRequest.getFirstName() != null) {
				user.setFirstName(userCreationRequest.getFirstName());
			}
			if(userCreationRequest.getMiddleName() != null) {
				user.setMiddleName(userCreationRequest.getMiddleName());
			}
			if(userCreationRequest.getLastName() != null) {
				user.setLastName(userCreationRequest.getLastName());
			}
			user.setUpdatedDate(new Date());
			userService.saveUser(user);
			System.out.println("controller:: Mail sent Initiated---->");
			mailService.senMailGmailSmtp();
			System.out.println("controller:: Mail sent successfully---->");
			userCreationResponse.setStatus("SUCCESS");
			userCreationResponse.setStatusCode(200L);
		}else {
			userCreationResponse.setStatus("FAILED");
			userCreationResponse.setStatusCode(403L);
		}
		return userCreationResponse;
	}

	@Override
	public UserCreationResponse getUser(UserCreationRequest userCreationRequest) {
		UserCreationResponse userCreationResponse = new UserCreationResponse();
		if(userCreationRequest.getMobileNumber() != null) {
			User user = userService.getUserByMobileNumber(userCreationRequest.getMobileNumber());
			if(user != null) {
				if(user.getUserId() != null) {
					userCreationResponse.setUserId(user.getUserId());
				}
				if(user.getFirstName() != null) {
					userCreationResponse.setFirstName(user.getFirstName());		
				}if(user.getMiddleName() != null) {
					userCreationResponse.setMiddleName(user.getMiddleName());
				}if(user.getLastName() != null) {
					userCreationResponse.setLastName(user.getLastName());
				}if(user.getMobileNumber() != null) {
					userCreationResponse.setMobileNumber(user.getMobileNumber());
				}if(user.getEmail() != null) {
					userCreationResponse.setEmail(user.getEmail());
				}
				userCreationResponse.setStatus("SUCCESS");
				userCreationResponse.setStatusCode(200L);
			}else {
				userCreationResponse.setStatus("FAILED");
				userCreationResponse.setStatusCode(403L);
			}
		}
		return userCreationResponse;
	}

}
