package com.vanne.model;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

//@Inheritance(strategy=InheritanceType.JOINED)

@Entity 
@Table(name="Users_table")
@Inheritance(strategy=InheritanceType.JOINED)
public class Users {
	
	
	/*****************variables*****************************/
	
	//***create a sequence var+number for primary key 
	
	 //test       
	private long  userid ; 	// UUID
	
	private String firstname ; 
	
	
	private String lastname ;
	
	
	private String gender ; 
	
	
	private String phonenumber ;
	
	
	private String address ; 
	
	
	private String city ; 
	
	
	private String state ;  
	
	
	private String password ;
	
	
	private String email ; 
	
	
	private int active ; 
	
/********Hibernate Many-To-Many *********************************************************/
	
	//***create a table "user_role" for the many to many relationship 
	//with column userid->Users and roleid->Role 
	
	private Set<Role> roles = new HashSet<Role>(); 
	
	
	
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
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_generator")
	//@SequenceGenerator(name="user_generator",sequenceName = "user_seq", allocationSize=15)
	
	@Id                                                                                    
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_generator")
	@SequenceGenerator(name="user_generator",sequenceName = "user_seq", allocationSize=15)
	@Column(name = "userid", updatable = false, nullable = false) 
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Column(name="firstname", length=40 , nullable=false)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name="lastname", length=40, nullable=false)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name="gender", nullable=false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="phonenumber", length=20 , nullable=false)
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name="address", nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="city",  nullable=false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="state", length=30, nullable=false )
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name="password", length=128 , nullable=false )
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="email", length=55 , nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	@Column(name="active", nullable=false)
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
/********Hibernate Many-To-Many *********************************************************/
	
	//***create a table "user_role" for the many to many relationship 
	//with column userid->Users and roleid->Role 

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role", 
	joinColumns = { @JoinColumn(name="user_id",nullable=false, referencedColumnName = "userid")} , 
	inverseJoinColumns = { @JoinColumn(name="role_id",nullable=false ,referencedColumnName = "role_id" ) })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
		

}
