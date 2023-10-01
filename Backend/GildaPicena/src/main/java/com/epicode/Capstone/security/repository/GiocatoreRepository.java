package com.epicode.Capstone.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.Capstone.security.entity.Giocatore;

public interface GiocatoreRepository extends JpaRepository<Giocatore, Long>{

	Optional<Giocatore> findByName(String name);
	
	Optional<Giocatore> findByLastname(String lastname);
	
}
