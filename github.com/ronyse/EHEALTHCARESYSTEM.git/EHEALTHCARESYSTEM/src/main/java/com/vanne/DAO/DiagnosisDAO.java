package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Diagnosis;

@Repository
public interface DiagnosisDAO extends  CrudRepository<Diagnosis, Long> {

}
