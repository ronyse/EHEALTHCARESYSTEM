package com.vanne.service;

import java.util.List;
import java.util.Optional;

import com.vanne.model.Diagnosis;

public interface DiagnosisService {
	
	
	Diagnosis createDiag(Diagnosis diag ); 
	Optional<Diagnosis> deleteDiag(long id);
	List<Diagnosis> findAllDiag(); 
	Optional<Diagnosis> findByIdDiag(); 
	
	Diagnosis update(Diagnosis diag); 
	void saveDiag(Diagnosis daig); 

}
