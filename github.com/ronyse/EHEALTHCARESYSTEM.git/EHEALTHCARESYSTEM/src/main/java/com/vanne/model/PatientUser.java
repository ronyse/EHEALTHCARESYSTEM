package com.vanne.model;

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
	
	@Column(name="marital_status", length=20, nullable=false)
	private String maritalstatus;
	
	@Column(name="dob" , nullable=false)
	private Date dob ; 
	
	
	/********************one_To_one_RelationShip_with_Patient_Bill*************************/
	
	
	@OneToOne(cascade= CascadeType.ALL)	
	@JoinColumn(name = "Bill_id" , referencedColumnName = "billid")
	private Bill patientBill ; 
	
	
	public Bill getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(Bill patientBill) {
		this.patientBill = patientBill;
	}

	/******************CONSTRUCTORS**************************************/
	
	public PatientUser() {
		
	}

	public PatientUser(String firstname, String lastname, String gender, 
			           String phonenumber, String address, String city,
			           String state, String password, String email,int active,  
			           String maritalstatus, Date dob,Bill patientBill) {
		
		super(firstname, lastname, gender, 
			   phonenumber, address, city,
				  state, password, email,active);
		
		this.maritalstatus = maritalstatus;
		this.dob = dob;
		
		this.patientBill = patientBill ; 
		
		
	}
	
	
	/****************SETTERS&&GETTERS************************************/
	

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	/********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/
	
	@OneToMany(mappedBy="patient")
	private Set<Appointment> appointmentPa = new HashSet<Appointment>() ;


    
	public Set<Appointment> getAppointmentPa() {
		return appointmentPa;
	}

	public void setAppointmentPa(Set<Appointment> appointmentPa) {
		this.appointmentPa = appointmentPa;
	} 
	
	
	
	
	
	
	
	

}
