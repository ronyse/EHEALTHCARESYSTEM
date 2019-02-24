package com.vanne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Admin_user")
@PrimaryKeyJoinColumn(name="admId")
public class AdminUser extends Users{
	
	
	/************************************variables**********************************/

	private String companyName ; 
	
	
	/**********************CONSTRUCTORS*********************************************/
	
	public AdminUser() {
		
	}
	
	public AdminUser( String firstname, String lastname, String gender, 
			          String phonenumber, String address, String city,
			          String state, String password, String email,int active,String companyName) {
		
		super(firstname, lastname, gender, 
				   phonenumber, address, city,
					  state, password, email,active);
		this.companyName = companyName;
	}
	

	/******************************SETTERS-&&-GETTERS************************************/
	
	@Column(name="companyName" , nullable=false)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	   
}
