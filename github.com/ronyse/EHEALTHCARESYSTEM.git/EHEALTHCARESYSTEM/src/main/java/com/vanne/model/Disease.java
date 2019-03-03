package com.vanne.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Disease_table")
public class Disease {
	
	
	/**
	 * 
	 */
	

	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disease_generator")
	@SequenceGenerator(name="disease_generator",sequenceName = "dis_seq", allocationSize=15)
	@Column(name = "disId", updatable = false, nullable = false)     
	private long disid  ; //UUID
	
	@Column(name="disease_name" , nullable=false)
	private String name ;
	
	@Column(name="Symptom" , nullable=false)
	private String symptom ; 
	
	
	

	/********************many_to_many_relatioships_Patient_Doctor_disease_=Diagnosis***************/


	@OneToMany(mappedBy="disease")
	private Set<Diagnosis> diagnosisDo = new HashSet<Diagnosis>() ;

	public Set<Diagnosis> getDiagnosisDo() {
		return diagnosisDo;
	}

	public void setDiagnosisDo(Set<Diagnosis> diagnosisDo) {
		this.diagnosisDo = diagnosisDo;
	}
	
	/******************SETTER&GETTERS******************************************************/

	
	public Long getDisid() {
		return disid;
	}

	public void setDisid(Long disid) {
		this.disid = disid;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
	/**********************CONSTRUCTORS******************************/
	
	public Disease() {
		super(); 
	}    

	/*
	public Disease(Long disid, String name, String symptom) {
		super();
		this.disid = disid;
		this.name = name;
		this.symptom = symptom;
	}
    */
	
	/********************many_to_many_relatioships_Doctor_disease_=Specialisation***************/

	 public void addSpeciality(Specialisation spe) {
		   
		   this.speDo.add(spe); 
		   
	   }

	@OneToMany(mappedBy="disease")
	private Set<Specialisation> speDo = new HashSet<Specialisation>() ;

	public Set<Specialisation> getSpeDi() {
		return speDo;
	}

	public void setSpeDi(Set<Specialisation> speDi) {
		this.speDo = speDi;
	}
	
	
	
	

}
