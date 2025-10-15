package com.bank.services.implementation;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.model.dto.CompteDTO;
import com.bank.model.entities.Compte;
import com.bank.model.mappers.CompteMapper;
import com.bank.repository.CompteRepository;
import com.bank.services.CompteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CompteServiceImp implements CompteService{
	
	private  final CompteRepository compteRepository;

	@Override
	public Optional<CompteDTO> getCompteById(long id) {
	
		return compteRepository.findById(id).map(CompteMapper::convertToDto);
		
	}

	@Override
	public Page<CompteDTO> getAllCompte(Pageable pageable) {
		
		Page<Compte> comptes=compteRepository.findAll(pageable);
		
		return  comptes.map(CompteMapper::convertToDto);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		compteRepository.deleteById(id);
		
	}

}
