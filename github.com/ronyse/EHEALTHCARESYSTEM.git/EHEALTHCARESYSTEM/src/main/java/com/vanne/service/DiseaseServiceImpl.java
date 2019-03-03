package com.vanne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanne.DAO.DiseaseDAO;
import com.vanne.model.Disease;
import com.vanne.model.PatientUser;

@Service
public class DiseaseServiceImpl implements DiseaseService {
	
	@Autowired
	private DiseaseDAO diseasedao ; 

	@Override
	public Disease createDis(Disease dis) {
		
		
		
		return diseasedao.save(dis); 
	}

	@Override
	public Optional<Disease> deleteDis(long id) {
		
		Optional<Disease> disease = findByIdDis(id); 
		if( disease != null ) {
			
			diseasedao.deleteById(id);
		}
		
		return disease;
		
		
	}

	@Override
	public List<Disease> findAllDis() {
		
		return (List<Disease>) diseasedao.findAll() ;
	}

	@Override
	public Optional<Disease> findByIdDis(long id) {
		
		return diseasedao.findById(id); 
	}

	@Override
	public Disease updateDis(Disease dis) {
		
		return diseasedao.save(dis);
	}

	@Override
	public void saveDis(Disease dis) {
		
		diseasedao.save(dis); 
		
	}

}
