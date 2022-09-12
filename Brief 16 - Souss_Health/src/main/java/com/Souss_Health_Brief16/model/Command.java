package com.Souss_Health_Brief16.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "commands")
public class Command {
	@Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate dateCommand;
    private Double total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client clients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produits_id")
    private Produit produits;

	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getDateCommand() {
		return dateCommand;
	}

	public void setDateCommand(LocalDate dateCommand) {
		this.dateCommand = dateCommand;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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

	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
