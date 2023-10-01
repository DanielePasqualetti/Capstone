package com.epicode.Capstone.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Capstone.security.entity.EStatoTavolo;
import com.epicode.Capstone.security.entity.ETipoGioco;
import com.epicode.Capstone.security.entity.Master;
import com.epicode.Capstone.security.entity.Tavolo;
import com.epicode.Capstone.security.repository.TavoloRepository;

@Service
public class TavoloService {
	
	@Autowired TavoloRepository tavoloRepo;
	
	@Autowired @Qualifier("tavoloBean") private ObjectProvider<Tavolo> tavoloProvider;
	
	public Tavolo creaTavolo(
			Master master,
			ETipoGioco gioco,
			EStatoTavolo stato
			) {
		Tavolo t = tavoloProvider.getObject().builder()
				.master(master)
				.gioco(gioco)
				.stato(stato)
				.build();
		tavoloRepo.save(t);
		System.out.println("Nuovo tavolo pronto!");
		return t;
	}
	
	public Optional<Tavolo> findByMaster(Master master) {
	    Optional<Tavolo> t = tavoloRepo.getByMaster(master);
		return t;
	}
	
	public List<Tavolo> findByStato(EStatoTavolo stato) {
		List<Tavolo> listaTavoli = tavoloRepo.findByStato(stato);
		return listaTavoli;
	}
	
	public List<Tavolo> findByGioco(ETipoGioco gioco) {
		List<Tavolo> listaTavoli = tavoloRepo.findByGioco(gioco);
		return listaTavoli;
	}
	
	public List<Tavolo> findAll(){
		List<Tavolo> listaTavoli = tavoloRepo.findAll();
		return listaTavoli;
	}
	
	public Tavolo findById(Long id) {
		Tavolo tavolo = tavoloRepo.findById(id).get();
		return tavolo;
	}
}
