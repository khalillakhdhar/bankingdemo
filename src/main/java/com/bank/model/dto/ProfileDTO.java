package com.bank.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ProfileDTO {
private String phoneNumber;
private String adresse;
@JsonIgnoreProperties("profile")
private UtilisateurDTO utilisateur;
}
