package com.bank.model.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Profile   {
	@Id
private long id;
	@Column(nullable = false,unique = true)
private String phoneNumber;
	@Column(nullable = false)
private String adresse;
@OneToOne(optional = false)
@MapsId
@JoinColumn(name = "iduser")
private Utilisateur utilisateur;

}
