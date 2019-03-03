package com.vanne.service;



import java.util.List;
import java.util.Optional;

import com.vanne.model.DoctorUser;
import com.vanne.model.PatientUser;
import com.vanne.model.Users;

public interface DoctorService  {
	
	
	//void save(DoctorUser doctor); 
	DoctorUser findByEmail(String user_email); 
	
	
     DoctorUser  create(DoctorUser doctor);  
	
	Optional<DoctorUser> delete(long id);
	  
	
	
	List<DoctorUser> findAll();
	
	Optional<DoctorUser> findById(long id); 
	
	DoctorUser update(DoctorUser doctor);  
	
	
	

}
