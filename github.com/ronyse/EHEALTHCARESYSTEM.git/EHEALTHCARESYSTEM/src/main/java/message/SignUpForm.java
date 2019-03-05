package message;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpForm {
	
	
   
	@NotBlank
	private String firstname ; 
	
	@NotBlank
	private String lastname ;
	
	@NotBlank
	private String gender ; 
	
	@NotBlank
	private String phonenumber ;
	
	@NotBlank
	private String address ; 
	
	@NotBlank
	private String city ; 
	
	@NotBlank
	private String state ;  
	

	 
	    @NotBlank
	    @Size(min = 3, max = 50)
	    private String username;
	    
	    @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;
	 
	    @NotBlank
	    @Size(max = 60)
	    @Email
	    private String email;
	    
	    
	    @NotBlank
	    private String maritalstatus;
		
		private String dob ;
	    
	    
	    
	    private Set<String> role;
	    
	  
	 
	 
	    public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	    public String getEmail() {
	        return email;
	    }
	 
	    public void setEmail(String email) {
	        this.email = email;
	    }
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public Set<String> getRole() {
	     return this.role;
	    }
	    
	    public void setRole(Set<String> role) {
	     this.role = role;
	    }

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getMaritalstatus() {
			return maritalstatus;
		}

		public void setMaritalstatus(String maritalstatus) {
			this.maritalstatus = maritalstatus;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}
	
	
	
	

}
