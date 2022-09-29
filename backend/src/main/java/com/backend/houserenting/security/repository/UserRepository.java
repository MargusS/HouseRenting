package com.backend.houserenting.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.houserenting.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
	boolean existsByUserName(String UserName);
	boolean existsByEmail(String email);
}
