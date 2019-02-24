package com.vanne.DAO;

//vanne
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Role;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {
	
	
	 Role findByRoleName(String Role);       
	

}
