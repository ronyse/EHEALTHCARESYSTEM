package com.vanne.service;



import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanne.DAO.DoctorDAO;
import com.vanne.DAO.RoleDAO;
import com.vanne.model.DoctorUser;
import com.vanne.model.PatientUser;
import com.vanne.model.Role;
import com.vanne.model.Users;


@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDAO doctordao ; 
	
	@Autowired
	private RoleDAO roledao ; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder ; 
	
	
	

	@Override
	public void save(DoctorUser doctor) {
		
		doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));
		doctor.setActive(2);
		
		Role userRole = roledao.findByRoleName("DOCTOR");
		doctor.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
       	doctordao.save(doctor); 
	}

	@Override
	public DoctorUser findByEmail(String doctor_email) {
			
		return (DoctorUser) doctordao.findByEmail(doctor_email);
	}

	@Override
	public DoctorUser create(DoctorUser doctor) {
		
		return doctordao.save(doctor);
	}

	@Override
	public Optional<DoctorUser> delete(long id) {
		
		Optional<DoctorUser> doctor = findById(id); 
		if( doctor != null ) {
			
			doctordao.deleteById(id);
		}
			
		return doctor;
	}

	@Override
	public List<DoctorUser> findAll() {
		
		return (List<DoctorUser>) doctordao.findAll();
	}

	@Override
	public Optional<DoctorUser> findById(long id) {
		
		return doctordao.findById(id);
	}

	@Override
	public DoctorUser update(DoctorUser doctor) {
		
		return doctordao.save(doctor);
	}
	
	
	
	
	
	
	
	

}
