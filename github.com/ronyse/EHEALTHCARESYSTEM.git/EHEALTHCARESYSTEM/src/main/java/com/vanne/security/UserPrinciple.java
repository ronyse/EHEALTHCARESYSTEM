package com.vanne.security;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// import com.grokonez.jwtauthentication.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vanne.model.PatientUser;
import com.vanne.model.Users;
 
public class UserPrinciple implements UserDetails {
 private static final long serialVersionUID = 1L;
 
    private Long  userid ; 	// UUID
	
	private String firstname ; 
	
	
	private String lastname ;
	
	
	private String gender ; 
	
	
	private String phonenumber ;
	
	
	private String address ; 
	
	
	private String city ; 
	
	
	private String state ;  
	
	private String username ; 
	
    @JsonIgnore
    private String password;
    
	private String email ; 
	
	
    private String maritalstatus;
	
	private LocalDate dob ; 
    
    
 
    private Collection<? extends GrantedAuthority> authorities;
 
    public UserPrinciple(Long userid , String firstname, String lastname, String gender, 
	           String phonenumber, String address, String city,
	           String state,String username, String password, String email,  
	           String maritalstatus, LocalDate dob,
               Collection<? extends GrantedAuthority> authorities) {
        this.userid = userid;
        this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.username = username ; 
		this.password = password;
		this.email = email;
		this.maritalstatus = maritalstatus;
		this.dob = dob;
        this.authorities = authorities;
    }
 
    public static UserPrinciple build(Users user) {
    	
    	PatientUser pat = new PatientUser(); 
    	pat = (PatientUser) user ; 
    	
        List<GrantedAuthority> authorities = pat.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
 
        return new UserPrinciple(
                pat.getUserid(),
                pat.getFirstname(),
                pat.getLastname(),
                pat.getGender(),
                pat.getPhonenumber(),
                pat.getAddress(),
                pat.getCity(),
                pat.getState(),
                pat.getUsername(),
                pat.getPassword(),
                pat.getEmail(),
                pat.getMaritalstatus(),
                pat.getDob(),
                authorities
        );
    }
 
   
 
    public Long getUserid() {
		return userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getGender() {
		return gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getState() {
		return state;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(userid, user.userid);
    }
}