package com.vanne.model;

//vanne

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Bill_table")
public class Bill {


	    @Id                                                                                    
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bill_generator")
	    @SequenceGenerator(name="bill_generator",sequenceName = "bill_seq", allocationSize=15)
	    @Column(name = "billid", updatable = false, nullable = false)  
        private Long billid ; 
	    
	    @Column(name="date_paid", nullable=false )
        private Date date ; 
	    
	    @Column(name="amount_paid", nullable=false)
        private double amount ; 
	    
	    @Column(name="status", nullable=false)
        private String status ; 
	    
	    
	  //  @OneToOne(mappedBy = "patientBill")
	   // private PatientUser patient;
	    
	    
        /********************many_to_many_relatioships_Patient_Doctor_Bill_=Appointment***************/
	    
	    @OneToMany(mappedBy="bill")
        private Set<Appointment> appointmentByBill = new HashSet<Appointment>(); 
        
        
        public Set<Appointment> getAppointmentByBill() {
			return appointmentByBill;
		}

		public void setAppointmentByBill(Set<Appointment> appointmentByBill) {
			this.appointmentByBill = appointmentByBill;
		}
        
        
        
        /***********************CONSTRUCTOR***********************************************/
        
        public Bill() {
        	
        }

		public Bill(Long billid, Date date, double amount, String status) {
			super();
			this.billid = billid;
			this.date = date;
			this.amount = amount;
			this.status = status;
		}

		public Bill(Date date, double amount, String status) {
			super();
			this.date = date;
			this.amount = amount;
			this.status = status;
		}

		public Long getBillid() {
			return billid;
		}

		public void setBillid(Long billid) {
			this.billid = billid;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
        
		
        /*************SETTERS&&GETTERS******************************************************/
		
		
        
        
        
	
}
