package com.vanne.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Role_table")
public class Role {
	
	/*************variable*************************/
	
	
	private long roleid ; 	
	private String roleName ;
	
	private Set<Users> groups = new HashSet<Users>();
	
	
	
	public Role() {}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id" , nullable=false)
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	
	@Column(name="role_name" , nullable=false)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	@ManyToMany(mappedBy = "roles")
	public Set<Users> getGroups() {
		return groups;
	}

	public void setGroups(Set<Users> groups) {
		this.groups = groups;
	} 
	
    
	
	
}
