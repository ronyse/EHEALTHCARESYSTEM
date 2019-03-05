package com.vanne.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.AdminUser;
import com.vanne.model.DoctorUser;


@Repository
public interface AdminUserDAO extends CrudRepository<AdminUser, Long>  {
	
	    AdminUser findByEmail(String user_email); 
	    Optional<AdminUser> findByUsername(String username);
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
	
}
