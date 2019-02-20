package com.vanne.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Patient_user")
@PrimaryKeyJoinColumn(name="userid")
public class PatientUser extends Users {
	
	
	/******************variables*****************************************/
	
	@Column(name="marital_status", length=20, nullable=false)
	private String maritalstatus;
	
	@Column(name="dob" , nullable=false)
	private Date dob ; 
	
	@Column(name="active")
	private int active ; 
	
	
	
	/******************CONSTRUCTORS**************************************/
	
	public PatientUser() {
		
	}

	public PatientUser(String firstname, String lastname, String gender, 
			           String phonenumber, String address, String city,
			           String state, String password, String email,  
			           String maritalstatus, Date dob, int active) {
		
		super(firstname, lastname, gender, 
			   phonenumber, address, city,
				  state, password, email);
		
		this.maritalstatus = maritalstatus;
		this.dob = dob;
		this.active = active;
		
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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	
	
	
	
	
	

}
