package com.Souss_Health_Brief16.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends User{
	
	private String adresse;
	
	@OneToMany(mappedBy = "clients", cascade = CascadeType.ALL)
    private Set<Command> commands;

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
