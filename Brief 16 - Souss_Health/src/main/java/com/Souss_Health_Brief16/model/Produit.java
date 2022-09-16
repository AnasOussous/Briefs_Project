package com.Souss_Health_Brief16.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateExpiration;

	private int QuantiteStock;

//	@ManyToOne(targetEntity = Categorie.class)
//	@JoinColumn(name = "categories_Id")
//	private Categorie categories;

	@ManyToOne(targetEntity = Categorie.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_Id", insertable = false, updatable = false)
	@JsonIgnore
	private Categorie categories;

	@Column(name = "categories_Id")
	private Integer categorieId;
	

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

	public Categorie getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories = categories;
	}

	public Set<Command> getCommands() {
		return Commands;
	}

	public void setCommands(Set<Command> commands) {
		Commands = commands;
	}

	public Integer getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Integer categorieId) {
		this.categorieId = categorieId;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
