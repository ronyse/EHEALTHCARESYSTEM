package com.vanne.service;

import java.util.ArrayList;

import com.vanne.model.Doctor;

public interface DoctorServices {
	
	public int saveDoctor(Doctor doctor);
	public ArrayList<Doctor> viewDoctor(); 
	
	

}
