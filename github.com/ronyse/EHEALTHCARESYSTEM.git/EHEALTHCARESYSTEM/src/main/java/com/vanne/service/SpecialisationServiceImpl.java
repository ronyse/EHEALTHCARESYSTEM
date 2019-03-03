package com.vanne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanne.DAO.DiseaseDAO;
import com.vanne.DAO.DoctorDAO;
import com.vanne.DAO.PatientDAO;
import com.vanne.DAO.SpecialisationDAO;
import com.vanne.model.Disease;
import com.vanne.model.DoctorUser;
import com.vanne.model.PatientUser;
import com.vanne.model.Specialisation;

@Service
public class SpecialisationServiceImpl implements SpecialisationService  {
	
	@Autowired
	private SpecialisationDAO spedao ; 
	
	

	@Override
	public Specialisation createSpe(Specialisation spe) {
		
		return spedao.save(spe);
	}
	

	@Override
	public Optional<Specialisation> deleteSpe(long id) {
		
		
		Optional<Specialisation> spe = findByIdSpe(id); 
		if( spe != null ) {
			
			spedao.deleteById(id);
		}
		
		return spe;
		
	}

	@Override
	public List<Specialisation> findAllSpe() {
		
		return (List<Specialisation>) spedao.findAll() ;
		
	}

	@Override
	public Optional<Specialisation> findByIdSpe(long id) {
		
		return spedao.findById(id); 
		
	}

	@Override
	public Specialisation updateSpe(Specialisation spe) {
		
		return spedao.save(spe);
		
	}

	@Override
	public void saveSpe(Specialisation spe) {
		
		spedao.save(spe);
		
	}

}
