package com.Souss_Health_Brief16.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "commands")
public class Command {
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	
	
	
//	@Temporal(TemporalType.DATE)
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private LocalDateTime dateCommand;
	
	
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  dateCommand;

	@PrePersist
	private void onCreate() {
		dateCommand = new Date();
	}
	
	
	
	
	
	
	private Double total;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "client_id")
	// private Client clients;

	@ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", insertable = false, updatable = false)
	@JsonIgnore
	private Client clients;

	@Column(name = "client_id")
	private Integer clientId;

	   
	//    @ManyToOne(fetch = FetchType.LAZY)
	//    @JoinColumn(name = "produits_id")
	//    private Produit produits;

	@ManyToOne(targetEntity = Produit.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "produits_id", insertable = false, updatable = false)
	@JsonIgnore
	private Produit produits;

	@Column(name = "produits_id")
	private Integer produitsId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	public Produit getProduits() {
		return produits;
	}

	public void setProduits(Produit produits) {
		this.produits = produits;
	}

	

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getProduitsId() {
		return produitsId;
	}

	public void setProduitsId(Integer produitsId) {
		this.produitsId = produitsId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}

}
