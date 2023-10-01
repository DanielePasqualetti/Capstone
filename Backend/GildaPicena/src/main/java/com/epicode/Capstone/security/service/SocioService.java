package com.epicode.Capstone.security.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Capstone.security.entity.Socio;
import com.epicode.Capstone.security.repository.SocioRepository;

@Service
public class SocioService {
	
	@Autowired SocioRepository socioRepo;
	
	@Autowired @Qualifier("socioBean") private ObjectProvider<Socio> socioProvider;
	
	public Socio addSocio(
			String name,
			String lastname,
			LocalDate iscrizione
			) {
		Socio s = socioProvider.getObject().builder()
				.name(name)
				.lastname(lastname)
				.iscrizione(iscrizione)
				.build();
		socioRepo.save(s);
		System.out.println("Nuovo socio in Gilda!");
		return s;
	}
	
	public List<Socio> findByIscrizione(LocalDate iscrizione) {
		List<Socio> listaSoci = socioRepo.findByIscrizione(iscrizione);
		return listaSoci;
	}

	public List<Socio> findAll() {
		List<Socio> listaSoci = socioRepo.findAll();
		return listaSoci;
	}

	public Socio findById(Long id) {
		Socio socio = socioRepo.findById(id).get();
		return socio;
	}

	public void eliminaSocio(Long id) {
        socioRepo.deleteById(id);
    }
	
	public Socio findByNome(String name) {
        return socioRepo.findByName(name);
    }

	public Socio modificaSocio(Socio socio) {
	    return socioRepo.save(socio);
	}

}
