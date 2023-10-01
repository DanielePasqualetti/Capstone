package com.epicode.Capstone.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.Capstone.security.entity.Master;

public interface MasterRepository extends JpaRepository<Master, Long> {

	Optional<Master> findByUsername(String username);

}
