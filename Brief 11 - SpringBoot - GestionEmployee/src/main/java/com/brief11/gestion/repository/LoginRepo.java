package com.brief11.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brief11.gestion.model.Admin;

@Repository
public interface LoginRepo extends JpaRepository<Admin, Long>{
Admin findByUsernameAndPassword(String username, String password);
 
}
