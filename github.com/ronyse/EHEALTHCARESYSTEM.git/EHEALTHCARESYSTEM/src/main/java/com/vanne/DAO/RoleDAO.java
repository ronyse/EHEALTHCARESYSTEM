package com.vanne.DAO;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Role;
import com.vanne.model.RoleName;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {
	
	
	 Optional<Role> findByRoleName(String Role);   
	 //Optional<Role> findByRoleName(RoleName roleName);
	 
	

}
