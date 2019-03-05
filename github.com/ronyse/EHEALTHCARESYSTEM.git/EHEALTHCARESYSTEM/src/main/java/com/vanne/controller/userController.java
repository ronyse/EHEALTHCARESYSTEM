package com.vanne.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanne.model.PatientUser;
import com.vanne.service.PatientService;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
@RequestMapping("/user")
public class userController {
	
	
	@Autowired 
	private PatientService patservice;
	
	
	/******************ON_PATIENT_OPERATION**************************************/
	
	@PostMapping("/uadpat")
	public PatientUser createPatient(@RequestBody PatientUser patient) {
		
		return patservice.create(patient); 		
	} 
	
	
	
    
	@GetMapping("/ugetpat/{id}")
	public Optional<PatientUser> findByIdPatient(@PathVariable("id") long id) {
		
		return patservice.findById(id); 
		
	}
	
	
	@PutMapping("/uedpat")
	public PatientUser updatePatient(@RequestBody PatientUser doctor) {
		
		return patservice.update(doctor) ; 
		
	}
	
	
     
	@DeleteMapping("/udelpat/{id}")
	public boolean deletePatient(@PathVariable("id") long id) {
		
		patservice.delete(id);
		return true ; 
	}
	
	
	
	
	@GetMapping("/uallpat")
	public List<PatientUser> findAllPatient() {
		
		List<PatientUser> dl = patservice.findAll() ; 
		Iterator li = dl.listIterator(); 
		
		while( li.hasNext() ) {
			PatientUser d = ( PatientUser ) li.next() ;
			
			System.out.println( d.getUserid() );
		}
		
		return patservice.findAll(); 
		
	}
	
	/**************************END_Doctor_OPERATION*****************************/
	
	
	/*
	public Principal user(Principal user) {
	    return user;
	  }
	*/
	
	
	

}
