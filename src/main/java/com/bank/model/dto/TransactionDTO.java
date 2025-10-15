package com.bank.model.dto;

import com.bank.model.Types;

import lombok.Data;
@Data
public class TransactionDTO extends BaseDto{
	private double montant;
	private Types type;
	private CompteDTO source;
	private CompteDTO desting;
}
