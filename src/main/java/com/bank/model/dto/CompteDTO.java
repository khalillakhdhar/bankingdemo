package com.bank.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class CompteDTO  extends BaseDto{
private double solde;
@JsonIgnoreProperties("comptes")
private UtilisateurDTO utilisateur;
@JsonIgnoreProperties("source")
private List<TransactionDTO> transactions;

}
