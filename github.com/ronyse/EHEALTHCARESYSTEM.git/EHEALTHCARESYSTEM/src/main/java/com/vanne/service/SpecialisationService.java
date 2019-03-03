package com.vanne.service;

import java.util.List;
import java.util.Optional;


import com.vanne.model.Specialisation;

public interface SpecialisationService {

	Specialisation createSpe(Specialisation spe);
	
	
	Optional<Specialisation> deleteSpe(long id);
	List<Specialisation> findAllSpe();
	Optional<Specialisation> findByIdSpe(long id);
	
	Specialisation updateSpe(Specialisation spe);
	void saveSpe(Specialisation spe);
	    
}
