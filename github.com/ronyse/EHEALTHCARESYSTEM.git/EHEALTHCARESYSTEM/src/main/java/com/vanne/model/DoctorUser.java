package com.vanne.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Doctor_user")
@PrimaryKeyJoinColumn(name="dotId")
public class DoctorUser extends Users {
	
	
	/***************************************variable***************************/
	
	@Column(name="title", nullable = false)
	private String title; 
	
   /********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/
	
	@OneToMany(mappedBy="doctor")
	private Set<Appointment> appointmentDo = new HashSet<Appointment>() ;
	
	    
		public Set<Appointment> getAppointmentDo() {
			return appointmentDo;
		}

		public void setAppointmentDo(Set<Appointment> appointmentDo) {
			this.appointmentDo = appointmentDo;
		} 
		
	
	
	/****************CONSTRUCTOR***********************************************/
	
	public DoctorUser() {
		
	}

	public DoctorUser(String firstname, String lastname, String gender, 
			          String phonenumber, String address, String city,
			          String state, String password, String email,int active, String title) {
		super(firstname, lastname, gender, 
				   phonenumber, address, city,
					  state, password, email,active);
		this.title = title;
	}
	
	/*********************SETTER-&&-GETTER***************************************/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

   
	
	
	

}
