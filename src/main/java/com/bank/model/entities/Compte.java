package com.bank.model.entities;

import java.util.List;

import com.bank.model.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Compte extends BaseEntity {
	private double solde;
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "source")
	private List<Transaction> transactions;
}
