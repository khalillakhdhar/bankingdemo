package com.bank.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.bank.model.dto.*;
import com.bank.model.entities.Transaction;

public interface TransactionService {
public Page<TransactionDTO> getAllTransactions(Pageable pageable );
public TransactionDTO getTransactionById(long id);
public TransactionDTO addTransaction(long idSource,long idDestination,Transaction transaction);
public void updateSolde(double montant,long idCompte);

}
