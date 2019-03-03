package com.vanne.service;

import java.util.List;
import java.util.Optional;

import com.vanne.model.Bill;

public interface BillService {

	  Bill createBill(Bill bill); 
	  Optional<Bill> deleteBill(long id);
	  List<Bill> findAllBill() ; 
	  Bill updateBill(Bill bill); 
	  void saveBill(Bill bill ); 
	
	
}
