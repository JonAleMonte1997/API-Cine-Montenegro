package com.coderhouse.finalproject.apimovie.security.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.coderhouse.finalproject.apimovie.security.enums.RolName;
import com.sun.istack.NotNull;

@Entity
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolName rolName;
	
	public Rol() {
	}

	public Rol(RolName rolName) {
		this.rolName = rolName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RolName getRolName() {
		return rolName;
	}

	public void setRolName(RolName rolName) {
		this.rolName = rolName;
	}
}
