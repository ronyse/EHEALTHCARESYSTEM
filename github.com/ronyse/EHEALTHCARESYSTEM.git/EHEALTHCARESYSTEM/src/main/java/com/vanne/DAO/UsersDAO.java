package com.vanne.DAO;
//vanne


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Users;

@Repository
public interface UsersDAO extends CrudRepository<Users, Long> {
	
	
	Users findByEmail(String user_email); 
	
	
}
