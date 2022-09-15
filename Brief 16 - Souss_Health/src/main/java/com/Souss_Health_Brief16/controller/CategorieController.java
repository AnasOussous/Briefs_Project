package com.Souss_Health_Brief16.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.Souss_Health_Brief16.model.Categorie;
import com.Souss_Health_Brief16.repository.CategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategorieController {
	
			  @Autowired
			  private CategorieRepository categorieRepository;
			  
			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/categories")    
			  public List<Categorie> getAllCategories() {
			    return categorieRepository.findAll();
			  }
			  
			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/categories/{id}")
			  public ResponseEntity<Categorie> getCategoriesById(@PathVariable(value = "id") Long id)
			      throws ResourceNotFoundException {
				  Categorie categorie =
						  categorieRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Categorie not found on :: " + id));
			    return ResponseEntity.ok().body(categorie);
			  }
			  
			  @PreAuthorize("hasRole('ADMIN')")
			  @PostMapping("/categories")
			  public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
			    return categorieRepository.save(categorie);
			  }
			  
			  @PreAuthorize("hasRole('ADMIN')")
			  @PutMapping("/categories/{id}")
			  public ResponseEntity<Categorie> updateCategorie(
			      @PathVariable(value = "id") Long id, @Valid @RequestBody Categorie categorieDetails)
			      throws ResourceNotFoundException {

				  Categorie categorie =
			    		categorieRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Categorie not found on :: " + id));
				  
				  categorie.setNom(categorieDetails.getNom());
		       
			    
			   
			    final Categorie updatedCategorie = categorieRepository.save(categorie);
			    return ResponseEntity.ok(updatedCategorie);
			  }
			  
			  @PreAuthorize("hasRole('ADMIN')")
			  @DeleteMapping("/categories/{id}")
			  public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long id) throws Exception {
				  Categorie categorie =
						  categorieRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Categorie not found on :: " + id));

				categorieRepository.delete(categorie);
			    Map<String, Boolean> response = new HashMap<>();
			    response.put("deleted", Boolean.TRUE);
			    return response;
			  }
			  
			  
			  
			  

}
