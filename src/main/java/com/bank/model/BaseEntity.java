package com.bank.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity { 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private LocalDateTime createdAt,updatedAt;
@PrePersist
public void init()
{
createdAt=updatedAt=LocalDateTime.now();	
}
@PreUpdate
public void onUpdate()
{
updatedAt=LocalDateTime.now();	
}



}
