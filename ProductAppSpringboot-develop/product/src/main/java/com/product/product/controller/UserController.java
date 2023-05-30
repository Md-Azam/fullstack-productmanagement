package com.product.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.entity.User;
import com.product.product.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public User saveUse(@RequestBody User u) {
		return userService.saveUser(u);
	}
	
	@GetMapping("/{userId}")
	public User getSingleUser(@PathVariable Integer userId) {
		return userService.getSingleUser(userId);
	}
}
