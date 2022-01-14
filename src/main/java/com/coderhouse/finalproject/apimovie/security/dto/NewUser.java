package com.coderhouse.finalproject.apimovie.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewUser {

	@NotBlank
	private String username;
	
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private Set<String> rols = new HashSet<>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRols() {
		return rols;
	}
	public void setRols(Set<String> rols) {
		this.rols = rols;
	}
}
