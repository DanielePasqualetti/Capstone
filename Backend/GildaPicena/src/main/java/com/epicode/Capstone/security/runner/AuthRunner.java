package com.epicode.Capstone.security.runner;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.Capstone.security.entity.ERole;
import com.epicode.Capstone.security.entity.EStatoTavolo;
import com.epicode.Capstone.security.entity.ETipoGioco;
import com.epicode.Capstone.security.entity.Giocatore;
import com.epicode.Capstone.security.entity.Master;
import com.epicode.Capstone.security.entity.Role;
import com.epicode.Capstone.security.entity.Tavolo;
import com.epicode.Capstone.security.repository.GiocatoreRepository;
import com.epicode.Capstone.security.repository.MasterRepository;
import com.epicode.Capstone.security.repository.RoleRepository;
import com.epicode.Capstone.security.repository.TavoloRepository;
import com.epicode.Capstone.security.repository.UserRepository;
import com.epicode.Capstone.security.service.AuthService;

@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired MasterRepository masterRepository;
	@Autowired TavoloRepository tavoloRepository;
	@Autowired GiocatoreRepository giocatoreRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<Role> adminRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");
		// Da lanciare solo la prima volta
		//setRoleDefault();
		//creaSerata();		
		
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
				
		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(user);
				
		userRole = new HashSet<Role>();
		userRole.add(user);
	}
	
//	private void creaSerata() {
//		
//		Master master1 = Master.builder()
//				.name("Valerio")
//				.lastname("Serafini")
//				.username("Svel")
//				.email("Vale.Sera@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		Master master2 = Master.builder()
//				.name("Alessio")
//				.lastname("Filipponi")
//				.username("Pippo")
//				.email("Ale.Fil@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		Master master3 = Master.builder()
//				.name("Antonio")
//				.lastname("Olimpi")
//				.username("Re")
//				.email("Anto.Olimpi@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		Master master4 = Master.builder()
//				.name("Alessandro")
//				.lastname("Petrucci")
//				.username("Peccio")
//				.email("Ale.Peccio@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		Master master5 = Master.builder()
//				.name("Federico")
//				.lastname("Ceci")
//				.username("Fedush")
//				.email("Fede.Ceci@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		Master master6 = Master.builder()
//				.name("Stefano")
//				.lastname("Agostini")
//				.username("Steff")
//				.email("Ste.Ago@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		Master master7 = Master.builder()
//				.name("Matteo")
//				.lastname("Censori")
//				.username("Censo")
//				.email("Matt.Cens@example.com")
//				.password(passwordEncoder.encode("password"))
//				.roles(adminRole)
//				.build();
//		
//		masterRepository.save(master1);
//		masterRepository.save(master2);
//		masterRepository.save(master3);
//		masterRepository.save(master4);
//		masterRepository.save(master5);
//		masterRepository.save(master6);
//		masterRepository.save(master7);
//		
//		Tavolo tavolo1 = Tavolo.builder()
//				.master(master1)
//				.gioco(ETipoGioco.DI_RUOLO)
//				.stato(EStatoTavolo.NON_PIENO)
//				.build();
//		
//		Tavolo tavolo2 = Tavolo.builder()
//				.master(master2)
//				.gioco(ETipoGioco.DI_RUOLO)
//				.stato(EStatoTavolo.NON_PIENO)
//				.build();
//		
//		Tavolo tavolo3 = Tavolo.builder()
//				.master(master3)
//				.gioco(ETipoGioco.DA_TAVOLO)
//				.stato(EStatoTavolo.NON_PIENO)
//				.build();
//		
//		Tavolo tavolo4 = Tavolo.builder()
//				.master(master4)
//				.gioco(ETipoGioco.DI_CARTE)
//				.stato(EStatoTavolo.NON_PIENO)
//				.build();
//		
//		tavoloRepository.save(tavolo1);
//		tavoloRepository.save(tavolo2);
//		tavoloRepository.save(tavolo3);
//		tavoloRepository.save(tavolo4);
//		
//		Giocatore giocatore1 = Giocatore.builder()
//				.name("Gianluca")
//				.lastname("Falcone")
//				.tavolo(tavolo1)
//				.build();
//		
//		Giocatore giocatore2 = Giocatore.builder()
//				.name("Federico")
//				.lastname("Morgante")
//				.tavolo(tavolo1)
//				.build();
//		
//		giocatoreRepository.save(giocatore1);
//		giocatoreRepository.save(giocatore2);
//	};
	
}
