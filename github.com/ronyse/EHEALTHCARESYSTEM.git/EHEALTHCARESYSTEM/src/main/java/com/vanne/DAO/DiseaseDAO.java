package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Disease;

@Repository
public interface DiseaseDAO extends CrudRepository<Disease, Long> {
	
	

}
