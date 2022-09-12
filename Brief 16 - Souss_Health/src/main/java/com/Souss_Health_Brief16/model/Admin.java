package com.Souss_Health_Brief16.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
