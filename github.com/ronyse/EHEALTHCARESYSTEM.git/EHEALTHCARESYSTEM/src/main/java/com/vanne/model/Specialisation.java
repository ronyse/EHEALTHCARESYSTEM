package com.vanne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Specialisation_table")
public class Specialisation {

	   private long speid ; 
	   
	   private long disease ; 
	   private long doctorsp ; 
	   
	   private String experience ; 
	   private String degree ;
	   
	   public Specialisation() {
		   
	   }
	
	




	public Specialisation(long disease, long doctorsp, String experience, String degree) {
		super();
		this.disease = disease;
		this.doctorsp = doctorsp;
		this.experience = experience;
		this.degree = degree;
	}


	public Specialisation(long speid, long disease, long doctorsp, String experience, String degree) {
		super();
		this.speid = speid;
		this.disease = disease;
		this.doctorsp = doctorsp;
		this.experience = experience;
		this.degree = degree;
	}






	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="specialisation_generator")
	@SequenceGenerator(name="specialisation_generator",sequenceName = "spe_seq", allocationSize=15)
	@Column(name = "speid", updatable = false, nullable = false)    
	public long getSpeid() {
		return speid;
	}

	public void setSpeid(long speid) {
		this.speid = speid;
	}
	
	
	@Column(name = "Disease_ID")
	public long getDisease() {
		return disease;
	}
	

	public void setDisease(long disease) {
		this.disease = disease;
	}
	
	@Column(name = "Doctor_ID")
	public long getDoctorsp() {
		return doctorsp;
	}
	public void setDoctorsp(long doctorsp) {
		this.doctorsp = doctorsp;
	}
	
	@Column(name="Experience", nullable=false)
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Column(name="Degree" , nullable=false)
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}

	
	
	
	
	   
	   

	
	
	
	
	
	
}
