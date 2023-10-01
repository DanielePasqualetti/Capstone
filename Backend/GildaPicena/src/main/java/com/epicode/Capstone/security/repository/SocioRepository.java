package com.epicode.Capstone.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicode.Capstone.security.entity.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {
	
	List<Socio> findByIscrizione(LocalDate iscrizione);

	Socio findByName(String name);
	
}
