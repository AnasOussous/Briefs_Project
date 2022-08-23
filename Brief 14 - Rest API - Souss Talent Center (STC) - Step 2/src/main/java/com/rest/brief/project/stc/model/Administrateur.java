package com.rest.brief.project.stc.model;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Utilisateur{
	@Column
    private String etat;
}
