package com.Souss_Health_Brief16.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
	@Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
	@Enumerated(EnumType.STRING)
    private ERole type;
	
	@ManyToMany(mappedBy = "roles")
    private List<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public ERole getType() {
		return type;
	}

	public void setType(ERole type) {
		this.type = type;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	

	

	
    
    
}
