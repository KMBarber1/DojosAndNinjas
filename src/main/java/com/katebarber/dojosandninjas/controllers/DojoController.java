package com.katebarber.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.katebarber.dojosandninjas.models.Dojo;
import com.katebarber.dojosandninjas.services.DojoService;
import com.katebarber.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {
	
    @Autowired
    DojoService dojoService;
    
    @Autowired
    NinjaService ninjaService;
    
    // SHOW ALL    
    @GetMapping("/")
    public String dojo(@ModelAttribute("dojo") Dojo dojo){
        return "dojo.jsp";
    }
    
    // CREATE    
    @PostMapping("/")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if (result.hasErrors()) {
			return "dojo.jsp";
    	} else {
			dojoService.createDojo(dojo);
			return "redirect:/new/ninja";
		}
    }

    // SHOW ONE 
    @GetMapping("/dojo/{id}")
    public String showDojoDetails(@PathVariable("id") Long id, Model model){
    		Dojo dojo = dojoService.showOne(id);
    		System.out.println("***********************" +dojo.getDojoName());
    		System.out.println("***********************" +dojo.getId());
    		model.addAttribute("dojo",dojo);
    		return "details.jsp";
    }
}
