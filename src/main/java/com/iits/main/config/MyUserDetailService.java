package com.iits.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iits.main.entity.User;
import com.iits.main.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user=this.userRepository.findByUsername(username);
		if(user==null) {
			System.out.println("user:"+user);
			throw new UsernameNotFoundException("USER NOT FOUND");
		}
		UserDetails userDetails =new MyUserPrinciple(user);
		return userDetails;
	}
}
