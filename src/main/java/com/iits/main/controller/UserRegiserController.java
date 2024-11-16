package com.iits.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iits.main.entity.User;
import com.iits.main.service.UserRegisterService;

@RestController
public class UserRegiserController {

	
	@Autowired
	UserRegisterService userRegisterService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody  User user) {
		return this.userRegisterService.registerUser(user);
		
	}
}
