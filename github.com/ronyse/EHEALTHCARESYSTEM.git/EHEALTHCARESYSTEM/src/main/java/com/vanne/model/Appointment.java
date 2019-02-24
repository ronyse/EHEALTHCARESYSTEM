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
@Table(name="Appointment_table")
public class Appointment {
	
	//vanne
	private long Appid ;
		
	private PatientUser patient ; 
	private DoctorUser doctor ; 
	private Bill bill ; 
	
	private Date date ; 
	private String time ;
	private String duration ;
	private Boolean cancel ;
	
	
	
	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="appointment_generator")
	@SequenceGenerator(name="appointment_generator",sequenceName = "apt_seq", allocationSize=15)
	@Column(name = "Appid", updatable = false, nullable = false)     
	public long getAppid() {
		return Appid;
	}
	
	public void setAppid(long appid) {
		Appid = appid;
	}
	
	/********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/
	
	
	
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patId")
	public PatientUser getPatient() {
		return patient;
	}

	public void setPatient(PatientUser patient) {
		this.patient = patient;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dotId")
	public DoctorUser getDoctor() {
		return doctor;
	}

	

	

	public void setDoctor(DoctorUser doctor) {
		this.doctor = doctor;
	}
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="billid")
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
	/*******************************************************************************************/
	
	@Column(name= "apt_date", nullable=false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="apt_time", nullable=false)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Column(name="duration", nullable=false)
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Column(name="cancel", nullable=true)
	public Boolean getCancel() {
		return cancel;
	}
	public void setCancel(Boolean cancel) {
		this.cancel = cancel;
	} 
	
	
	

}
