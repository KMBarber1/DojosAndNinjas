package com.katebarber.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.katebarber.dojosandninjas.models.Ninja;
import com.katebarber.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	//	SHOW ALL
	public List<Ninja> showAllNinjas() {
		return ninjaRepository.findAll();
	}	
    
	//	CREATE
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

}
