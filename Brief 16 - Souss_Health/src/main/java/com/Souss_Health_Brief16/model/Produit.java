package com.Souss_Health_Brief16.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name = "produits")
public class Produit {
	
	@Id
	@Column(name = "Id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nom;
	private String description;
	private Double prix;
	private Date dateExpiration;
	private int QuantiteStock;
	
	@ManyToOne(targetEntity = Categorie.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_Id")
	private Categorie categories;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "users_Id")
	private User users;
	
	@OneToMany(mappedBy = "produits", cascade = CascadeType.ALL)
    private Set<Command> Commands = new HashSet<>();
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public int getQuantiteStock() {
		return QuantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		QuantiteStock = quantiteStock;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
