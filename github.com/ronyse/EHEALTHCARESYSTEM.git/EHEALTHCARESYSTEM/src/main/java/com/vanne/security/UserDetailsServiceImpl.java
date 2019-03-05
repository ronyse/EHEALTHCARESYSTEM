package com.vanne.security;

//import com.grokonez.jwtauthentication.model.User;
//import com.grokonez.jwtauthentication.repository.UserRepository;
import com.vanne.DAO.UsersDAO;
import com.vanne.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    UsersDAO userRepository;
 
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
     
        Users user = userRepository.findByUsername(username)
                 .orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );
 
        return UserPrinciple.build(user);
    }
}