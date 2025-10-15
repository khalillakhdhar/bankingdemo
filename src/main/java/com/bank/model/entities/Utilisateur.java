package com.bank.model.entities;

import java.util.List;

import com.bank.model.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity

@Data
public class Utilisateur extends BaseEntity{
	@Column(nullable = false)
	private String  nom;
	@Column(unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@OneToOne(mappedBy = "utilisateur",cascade = CascadeType.ALL)
	private Profile profile;
	@OneToMany(mappedBy = "utilisateur")
	
	private List<Compte> comptes;
	
	

}
