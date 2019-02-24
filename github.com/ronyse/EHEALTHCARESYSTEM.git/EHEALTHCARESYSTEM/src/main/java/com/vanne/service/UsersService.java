package com.vanne.service;

import java.util.List;
import java.util.Optional;
import com.vanne.model.Users;

public interface UsersService {
	
	/********METHOD_FOR_CRUD**********************/
	
	Users  create(Users user);                    
	Optional<Users> delete(long id);                
	List<Users> findAll();                        
	Optional<Users> findById(long id);             
	
	Users update(Users user);                    
	
	
	
	/****METHOD_FOR_LOGIN_*************************/
	
	void save(Users user);
	Users findByEmail(String user_email); 
	
	

}
