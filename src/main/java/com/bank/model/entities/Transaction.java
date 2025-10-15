package com.bank.model.entities;

import com.bank.model.BaseEntity;
import com.bank.model.Types;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transaction extends BaseEntity{
private double montant;
private Types type;
@ManyToOne(optional = false,fetch = FetchType.LAZY)
private Compte source;
@ManyToOne(optional = true,fetch = FetchType.LAZY)
private Compte destination;
}
