package com.coderhouse.finalproject.apimovie.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderhouse.finalproject.apimovie.security.entity.Rol;
import com.coderhouse.finalproject.apimovie.security.enums.RolName;
import com.coderhouse.finalproject.apimovie.security.respository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol> getByRolName(RolName rolName) {
		return rolRepository.findByRolName(rolName);
	}
}
