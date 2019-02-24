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
@Table(name="Diagnosis_table")
public class Diagnosis {
	
	
	private Long diagid ; 
	
	
	private Disease disease ; 
	private PatientUser patientd ; 
	private DoctorUser doctord ; 
	
	private String diadDetail ; 
	private Date date ;
	
	
	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="diagnosis_generator")
	@SequenceGenerator(name="diagnosis_generator",sequenceName = "diag_seq", allocationSize=15)
	@Column(name = "diagId", updatable = false, nullable = false)
	public Long getDiagid() {
		return diagid;
	}
	public void setDiagid(Long diagid) {
		this.diagid = diagid;
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
	@JoinColumn(name="patId")
	public PatientUser getPatientd() {
		return patientd;
	}
	public void setPatientd(PatientUser patientd) {
		this.patientd = patientd;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dotId")
	public DoctorUser getDoctord() {
		return doctord;
	}
	public void setDoctord(DoctorUser doctord) {
		this.doctord = doctord;
	}
	
	@Column(name="diag_details" , nullable=false)
	public String getDiadDetail() {
		return diadDetail;
	}
	public void setDiadDetail(String diadDetail) {
		this.diadDetail = diadDetail;
	}
	
	@Column(name="date_diagnosis" , nullable=false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
