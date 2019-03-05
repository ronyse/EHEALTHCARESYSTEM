package com.vanne.service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vanne.DAO.AdminUserDAO;
import com.vanne.DAO.RoleDAO;
import com.vanne.model.AdminUser;
import com.vanne.model.DoctorUser;
import com.vanne.model.Role;
import com.vanne.model.Users;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired 
	private AdminUserDAO admindao ; 
	
	@Autowired 
	private RoleDAO roledao ; 
	
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder ;
	 */ 
	
		

	/*
	 * @Override public void save(AdminUser admin) {
	 * 
	 * admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
	 * admin.setActive(3);
	 * 
	 * Role userRole = roledao.findByRoleName("ADMIN"); admin.setRoles(new
	 * HashSet<Role>(Arrays.asList(userRole))); admindao.save(admin); }
	 */

	@Override
	public AdminUser findByEmail(String ad_email) {
		
		return (AdminUser) admindao.findByEmail(ad_email);
	}

	@Override
	public AdminUser create(AdminUser admin) {
		
		return admindao.save(admin);
	}

	@Override
	public Optional<AdminUser> delete(long id) {
		
		Optional<AdminUser> admin = findById(id); 
		if( admin != null ) {
			
			admindao.deleteById(id);
		}
		
		return admin;
	}

	@Override
	public List<AdminUser> findall() {
				
		return (List<AdminUser>) admindao.findAll();
	}

	@Override
	public Optional<AdminUser> findById(long id) {
		
		return admindao.findById(id);
	}

	@Override
	public AdminUser update(AdminUser admin) {
		
		return admindao.save(admin);
	}

	@Override
	public Optional<AdminUser> findByUsername(String username) {
		// TODO Auto-generated method stub
		return admindao.findByUsername(username);
	}
	
	

}
