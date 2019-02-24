package com.vanne.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="Medecine_table")
public class Medicine {

	
	   @Id                                                                                    
	   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="medicine_generator")
	   @SequenceGenerator(name="medicine_generator",sequenceName = "med_seq", allocationSize=15)
	   @Column(name = "medId", updatable = false, nullable = false) 
	   private Long medId ; 
	   
	   @Column(name="med_name" , nullable=false)
	   private String name ; 
	   
	   @Column(name="Price", nullable=false)
	   private double price ; 
	   
	   @Column(name="Quantity" , nullable=false)
	   private long quantity ; 
	   
	   @Column(name="Supplier" , nullable=false)
	   private String supplier ;
	   
	   @Column(name="Side_effects" , nullable=false)
	   private String effects ; 
	   
	   /*************************constructor****************************************************/
	   
	   public Medicine() {
		   
	   }
	   
	   

	public Medicine(String name, double price, long quantity, String supplier, String effects) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.supplier = supplier;
		this.effects = effects;
	}


    


	public Medicine(Long medId, String name, double price, long quantity, String supplier, String effects) {
		super();
		this.medId = medId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.supplier = supplier;
		this.effects = effects;
	}


	/****************************SETTERS&GETTERS******************************************************/


	public Long getMedId() {
		return medId;
	}



	public void setMedId(Long medId) {
		this.medId = medId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}



	public String getSupplier() {
		return supplier;
	}



	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}



	public String getEffects() {
		return effects;
	}



	public void setEffects(String effects) {
		this.effects = effects;
	}



	




	/********************many_to_many_relatioships_Patient_Doctor_Medecine_=Prescription***************/
	   
	    @OneToMany(mappedBy="medicinep")
		private Set<Prescription> prescriptionMd = new HashSet<Prescription>() ;

	    public Set<Prescription> getPrescriptionMd() {
			return prescriptionMd;
		}



		public void setPrescriptionMd(Set<Prescription> prescriptionMd) {
			this.prescriptionMd = prescriptionMd;
		}

		
	
	
}
