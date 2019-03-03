package com.vanne.service;

import java.util.List;
import java.util.Optional;

import com.vanne.model.Prescription;

public interface PrescriptionService {
	
	Prescription createPrc(Prescription prc);
	Optional<Prescription> deletePrc(long id); 
	List<Prescription> findAllPrc(long id);
	Optional<Prescription> findByIdPrc(long id); 
	
	Prescription updatePrc(Prescription prc);
	void save(Prescription prc);
	

}
