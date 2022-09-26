package com.backend.houserenting.repository;

import com.backend.houserenting.entity.House;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HouseRepository extends JpaRepository<House, Long> {
    Optional<House> findByTitle(String title);
    boolean existsByTitle(String title);
}
