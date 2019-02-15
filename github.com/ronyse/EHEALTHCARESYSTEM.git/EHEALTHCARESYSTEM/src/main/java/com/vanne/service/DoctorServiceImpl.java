package com.vanne.service;

import java.util.ArrayList;

import com.vanne.DAO.DoctorDAO;
import com.vanne.DAO.DoctorDAOImpl;
import com.vanne.model.Doctor;

public class DoctorServiceImpl implements DoctorServices{
	
	DoctorDAO doctorDao ; 
	
	
	
	

	public DoctorServiceImpl() {
		super();
		this.doctorDao = new DoctorDAOImpl();
	}

	@Override
	public int saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Doctor> viewDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

}
