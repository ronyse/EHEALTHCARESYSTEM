package com.vanne.service;


//vanne

import java.util.List;
import java.util.Optional;


import com.vanne.model.AdminUser;
import com.vanne.model.Users;


public interface AdminService {
	
	//svoid save(AdminUser admin); 
	AdminUser findByEmail(String ad_email); 
	
	
	AdminUser  create(AdminUser admin);                    
	Optional<AdminUser> delete(long id);                
	List<AdminUser> findall();                        
	Optional<AdminUser> findById(long id);             
	
	AdminUser update(AdminUser admin);  
	
	Optional<AdminUser> findByUsername(String username);

}
