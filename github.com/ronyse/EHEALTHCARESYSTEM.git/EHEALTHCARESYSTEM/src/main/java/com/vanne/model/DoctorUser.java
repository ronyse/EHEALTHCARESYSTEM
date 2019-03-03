package com.vanne.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@PrimaryKeyJoinColumn(name="dotId")
//extends Users

@Entity
@Table(name="Doctor_user")
@PrimaryKeyJoinColumn(name="dotId")
public class DoctorUser  extends Users
{
	
	
	
	
	

	/***************************************variable***************************/
	
	
	private String title; 
	
   /********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/

	    private Set<Appointment> appointmentDo = new HashSet<Appointment>() ;
	    
	    
	/********************many_to_many_relatioships_Patient_Doctor_Medecine_=Prescription***************/
			
		private Set<Prescription> prescriptionDo = new HashSet<Prescription>() ;
	
		
	/********************many_to_many_relatioships_Patient_Doctor_disease_=Diagnosis***************/

		private Set<Diagnosis> diagnosisDo = new HashSet<Diagnosis>() ;
   
	/********************many_to_many_relatioships_Doctor_disease_=Specialisation***************/

	    private Set<Specialisation> speDo = new HashSet<Specialisation>() ;
	
	
	
	/****************CONSTRUCTOR***********************************************/
	
	public DoctorUser() {
		
	}

	public DoctorUser(String firstname, String lastname, String gender, 
		     String phonenumber, String address, String city,
		     String state, String password, String email,int active,String title) {
		super(firstname,lastname,gender, 
			     phonenumber, address, city,
			     state, password, email, active);
		
		this.title = title;
	}






	/*********************SETTER-&&-GETTER***************************************/
	
	
	

	@Column(name="title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
/********************many_to_many_relatioships_Patient_Doctor_Medecine_=Prescription***************/
	
	@OneToMany(mappedBy="doctorp")
    public Set<Prescription> getPrescriptionDo() {
	     return prescriptionDo;
   }

   public void setPrescriptionDo(Set<Prescription> prescriptionDo) {
	this.prescriptionDo = prescriptionDo;
  }


/********************many_to_many_relatioships_Patient_Doctor_disease_=Diagnosis***************/

   @OneToMany(mappedBy="doctord")
   public Set<Diagnosis> getDiagnosisDo() {
	 return diagnosisDo;
   }

   public void setDiagnosisDo(Set<Diagnosis> diagnosisDo) {
	   this.diagnosisDo = diagnosisDo;
   }

   
/********************many_to_many_relatioships_Doctor_disease_=Specialisation***************/

  
   
   public void addSpeciality(Specialisation spe) {
	   
	   this.speDo.add(spe); 
	   
   }
   
   
   @OneToMany(mappedBy="doctorsp")
   public Set<Specialisation> getSpeDo() {
	 return speDo;
   }

   public void setSpeDo(Set<Specialisation> speDo) {
	  this.speDo = speDo;
   }
   

/********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/

     @OneToMany(mappedBy="doctor")
     public Set<Appointment> getAppointmentDo() {
	   return appointmentDo;
     }

    public void setAppointmentDo(Set<Appointment> appointmentDo) {
	   this.appointmentDo = appointmentDo;
    } 	
	

}
