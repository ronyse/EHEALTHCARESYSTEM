package com.vanne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role_table")
public class Role {
	
	/*************variable*************************/
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id" , nullable=false)
	private long roleid ; 
	
	@Column(name="role_name" , nullable=false)
	private String roleName ; 
	

}
