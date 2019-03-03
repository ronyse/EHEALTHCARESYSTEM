package com.vanne.service;

import java.util.List;
import java.util.Optional;

import com.vanne.model.Disease;

public interface DiseaseService { 
	
	Disease createDis(Disease dis); 
	Optional<Disease> deleteDis(long id); 
	List<Disease> findAllDis(); 
	Optional<Disease> findByIdDis(long id);
	
	Disease updateDis(Disease dis);
	void saveDis(Disease dis);

}
