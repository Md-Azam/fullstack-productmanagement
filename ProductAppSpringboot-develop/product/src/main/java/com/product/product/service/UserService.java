package com.product.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.entity.User;
import com.product.product.exception.ResourceNotFound;
import com.product.product.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	
	public User saveUser(User u ) {
		return repo.save(u);
	}
	
	public User getSingleUser(Integer userId) {
		return repo.findById(userId).orElseThrow(() -> new ResourceNotFound("user not found"));
	}

}
