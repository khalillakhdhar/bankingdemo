package com.bank.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.model.dto.CompteDTO;

public interface CompteService {
	
	
public Optional<CompteDTO> getCompteById(long id);
public Page<CompteDTO> getAllCompte(Pageable pageable);
public void delete(long id);




	
	
	

}
