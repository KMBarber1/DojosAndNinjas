package com.katebarber.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.katebarber.dojosandninjas.models.Dojo;
import com.katebarber.dojosandninjas.models.Ninja;
import com.katebarber.dojosandninjas.services.DojoService;
import com.katebarber.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
    @Autowired
    NinjaService ninjaService;
    
    @Autowired
    DojoService dojoService;
    
    // SHOW ALL   
    @GetMapping("/new/ninja")
    public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model){
		List<Dojo> allDojos = dojoService.showAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja.jsp";
	}
	
    // CREATE    
    @PostMapping("/new/ninja")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Dojo> allDojos = dojoService.showAllDojos();
    		model.addAttribute("allDojos", allDojos);
    		return "ninja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			System.out.println(ninja.getDojo().getId());
			return "redirect:/dojo/"+ninja.getDojo().getId();
		}
    }
  
}