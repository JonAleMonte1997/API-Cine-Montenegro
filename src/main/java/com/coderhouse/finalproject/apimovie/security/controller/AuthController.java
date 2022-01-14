package com.coderhouse.finalproject.apimovie.security.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.finalproject.apimovie.security.dto.JwtDto;
import com.coderhouse.finalproject.apimovie.security.dto.LoginUser;
import com.coderhouse.finalproject.apimovie.security.dto.NewUser;
import com.coderhouse.finalproject.apimovie.security.entity.Rol;
import com.coderhouse.finalproject.apimovie.security.entity.UserBD;
import com.coderhouse.finalproject.apimovie.security.enums.RolName;
import com.coderhouse.finalproject.apimovie.security.jwt.JwtProvider;
import com.coderhouse.finalproject.apimovie.security.service.RolService;
import com.coderhouse.finalproject.apimovie.security.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping("/newUser")
	public ResponseEntity<NewUser> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity("Campos mal puestos",HttpStatus.BAD_REQUEST);
		
		if (userService.existsByEmail(newUser.getEmail())) 
			return new ResponseEntity("El mail ya existes",HttpStatus.BAD_REQUEST);
		
		UserBD user = new UserBD(newUser.getUsername(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
		
		Set<Rol> rols = new HashSet<>();
		rols.add(rolService.getByRolName(RolName.ROLE_CLIENT).get());
		
		if (newUser.getRols().contains("ADMIN"))
			rols.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
		
		user.setRols(rols);
		userService.save(user);
		
		return new ResponseEntity<NewUser>(newUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity("Campos mal puestos",HttpStatus.BAD_REQUEST);
		
		Authentication authentication = 
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToken(authentication);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}
