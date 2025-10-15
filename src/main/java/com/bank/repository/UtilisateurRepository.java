package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
