package com.vanne.service;

import java.util.List;
import java.util.Optional;

import com.vanne.model.Appointment;

public interface AppointmentService {
	
	List<Appointment> findAllApp() ;
	
	Appointment createApp(Appointment new_app); 
	
	Optional<Appointment> findByIdApp(long id) ; 
	
	void saveApp(Appointment app); 
	Appointment updateApp(Appointment app );
	
	//Appointment findByPatientIdApp(long patient_id) ;
	//Appointment findByPatientNameApp(String Patient_name);
	//Appointment findByDoctorname(String doctor_name);
	//Appointment findByCity(String city);
	//Appointment findByState(String state);
	//Appointment findByStateAndCity(String state , String city);
	//Appointment findByDate(Date date);
	//Appointment findByTime(String time);

}
