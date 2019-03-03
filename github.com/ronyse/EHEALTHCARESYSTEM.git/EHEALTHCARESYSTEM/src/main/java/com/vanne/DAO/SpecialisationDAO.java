package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Specialisation;

@Repository
public interface SpecialisationDAO extends CrudRepository<Specialisation, Long> {

}
