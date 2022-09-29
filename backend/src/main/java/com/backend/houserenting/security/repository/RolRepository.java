package com.backend.houserenting.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.houserenting.security.entity.Rol;
import com.backend.houserenting.security.enumjwt.RolName;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByRolName(RolName rolName);
}
