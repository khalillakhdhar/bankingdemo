package com.bank.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UtilisateurDTO  extends BaseDto{
@NotBlank(message = "le nom et prénom ne doivent pas être null")

private String nom,prenom;
@Email(message = "donnez un email valide")
@NotBlank
private String email;
@Size(min = 8)
@JsonIgnoreProperties(allowSetters = true,value = "password",allowGetters = false)

private String password;
@JsonIgnoreProperties("utilisateur")
private List<CompteDTO> comptes;
@JsonIgnoreProperties("utilisateur")
private ProfileDTO profile;
}
