package com.vanne.service;



import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vanne.model.Role;
import com.vanne.DAO.RoleDAO;
import com.vanne.DAO.UsersDAO;
import com.vanne.model.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired 
	private UsersDAO userdao ; 
	
	@Autowired 
	private RoleDAO roledao ; 
	
	/*
	 * @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder ;
	 * 
	 * 
	 * @Override public void save(Users user) {
	 * 
	 * user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	 * user.setActive(0);
	 * 
	 * Role userRole = roledao.findByRoleName("UNDEFINED"); 
	 * user.setRoles(new
	 * HashSet<Role>( Arrays.asList(userRole)));
	 * 
	 * userdao.save(user); }
	 */
	

	@Override
	public Users findByEmail(String email) {
		
		return userdao.findByEmail(email);
	}
	
	/************************************************************************************/

	@Override
	public Users create(Users user) {
		
		return userdao.save(user); 
	}
	

	@Override
	public Optional<Users> delete(long id) {
		
		Optional<Users> user = findById(id); 
		if( user != null ) {
			userdao.deleteById(id);
		}
		
		return user;
	}

	@Override
	public List<Users> findAll() {
		
		return (List<Users>)userdao.findAll() ;
	}
	

	@Override
	public Optional<Users> findById(long id) {
		
		return userdao.findById(id);
	}

	@Override
	public Users update(Users user) {
		
		return userdao.save(user);
	}

	@Override
	public Optional<Users> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userdao.findByUsername(username);
	}
	
	
	

}
