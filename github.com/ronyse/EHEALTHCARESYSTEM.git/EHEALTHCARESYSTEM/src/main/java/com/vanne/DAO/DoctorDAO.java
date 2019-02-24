package com.vanne.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.DoctorUser;



@Repository
public interface DoctorDAO extends CrudRepository<DoctorUser, Long> {  
	
	 
	
	DoctorUser findByEmail(String user_email); 
	
	
	
}


