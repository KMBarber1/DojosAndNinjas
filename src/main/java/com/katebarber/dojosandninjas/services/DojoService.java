package com.katebarber.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.katebarber.dojosandninjas.models.Dojo;
import com.katebarber.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
		
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	// SHOW ALL
	public List<Dojo> showAllDojos() {
		return dojoRepository.findAll();
	}
	
	//	CREATE
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	//	SHOW ONE
	public Dojo showOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
	    }
	}
	
}
