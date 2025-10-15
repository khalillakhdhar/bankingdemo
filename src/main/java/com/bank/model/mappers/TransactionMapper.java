package com.bank.model.mappers;

import org.modelmapper.ModelMapper;

import com.bank.model.dto.TransactionDTO;
import com.bank.model.entities.Transaction;

public class TransactionMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static TransactionDTO convertToDto(Transaction transaction)
	{
		return modelMapper.map(transaction, TransactionDTO.class);
	}
	public static Transaction convertToEntity(TransactionDTO transactionDTO)
	{
		return  modelMapper.map(transactionDTO, Transaction.class);
	}
	
}
