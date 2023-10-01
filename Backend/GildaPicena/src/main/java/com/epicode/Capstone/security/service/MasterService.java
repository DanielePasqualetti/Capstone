package com.epicode.Capstone.security.service;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Capstone.security.entity.Master;
import com.epicode.Capstone.security.repository.MasterRepository;

@Service
public class MasterService {
	
	@Autowired MasterRepository masterRepo;
	
	@Autowired @Qualifier("masterBean") private ObjectProvider<Master> masterProvider;
	
	public Master creaMaster(
			String name,
			String lastname,
			String username,
			String email,
			String password
			) {
		Master m = masterProvider.getObject().builder()
				.name(name)
				.lastname(lastname)
				.username(username)
				.email(email)
				.password(password)
				.build();
		masterRepo.save(m);
		System.out.println("Un nuovo Master è arrivato in Gilda!");
		return m;		
	}
	
	public Optional<Master> findByUsername(String username) {
		Optional<Master> m = masterRepo.findByUsername(username);
		return m;
	}
	
}
