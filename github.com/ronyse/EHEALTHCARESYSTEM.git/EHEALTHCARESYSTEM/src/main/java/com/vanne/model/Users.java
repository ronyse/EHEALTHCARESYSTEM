package com.vanne.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity 
@Table(name="Users")
@Inheritance(strategy=InheritanceType.JOINED)
public class Users {
	
	
	/*****************variables*****************************/
	
	//***create a sequence var+number for primary key 
	
	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_generator")
	@SequenceGenerator(name="user_generator",sequenceName = "user_seq", allocationSize=15)
	@Column(name = "userid", updatable = false, nullable = false)         
	private  long  userid ; 
	
	@Column(name="firstname", length=40 , nullable=false)
	private String firstname ; 
	
	@Column(name="lastname", length=40, nullable=false)
	private String lastname ;
	
	@Column(name="gender", length=10, nullable=false)
	private String gender ; 
	
	@Column(name="phonenumber", length=20 , nullable=false)
	private String phonenumber ;
	
	@Column(name="address", length=60 , nullable=false)
	private String address ; 
	
	@Column(name="city", length=36 , nullable=false)
	private String city ; 
	
	@Column(name="state", length=30, nullable=false )
	private String state ;  
	
	@Column(name="password", length=128 , nullable=false )
	private String password ;
	
	@Column(name="email", length=55 , nullable=false)
	private String email ; 
	
	@Column(name="active", nullable=true)
	private int active ; 
	
	
	

	/********Hibernate Many-To-Many Mapping Using Annotations************/
	
	//***create a table "user_role" for the many to many relationship 
	//with column userid->Users and roleid->Role 
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role", joinColumns = { @JoinColumn(name="userid")} , inverseJoinColumns = { @JoinColumn(name="roleid") })
	private Set<Role> roles ; 
	
	
	/*****************CONSTRUCTORS**************************/
	
	public Users() {
		
	}

	public Users(String firstname, String lastname, String gender, 
			     String phonenumber, String address, String city,
			     String state, String password, String email,int active) {
		
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.password = password;
		this.email = email;
		this.active = active ; 
	}


	public Users(long userid, String firstname, String lastname, String gender, String phonenumber, String address,
			String city, String state, String password, String email,int active) {
		
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.password = password;
		this.email = email;
		this.active = active ; 
	}

	
	/************SETTERS-&&-GETTERS*************************/

	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
		

}
