package com.vanne.model;



import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Patient_user")
@PrimaryKeyJoinColumn(name="patId")
public class PatientUser extends Users {
	
	
	/******************variables*****************************************/
	
	
	private String maritalstatus;
	
	private LocalDate dob ; 
	
	/********************one_To_one_RelationShip_with_Patient_Bill*************************/
	
	private Bill patientBill ; 
	
  /********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/
	
	private Set<Appointment> appointmentPa = new HashSet<Appointment>() ;
	
  /********************many_to_many_relatioships_Patient_Doctor_Medecine_=Prescription***************/
	
    private Set<Prescription> prescriptionPa = new HashSet<Prescription>() ;	
    
 /********************many_to_many_relatioships_Patient_Doctor_disease_=Diagnosis***************/
	
	private Set<Diagnosis> diagnosisPa = new HashSet<Diagnosis>() ;  
    
	
	
  /******************CONSTRUCTORS**************************************/
	
	public PatientUser() {
		
	}

	public PatientUser(String firstname, String lastname, String gender, 
			           String phonenumber, String address, String city,
			           String state,String username, String password, String email,  
			           String maritalstatus, LocalDate dob,Bill patientBill) {
		
		super(firstname, lastname, gender, 
			   phonenumber, address, city,
				  state, username, password, email);
		
		this.maritalstatus = maritalstatus;
		this.dob = dob;
		
		this.patientBill = patientBill ; 
		
		
	}
	
	public PatientUser(String firstname, String lastname, String gender, 
	           String phonenumber, String address, String city,
	           String state,String username, String password, String email,  
	           String maritalstatus, LocalDate dob) {

super(firstname, lastname, gender, 
	   phonenumber, address, city,
		  state, username, password, email);

this.maritalstatus = maritalstatus;
this.dob = dob;

//this.patientBill = patientBill ; 


}
	
	
	/****************SETTERS&&GETTERS************************************/
	
	@Column(name="marital_status", length=20, nullable=true)
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	@Column(name="dob" , nullable=true)
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	/********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/
	
	@OneToMany(mappedBy="patient")
	public Set<Appointment> getAppointmentPa() {
		return appointmentPa;
	}
	public void setAppointmentPa(Set<Appointment> appointmentPa) {
		this.appointmentPa = appointmentPa;
	} 
	
   /********************many_to_many_relatioships_Patient_Doctor_Medecine_=Prescription***************/
		
	@OneToMany(mappedBy="patientp")
	public Set<Prescription> getPrescriptionPa() {
		return prescriptionPa;
	}
	public void setPrescriptionPa(Set<Prescription> prescriptionPa) {
		this.prescriptionPa = prescriptionPa;
	}


	/********************many_to_many_relatioships_Patient_Doctor_disease_=Diagnosis***************/
	
	@OneToMany(mappedBy="patientd")
	public Set<Diagnosis> getDiagnosisPa() {
		return diagnosisPa;
	}

	public void setDiagnosisPa(Set<Diagnosis> diagnosisPa) {
		this.diagnosisPa = diagnosisPa;
	}
	
   /********************one_To_one_RelationShip_with_Patient_Bill*************************/
	
	@OneToOne(cascade= CascadeType.ALL)	
	@JoinColumn(name = "Bill_id" , referencedColumnName = "billid")
	public Bill getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(Bill patientBill) {
		this.patientBill = patientBill;
	}
	
	

}
