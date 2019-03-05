package com.vanne.controller;

import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vanne.DAO.RoleDAO;
import com.vanne.DAO.UsersDAO;
import com.vanne.model.PatientUser;
import com.vanne.model.Role;
import com.vanne.model.RoleName;
import com.vanne.model.Users;
import com.vanne.security.JwtProvider;
import com.vanne.security.UserPrinciple;

import message.JwtResponse;
import message.LoginForm;
import message.SignUpForm;
 
//import com.grokonez.jwtauthentication.message.request.LoginForm;
//import com.grokonez.jwtauthentication.message.request.SignUpForm;
//import com.grokonez.jwtauthentication.message.response.JwtResponse;
//import com.grokonez.jwtauthentication.model.Role;
//import com.grokonez.jwtauthentication.model.RoleName;
//import com.grokonez.jwtauthentication.model.User;
//import com.grokonez.jwtauthentication.repository.RoleRepository;
//import com.grokonez.jwtauthentication.repository.UserRepository;
//import com.grokonez.jwtauthentication.security.jwt.JwtProvider;
//import com.vanne.DAO.UsersDAO;
 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
 
    @Autowired
    AuthenticationManager authenticationManager;
 
    @Autowired
    UsersDAO userRepository;
 
    @Autowired
    RoleDAO roleRepository;
 
    @Autowired
    PasswordEncoder encoder;
 
    @Autowired
    JwtProvider jwtProvider;
 
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
        UserDetails user = (UserDetails) authentication.getPrincipal();
        
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt, user.getUsername(), user.getAuthorities()));
    }
 
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
 
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        PatientUser user = new PatientUser(signUpRequest.getFirstname(),signUpRequest.getLastname(),signUpRequest.getGender(),
        		signUpRequest.getPhonenumber(),signUpRequest.getAddress(),signUpRequest.getCity(),
        		signUpRequest.getState(),signUpRequest.getUsername(),
                 encoder.encode(signUpRequest.getPassword()) , signUpRequest.getEmail() , signUpRequest.getMaritalstatus(), 
                 LocalDate.parse(signUpRequest.getDob()) );
 
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
         switch(role) {
      case "admin":
      Role adminRole = roleRepository.findByRoleName("ADMIN")
                 .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
      roles.add(adminRole);
      
      break;
      case "doctor":
              Role pmRole = roleRepository.findByRoleName("DOCTOR")
                 .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
              roles.add(pmRole);
              
      break;
      default:
          Role userRole = roleRepository.findByRoleName("PATIENT")
                  .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
          roles.add(userRole);         
         }
        });
        
        user.setRoles(roles);
        userRepository.save(user);
 
        return ResponseEntity.ok().body("User registered successfully!");
    }
}
