package com.vanne.service;



import java.util.List;
import java.util.Optional;

import com.vanne.model.PatientUser;
import com.vanne.model.Users;

public interface PatientService  {

	
	
	//void save(PatientUser patient); 
	PatientUser findByEmail(String user_email); 
	
	
	
	PatientUser  create(PatientUser patient);   
	
	Optional<PatientUser> delete(long id);
	
	List<PatientUser> findAll();
	
	Optional<PatientUser> findById(long id);             
	
	PatientUser update(PatientUser patient);  
	
	Optional<PatientUser> findByUsername(String username);
	
}
