package com.rest.brief.project.stc.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Entity
@DiscriminatorValue("Administrateur")
@EqualsAndHashCode(callSuper = true)
public class Administrateur extends Utilisateur{
	@Column
    private String etat;
}
