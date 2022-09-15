package com.Souss_Health_Brief16.repository;


import com.Souss_Health_Brief16.model.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitsRepository  extends JpaRepository<Produit, Long>{
	
			 
}
