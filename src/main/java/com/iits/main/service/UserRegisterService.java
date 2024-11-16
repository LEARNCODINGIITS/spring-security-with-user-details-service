package com.iits.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iits.main.entity.User;
import com.iits.main.repository.UserRepository;

@Service
public class UserRegisterService {

	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder b =new BCryptPasswordEncoder(12);
	
	public String registerUser(User user) {
		  String pwd=user.getPassword();
		  String encryPassword = b.encode(pwd);
		  
		  user.setPassword(encryPassword);
		  
		User u = this.userRepository.save(user);
		if (u != null) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}
}
