package com.brief11.gestion.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brief11.gestion.model.Admin;
import com.brief11.gestion.repository.AdminRepo;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private AdminRepo admininfo;
	


	@Override
	public Admin getAdminById(long id) {
		Optional<Admin> optional = admininfo.findById(id);
		Admin admin = null;
		if (optional.isPresent()) {
			admin = optional.get();
		} else {
			throw new RuntimeException(" Admin not found for id :: " + id);
		}
		return admin;
	}
 
}

