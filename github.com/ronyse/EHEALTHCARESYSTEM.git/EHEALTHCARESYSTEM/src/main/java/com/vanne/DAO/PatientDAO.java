package com.vanne.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.DoctorUser;
import com.vanne.model.PatientUser;

@Repository
public interface PatientDAO extends CrudRepository<PatientUser, Long>  {
	
	
	   PatientUser findByEmail(String user_email); 
	    Optional<PatientUser> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
	

}
