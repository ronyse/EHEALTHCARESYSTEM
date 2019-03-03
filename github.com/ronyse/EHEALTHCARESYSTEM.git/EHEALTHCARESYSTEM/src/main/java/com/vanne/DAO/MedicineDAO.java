package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Medicine;

@Repository
public interface MedicineDAO extends CrudRepository<Medicine, Long> {

}
