package com.coderhouse.finalproject.apimovie.security.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderhouse.finalproject.apimovie.security.entity.UserBD;

@Repository
public interface UserRepository extends JpaRepository<UserBD, Integer>{

	Optional<UserBD> findByEmail(String email);
	boolean existsByEmail(String email);
}
