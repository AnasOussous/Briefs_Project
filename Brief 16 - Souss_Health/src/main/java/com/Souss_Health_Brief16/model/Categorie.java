package com.Souss_Health_Brief16.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
//	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "users_Id")
//	private User users;


    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_Id", insertable = false, updatable = false)
    @JsonIgnore
    private User users;

    @Column(name = "users_Id")
    private Integer usersId;
    
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
	
	
	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
