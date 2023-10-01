package com.epicode.Capstone.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.Capstone.security.entity.User;
import com.epicode.Capstone.security.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository userRepo;
	
	@Autowired @Qualifier("userBean") private ObjectProvider<User> userProvider;

	public Optional<User> findByEmail(String email) {
		Optional<User> u = userRepo.findByEmail(email);
		return u;
	}
	
	public Optional<User> findByUsername(String username) {
		Optional<User> u = userRepo.findByUsername(username);
		return u;
	}
	
	public List<User> findByName(String name) {
		List<User> u = userRepo.findByName(name);
		return u;
	}
	
	public List<User> findByLastame(String lastname) {
		List<User> u = userRepo.findByLastname(lastname);
		return u;
	}
	
}
