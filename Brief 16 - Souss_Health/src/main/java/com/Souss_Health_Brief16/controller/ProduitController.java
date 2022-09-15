package com.Souss_Health_Brief16.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.Souss_Health_Brief16.model.Produit;
import com.Souss_Health_Brief16.repository.ProduitsRepository;

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
public class ProduitController {
	
			  @Autowired
			  private ProduitsRepository produitsRepository;
              
			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/produits")     
			  public List<Produit> getAllProduits() {
			    return produitsRepository.findAll();
			  }
			  
			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/produits/{id}")
			  public ResponseEntity<Produit> getProduitsById(@PathVariable(value = "id") Long id)
			      throws ResourceNotFoundException {
				  Produit produit =
						  produitsRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Produit not found on :: " + id));
			    return ResponseEntity.ok().body(produit);
			  }
			  
			  @PreAuthorize("hasRole('ADMIN')")
			  @PostMapping("/produits") 
			  public Produit createProduit(@RequestBody Produit produit) {
			    return produitsRepository.save(produit);
			  }
			  
			  
			  @PreAuthorize("hasRole('ADMIN')")
			  @PutMapping("/produits/{id}")
			  public ResponseEntity<Produit> updateProduit(
			      @PathVariable(value = "id") Long id, @Valid @RequestBody Produit produitDetails)
			      throws ResourceNotFoundException {

				  Produit produit =
						  produitsRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Produit not found on :: " + id));
				  
				  produit.setNom(produitDetails.getNom());
				  produit.setDescription(produitDetails.getDescription());
				  produit.setDateExpiration(produitDetails.getDateExpiration());
				  produit.setPrix(produitDetails.getPrix());
				  produit.setQuantiteStock(produitDetails.getQuantiteStock());
				 
		       
			    final Produit updatedProduit = produitsRepository.save(produit);
			    return ResponseEntity.ok(updatedProduit);
			  }
			  
			  @PreAuthorize("hasRole('ADMIN')")
			  @DeleteMapping("/produits/{id}")      // done !!!!!!!!
			  public Map<String, Boolean> deleteProduit(@PathVariable(value = "id") Long id) throws Exception {
				  Produit produit =
						  produitsRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Produit not found on :: " + id));

				produitsRepository.delete(produit);
			    Map<String, Boolean> response = new HashMap<>();
			    response.put("deleted", Boolean.TRUE);
			    return response;
			  }
}
