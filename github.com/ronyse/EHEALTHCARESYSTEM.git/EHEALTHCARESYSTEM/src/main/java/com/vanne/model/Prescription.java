package com.vanne.model;

import java.util.Date;

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
@Table(name="Prescription_table")
public class Prescription {
	
	private long prId; 
	
	private DoctorUser doctorp ; 
	private PatientUser patientp ;
	private Medicine medicinep ; 
	
	
	private Date date ;
	private String dosage ; 
	
	

    
	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prescription_generator")
	@SequenceGenerator(name="prescription_generator",sequenceName = "prc_seq", allocationSize=15)
	@Column(name = "PrcId", updatable = false, nullable = false) 
	public long getPrId() {
		return prId;
	}
	public void setPrId(long prId) {
		this.prId = prId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dotId")
	public DoctorUser getDoctorp() {
		return doctorp;
	}
	public void setDoctorp(DoctorUser doctorp) {
		this.doctorp = doctorp;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patId")
	public PatientUser getPatientp() {
		return patientp;
	}
	public void setPatientp(PatientUser patientp) {
		this.patientp = patientp;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="medId")
	public Medicine getMedicinep() {
		return medicinep;
	}
	public void setMedicinep(Medicine medicinep) {
		this.medicinep = medicinep;
	}

	@Column(name= "prc_date", nullable=false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name= "dosage", nullable=false)
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
	
	
	
	

}
