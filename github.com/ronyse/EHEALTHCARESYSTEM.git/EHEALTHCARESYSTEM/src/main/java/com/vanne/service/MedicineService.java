package com.vanne.service;

import java.util.List;
import java.util.Optional;

import com.vanne.model.Medicine;

public interface MedicineService {
	
	Medicine createMed( Medicine med );
	Optional<Medicine> delete(long id);
	List<Medicine> findAllMed();
	Optional<Medicine> FindById(); 
	
	Medicine updateMed(Medicine med);
	void saveMed(Medicine med);
	

}
