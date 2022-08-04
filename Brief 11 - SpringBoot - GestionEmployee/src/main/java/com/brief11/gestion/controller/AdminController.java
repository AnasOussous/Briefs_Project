package com.brief11.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brief11.gestion.model.Admin;
import com.brief11.gestion.model.Employee;
import com.brief11.gestion.service.AdminService;
import com.brief11.gestion.service.GestionService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	

	
	@GetMapping("/profile/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Admin admin = adminService.getAdminById(id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("admin", admin);
		return "info_admin";
	}
	
}
