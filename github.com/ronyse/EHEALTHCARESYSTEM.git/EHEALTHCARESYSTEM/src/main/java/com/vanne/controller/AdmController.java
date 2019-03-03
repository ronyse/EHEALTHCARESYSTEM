package com.vanne.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanne.model.Disease;
import com.vanne.model.DoctorUser;
import com.vanne.model.PatientUser;
import com.vanne.model.Specialisation;
import com.vanne.model.Users;
import com.vanne.service.AdminService;
import com.vanne.service.DiseaseService;
import com.vanne.service.DoctorService;
import com.vanne.service.PatientService;
import com.vanne.service.SpecialisationService;

@CrossOrigin(origins = "*", maxAge= 3600)
@RestController
@RequestMapping("/admin")
public class AdmController {
	
	/*
	 * @Autowired private AdminService admservice ;
	 */
	
	@Autowired
	private DoctorService doctservice ;
	
	
	@Autowired 
	private PatientService patservice;
	 
	@Autowired
	private DiseaseService disservice ; 
	
	@Autowired
	private SpecialisationService speservice; 
	
	
    /******************ON_DOCTOR_OPERATION**************************************/
	
	@PostMapping("/addoct")
	public DoctorUser createDoctor(@RequestBody DoctorUser doctor) {
		
		return doctservice.create(doctor); 		
	} 
	
	
	
    
	@GetMapping("/doct/{id}")
	public Optional<DoctorUser> findByIdDoctor(@PathVariable("id") long id) {
		
		return doctservice.findById(id); 
		
	}
	
	
	@PutMapping("/eddoct")
	public DoctorUser updateDoctor(@RequestBody DoctorUser doctor) {
		
		return doctservice.update(doctor) ; 
		
	}
	
	
     
	@DeleteMapping("/deldoct/{id}")
	public boolean deleteDoctor(@PathVariable("id") long id) {
		
		doctservice.delete(id);
		return true ; 
	}
	
	
	
	
	@GetMapping("/alldoct")
	public List<DoctorUser> findAllDoctor() {
		
		List<DoctorUser> dl = doctservice.findAll() ; 
		Iterator li = dl.listIterator(); 
		
		while( li.hasNext() ) {
			DoctorUser d = ( DoctorUser ) li.next() ;
			
			System.out.println( d.getUserid() );
		}
		
		return doctservice.findAll(); 
		
	}
	
	/**************************END_Doctor_OPERATION*****************************/
	
	
	
	 /******************ON_PATIENT_OPERATION**************************************/
	
		@PostMapping("/adpat")
		public PatientUser createPatient(@RequestBody PatientUser patient) {
			
			return patservice.create(patient); 		
		} 
		
		
		
	    
		@GetMapping("/pat/{id}")
		public Optional<PatientUser> findByIdPatient(@PathVariable("id") long id) {
			
			return patservice.findById(id); 
			
		}
		
		
		@PutMapping("/edpat")
		public PatientUser updatePatient(@RequestBody PatientUser doctor) {
			
			return patservice.update(doctor) ; 
			
		}
		
		
	     
		@DeleteMapping("/delpat/{id}")
		public boolean deletePatient(@PathVariable("id") long id) {
			
			patservice.delete(id);
			return true ; 
		}
		
		
		
		
		@GetMapping("/allpat")
		public List<PatientUser> findAllPatient() {
			
			List<PatientUser> dl = patservice.findAll() ; 
			Iterator li = dl.listIterator(); 
			
			while( li.hasNext() ) {
				PatientUser d = ( PatientUser ) li.next() ;
				
				System.out.println( d.getUserid() );
			}
			
			return patservice.findAll(); 
			
		}
		
		/**************************END_Doctor_OPERATION*****************************/
		
	
		  /******************ON_DISEASE_OPERATION**************************************/
		
		@PostMapping("/addis")
		public Disease createDisease(@RequestBody Disease disease) {
			
			return disservice.createDis(disease); 		
		} 
		
		
		
	    
		@GetMapping("/dis/{id}")
		public Optional<Disease> findByIdDis(@PathVariable("id") long id) {
			
			return disservice.findByIdDis(id); 
			
		}
		
		
		@PutMapping("/edtdis")
		public Disease updateDisease(@RequestBody Disease disease) {
			
			return disservice.updateDis(disease) ; 
			
		}
		
		
	     
		@DeleteMapping("/deldis/{id}")
		public boolean deleteDisease(@PathVariable("id") long id) {
			
			disservice.deleteDis(id);
			return true ; 
		}
		
		
		
		
		@GetMapping("/alldis")
		public List<Disease> findAllDisease() {
			
			List<Disease> dl = disservice.findAllDis() ; 
			Iterator li = dl.listIterator(); 
			
			while( li.hasNext() ) {
				Disease d = ( Disease ) li.next() ;
				
				System.out.println( d.getDisid() );
			}
			
			return disservice.findAllDis(); 
			
		}
		
		/**************************END_Disease_OPERATION*****************************/
		
	
       /******************ON_SPECIALISATION_OPERATION**************************************/
		
		@PostMapping("/addspe")
		public Specialisation createSpecialisation(@RequestBody Specialisation spe) {
			
			return speservice.createSpe(spe); 		
		} 
		
		
		
	    
		@GetMapping("/spe/{id}")
		public Optional<Specialisation> findByIdSpe(@PathVariable("id") long id) {
			
			return speservice.findByIdSpe(id); 
			
		}
		
		
		@PutMapping("/edtspe")
		public Specialisation updateSpe(@RequestBody Specialisation spe) {
			
			return speservice.updateSpe(spe) ; 
			
		}
		
		
	     
		@DeleteMapping("/delspe/{id}")
		public boolean deleteSpe(@PathVariable("id") long id) {
			
			speservice.deleteSpe(id);
			return true ; 
		}
		
		
		
		
		@GetMapping("/allspe")
		public List<Specialisation> findAllSpe() {
			
			
			
			return speservice.findAllSpe(); 
			
		}
		
		
		
   /**************************END_Specialisation_OPERATION*****************************/
		
		
	
	

}
