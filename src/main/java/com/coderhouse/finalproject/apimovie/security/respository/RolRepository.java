package com.coderhouse.finalproject.apimovie.security.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.finalproject.apimovie.security.entity.Rol;
import com.coderhouse.finalproject.apimovie.security.enums.RolName;

public interface RolRepository extends JpaRepository<Rol, Integer>{

	Optional<Rol> findByRolName(RolName rolName);
}
