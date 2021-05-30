package com.example.sampleproject.daoservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sampleproject.dao.UserDAO;
import com.example.sampleproject.datamodel.User;

@Component
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	public void saveUser(User user) {
		userDAO.save(user);
	}
	
	public Optional<User> getUser(Long userId) {
		return userDAO.findById(userId);
	}
	
	public User getUserByMobileNumber(Long MobileNumber) {
		return userDAO.findByMobileNumber(MobileNumber);
	}
	
}
