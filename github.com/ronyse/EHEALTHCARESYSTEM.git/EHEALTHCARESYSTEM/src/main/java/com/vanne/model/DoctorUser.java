package com.vanne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Doctor_user")
@PrimaryKeyJoinColumn(name="userid")
public class DoctorUser extends Users {
	
	
	/***************************************variable***************************/
	
	@Column(name="title", nullable = false)
	private String title; 
	
	
	/****************CONSTRUCTOR***********************************************/
	
	public DoctorUser() {
		
	}

	public DoctorUser(String firstname, String lastname, String gender, 
			          String phonenumber, String address, String city,
			          String state, String password, String email,String title) {
		super();
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
