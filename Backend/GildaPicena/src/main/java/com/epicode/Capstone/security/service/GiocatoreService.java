package com.epicode.Capstone.security.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Capstone.security.entity.Giocatore;
import com.epicode.Capstone.security.entity.Master;
import com.epicode.Capstone.security.entity.Tavolo;
import com.epicode.Capstone.security.repository.GiocatoreRepository;
import com.epicode.Capstone.security.repository.TavoloRepository;

@Service
public class GiocatoreService {

	@Autowired GiocatoreRepository giocatoreRepo;
	@Autowired TavoloRepository tavoloRepo;
	@Autowired TavoloService tSvc;
	
	@Autowired @Qualifier("giocatoreBean") private ObjectProvider<Giocatore> giocatoreProvider;
	@Autowired @Qualifier("tavoloBean") private ObjectProvider<Tavolo> tavoloProvider;
	
	public Giocatore creaGiocatore(Giocatore giocatore) {
		Giocatore g = giocatoreProvider.getObject();
		g.setName(giocatore.getName());
		g.setLastname(giocatore.getLastname());
		g.setTavolo(giocatore.getTavolo());
		return g;
	}
//	public Giocatore creaGiocatore(
//			String name,
//			String lastname,
//			Long id
//			) {
//		
//		Giocatore g = giocatoreProvider.getObject().builder()
//				.name(name)
//				.lastname(lastname)
//				.tavolo(tSvc.findById(id))
//				.build();
//		giocatoreRepo.save(g);
//		System.out.println("Nuovo giocatore creato.");
//		return g;
//	}
	
	public Optional<Giocatore> findByName(String name) {
		Optional<Giocatore> g = giocatoreRepo.findByName(name);
		return g;
	}
	
	public Optional<Giocatore> findByLastame(String lastname) {
		Optional<Giocatore> g = giocatoreRepo.findByLastname(lastname);
		return g;
	}
}
