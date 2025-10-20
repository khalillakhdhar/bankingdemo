package com.bank.services.implementation;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.model.Types;
import com.bank.model.dto.TransactionDTO;
import com.bank.model.entities.Compte;
import com.bank.model.entities.Transaction;
import com.bank.model.mappers.TransactionMapper;
import com.bank.repository.CompteRepository;
import com.bank.repository.TransactionRepository;
import com.bank.services.TransactionService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImp implements TransactionService {
private final TransactionRepository transactionRepository;
private final CompteRepository compteRepository;
	
	
	@Override
	public Page<TransactionDTO> getAllTransactions(Pageable pageable) {
		// TODO Auto-generated method stub
		return transactionRepository.findAll(pageable).map(TransactionMapper::convertToDto);
	}

	@Override
	public TransactionDTO getTransactionById(long id) {
		// TODO Auto-generated method stub
		return TransactionMapper.convertToDto(transactionRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("transaction avec l'ID " + id + " n'a pas été trouvé.")) );
	}

	
	
	
	
	@Override
	public TransactionDTO addTransaction(long idSource, long idDestination, Transaction transaction) {
		// TODO Auto-generated method stub
if(idSource!=0)
{
	Compte source=compteRepository.findById(idSource).get();
	transaction.setSource(source);

}
if(idDestination!=0)
{
	Compte destinCompte=compteRepository.findById(idDestination).get();
	transaction.setDestination(destinCompte);

}

		if(transaction.getType().equals(Types.Dépot))
				{
			updateSolde(transaction.getMontant(), idDestination);
				}
		else if(transaction.getType().equals(Types.Retrait))
		{
			updateSolde(-transaction.getMontant(), idSource);
	
		}
		else
		{
			updateSolde(-transaction.getMontant(), idSource);
			updateSolde(transaction.getMontant(), idDestination);

			
		}
		
		return TransactionMapper.convertToDto(transactionRepository.save(transaction));
	}

	@Override
	public void updateSolde(double montant, long idCompte) {
		// TODO Auto-generated method stub
		Compte cpt=compteRepository.findById(idCompte).get();
		double solde=cpt.getSolde();
		double soldefinale=solde+montant;
		cpt.setSolde(soldefinale);
		compteRepository.save(cpt);
		
		

	}

}
