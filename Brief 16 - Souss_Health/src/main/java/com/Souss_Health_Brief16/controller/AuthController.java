package com.Souss_Health_Brief16.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.Souss_Health_Brief16.model.Admin;
import com.Souss_Health_Brief16.model.Client;
import com.Souss_Health_Brief16.model.ERole;
import com.Souss_Health_Brief16.model.Role;
import com.Souss_Health_Brief16.payload.request.LoginRequest;
import com.Souss_Health_Brief16.payload.request.SignupRequest;
import com.Souss_Health_Brief16.payload.response.JwtResponse;
import com.Souss_Health_Brief16.payload.response.MessageResponse;
import com.Souss_Health_Brief16.repository.RoleRepository;
import com.Souss_Health_Brief16.repository.UserRepository;
import com.Souss_Health_Brief16.security.jwt.JwtUtils;
import com.Souss_Health_Brief16.security.service.UserDetailsImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	  
	  
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	  
	  
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Username is already taken!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email is already in use!"));
	    }
         
	   
						   
	    Admin admin = new Admin(signUpRequest.getNom(),
	    		signUpRequest.getPrenom(),
	    		signUpRequest.getTelephone(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getUsername(),
	    		encoder.encode(signUpRequest.getPassword()));
	    
	    
	    Client client = new Client(signUpRequest.getNom(),
	    		signUpRequest.getPrenom(),
	    		signUpRequest.getTelephone(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getUsername(),
	    		encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	    	 Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
	    	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	    	      roles.add(clientRole);
	    	      client.setRoles(roles);
	  		    userRepository.save(client);
	    	
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);
	          
	          admin.setRoles(roles);
	  	    userRepository.save(admin);
	         break;
	        case "client":
	          Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(clientRole);
	          client.setRoles(roles);
			    userRepository.save(client);
	  	    
	        }
	      });
	    }

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
	  

}
