package com.coderhouse.finalproject.apimovie.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderhouse.finalproject.apimovie.security.entity.MainUser;
import com.coderhouse.finalproject.apimovie.security.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getByEmail(email).get();
		
		return MainUser.build(user);
	}	
}
