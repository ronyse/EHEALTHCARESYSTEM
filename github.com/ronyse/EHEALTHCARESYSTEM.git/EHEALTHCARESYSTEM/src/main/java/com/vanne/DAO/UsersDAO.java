package com.vanne.DAO;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.DoctorUser;
import com.vanne.model.Users;

@Repository
public interface UsersDAO extends CrudRepository<Users, Long> {
	
	    Users findByEmail(String user_email); 
	    Optional<Users> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
	
	
}
