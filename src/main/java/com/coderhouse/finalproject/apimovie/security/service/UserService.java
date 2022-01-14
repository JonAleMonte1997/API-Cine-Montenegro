package com.coderhouse.finalproject.apimovie.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderhouse.finalproject.apimovie.security.entity.UserBD;
import com.coderhouse.finalproject.apimovie.security.respository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<UserBD> getByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public void save(UserBD user) {
		userRepository.save(user);
	}
}
