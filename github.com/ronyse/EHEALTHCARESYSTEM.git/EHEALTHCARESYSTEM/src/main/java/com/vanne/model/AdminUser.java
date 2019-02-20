package com.vanne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin_user")
@PrimaryKeyJoinColumn(name="userid")
public class AdminUser extends Users{
	
	
	/************************************variables**********************************/

	@Column(name="companyName" , nullable=false)
	private String companyName ; 
	
	
	/**********************CONSTRUCTORS*********************************************/
	
	public AdminUser() {
		
	}
	
	

	public AdminUser( String firstname, String lastname, String gender, 
			          String phonenumber, String address, String city,
			          String state, String password, String email,String companyName) {
		super();
		this.companyName = companyName;
	}
	

	/******************************SETTERS-&&-GETTERS************************************/
	   
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	   
}
