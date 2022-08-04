package com.brief11.gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brief11.gestion.model.Admin;
import com.brief11.gestion.repository.LoginRepo;

 
 
@Service
public class LoginService {
@Autowired
private LoginRepo repo;
  
  public Admin login(String username, String password) {
  Admin user = repo.findByUsernameAndPassword(username, password);
   return user;
  }
 
}
