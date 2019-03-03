package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Prescription;

@Repository
public interface PrescriptionDAO extends   CrudRepository<Prescription, Long> {

}
