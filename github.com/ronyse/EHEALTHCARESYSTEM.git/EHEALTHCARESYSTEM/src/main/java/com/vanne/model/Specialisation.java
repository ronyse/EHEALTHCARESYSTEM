package com.vanne.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Specialisation_table")
public class Specialisation {

	   private Long Speid ; 
	   
	   private Disease disease ; 
	   private DoctorUser doctorsp ;
       
	   private String experience ; 
	   private String degree ;
	   
	   
	   
	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="specialisation_generator")
	@SequenceGenerator(name="specialisation_generator",sequenceName = "spe_seq", allocationSize=15)
	@Column(name = "speId", updatable = false, nullable = false)    
	public Long getSpeid() {
		return Speid;
	}
	public void setSpeid(Long speid) {
		Speid = speid;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="disId")
	public Disease getDisease() {
		return disease;
	}
	
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dotId")
	public DoctorUser getDoctorsp() {
		return doctorsp;
	}
	public void setDoctorsp(DoctorUser doctorsp) {
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
