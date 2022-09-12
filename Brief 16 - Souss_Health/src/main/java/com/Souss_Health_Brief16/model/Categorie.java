package com.Souss_Health_Brief16.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "categories")
public class Categorie {
	@Id
	@Column(name = "Id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nom;
	
	@OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
	private Set<Produit> produits;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
