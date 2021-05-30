package com.example.sampleproject.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sampleproject.datamodel.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long>{
	public User findByMobileNumber(Long mobileNumber);
}
