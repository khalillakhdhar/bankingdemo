package com.bank.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.model.dto.CompteDTO;
import com.bank.model.dto.ProfileDTO;
import com.bank.model.dto.UtilisateurDTO;

public interface UtilisateurService {
public UtilisateurDTO addOneUtilisateur(UtilisateurDTO utilisateurDTO);
public Page<UtilisateurDTO> getAllUtilisateur(Pageable pageable);
public Optional<UtilisateurDTO> getOneUtilisateur(long id);
public ProfileDTO assignProfileToUtilisateur(long idUser,ProfileDTO profileDTO);

public void deleteOneUtilisateur(long id);
public UtilisateurDTO assignCompteToUtilisateur(long idUser,CompteDTO compteDTO);


}
