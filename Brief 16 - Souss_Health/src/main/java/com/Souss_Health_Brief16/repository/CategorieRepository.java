package com.Souss_Health_Brief16.repository;


import com.Souss_Health_Brief16.model.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
