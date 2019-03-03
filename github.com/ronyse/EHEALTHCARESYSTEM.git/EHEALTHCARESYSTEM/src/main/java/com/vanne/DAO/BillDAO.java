package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Bill;

@Repository
public interface BillDAO extends CrudRepository<Bill, Long>{
	
	

}
