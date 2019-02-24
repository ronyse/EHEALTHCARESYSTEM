package com.vanne.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vanne.DAO.PatientDAO;
import com.vanne.DAO.RoleDAO;
import com.vanne.model.PatientUser;
import com.vanne.model.Role;
import com.vanne.model.Users;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientdao ; 
	
	@Autowired
	private RoleDAO roledao ; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	
	
	
	@Override
	public void save(PatientUser patient) {
		
		patient.setPassword(bCryptPasswordEncoder.encode(patient.getPassword()));
		patient.setActive(1);
		
		Role userRole = roledao.findByRoleName("PATIENT");
		patient.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
       	patientdao.save(patient); 
		
	}

	@Override
	public PatientUser findByEmail(String user_email) {
		
		return (PatientUser) patientdao.findByEmail(user_email);
	}
	
	/************************************************************************/

	@Override
	public PatientUser create(PatientUser patient) {
		
		
		
		return patientdao.save(patient);
	}

	@Override
	public Optional<PatientUser> delete(long id) {
		
		Optional<PatientUser> patient = findById(id); 
		if( patient != null ) {
			
			patientdao.deleteById(id);
		}
		
		return patient;
	}
	

	@Override
	public List<PatientUser> findAll() {
		
		return (List<PatientUser>) patientdao.findAll() ;
	}

	@Override
	public Optional<PatientUser> findById(long id) {
		
		return patientdao.findById(id); 
	}

	@Override
	public Users update(PatientUser patient) {
		
		return patientdao.save(patient);
	}
	
	/********************************************************************************/
	
	
}