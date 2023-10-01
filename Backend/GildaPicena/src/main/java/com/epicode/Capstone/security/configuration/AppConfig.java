package com.epicode.Capstone.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.Capstone.security.entity.Giocatore;
import com.epicode.Capstone.security.entity.Master;
import com.epicode.Capstone.security.entity.Socio;
import com.epicode.Capstone.security.entity.Tavolo;
import com.epicode.Capstone.security.entity.User;
import com.epicode.Capstone.security.repository.GiocatoreRepository;
import com.epicode.Capstone.security.repository.MasterRepository;
import com.epicode.Capstone.security.repository.SocioRepository;
import com.epicode.Capstone.security.repository.TavoloRepository;
import com.epicode.Capstone.security.repository.UserRepository;

@Configuration
public class AppConfig {
	
	@Autowired MasterRepository masterRepo;
	@Autowired TavoloRepository tavoloRepo;
	@Autowired UserRepository userRepo;
	@Autowired GiocatoreRepository giocatoreRepo;
	@Autowired SocioRepository socioRepo;
	
	@Bean("socioBean")
	@Scope("prototype")
	public Socio socio() {
		return new Socio();
	}
	
	@Bean("masterBean")
	@Scope("prototype")
	public Master master() {
		return new Master();
	}

	@Bean("tavoloBean")
	@Scope("prototype")
	public Tavolo tavolo() {
		return new Tavolo();
	}
	
	@Bean("userBean")
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean("giocatoreBean")
	@Scope("prototype")
	public Giocatore giocatore() {
		return new Giocatore();
	}
}
