package com.epicode.Capstone.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.Capstone.security.entity.EStatoTavolo;
import com.epicode.Capstone.security.entity.ETipoGioco;
import com.epicode.Capstone.security.entity.Giocatore;
import com.epicode.Capstone.security.entity.Master;
import com.epicode.Capstone.security.entity.Socio;
import com.epicode.Capstone.security.entity.Tavolo;
import com.epicode.Capstone.security.repository.SocioRepository;
import com.epicode.Capstone.security.repository.TavoloRepository;
import com.epicode.Capstone.security.service.GiocatoreService;
import com.epicode.Capstone.security.service.MasterService;
import com.epicode.Capstone.security.service.SocioService;
import com.epicode.Capstone.security.service.TavoloService;
import com.epicode.Capstone.security.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class AppController {
	
	@Autowired MasterService mSvc;
	@Autowired UserService uSvc;
	@Autowired GiocatoreService gSvc;
	
	@Autowired TavoloService tSvc;
	@Autowired TavoloRepository tavoloRepo;
	@Autowired @Qualifier("tavoloBean") private ObjectProvider<Tavolo> tavoloProvider;
	
	@Autowired SocioService sSvc;
	@Autowired SocioRepository socioRepo;
	@Autowired @Qualifier("socioBean") private ObjectProvider<Socio> socioProvider;
	
	//POST	
	@PostMapping("/tavoli/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> creaTavolo(@RequestBody Tavolo t) {
		Tavolo tavolo = tSvc.creaTavolo(t.getMaster(), t.getGioco(), t.getStato());
		return new ResponseEntity<Tavolo> (tavolo, HttpStatus.OK);
	}
	
	@PostMapping("/giocatori/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> creaGiocatore(@RequestBody Giocatore giocatore) {
		
		Tavolo tavolo = tSvc.findById(giocatore.getTavolo().getNumero());
		
		if (tavolo != null) {
			tavolo = tavoloProvider.getObject();
			tavoloRepo.save(tavolo);
		}

		Giocatore g = gSvc.creaGiocatore(giocatore);
		return new ResponseEntity<Giocatore> (g, HttpStatus.OK);
	}
	
	@PostMapping("/soci/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> addSocio(@RequestBody Socio s) {
		Socio socio = sSvc.addSocio(s.getName(), s.getLastname(), s.getIscrizione());
		return new ResponseEntity<Socio> (socio, HttpStatus.OK);
	}
	
	//DELETE
	@DeleteMapping("/soci/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> eliminaSocio(@PathVariable Long id) {
        Socio socio = sSvc.findById(id);

        if (socio != null) {
            sSvc.eliminaSocio(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	//PUT
	@PutMapping("/soci/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> modificaSocio(@PathVariable Long id, @RequestBody Socio socioModificato) {
	    Socio socioEsistente = sSvc.findById(id);

	    if (socioEsistente != null) {

	        socioEsistente.setName(socioModificato.getName());
	        socioEsistente.setLastname(socioModificato.getLastname());
	        socioEsistente.setIscrizione(socioModificato.getIscrizione());

	        Socio socioAggiornato = sSvc.modificaSocio(socioEsistente);

	        return new ResponseEntity<>(socioAggiornato, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	//GET DEI SOCI
	@GetMapping("/soci/get")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Socio>> findAll(){
		List<Socio> soci = sSvc.findAll();
		return ResponseEntity.ok(soci);
	}
	
	
	//GET DEI TAVOLI
	@GetMapping("/tavoli/get")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Tavolo>> getAll(){
		List<Tavolo> tavoli = tSvc.findAll();
		return ResponseEntity.ok(tavoli);
	}
	
	@GetMapping("/tavoli/get/{master}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Optional<Tavolo>> getByMaster(@PathVariable Master master){
		Optional<Tavolo> tavolo = tSvc.findByMaster(master);
		return ResponseEntity.ok(tavolo);
	}
	
	@GetMapping("/tavoli/get/{stato}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Tavolo>> getByStato(@PathVariable EStatoTavolo stato){
		List<Tavolo> tavolo = tSvc.findByStato(stato);
		return ResponseEntity.ok(tavolo);
	}
	
	@GetMapping("/tavoli/get/{gioco}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Tavolo>> getByGioco(@PathVariable ETipoGioco gioco){
		List<Tavolo> tavolo = tSvc.findByGioco(gioco);
		return ResponseEntity.ok(tavolo);
	}
	
	
}
