package com.bank.model.mappers;

import org.modelmapper.ModelMapper;

import com.bank.model.dto.UtilisateurDTO;
import com.bank.model.entities.Utilisateur;

public class UtilisateurMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static UtilisateurDTO convertToDto(Utilisateur utilisateur)
	{
		return modelMapper.map(utilisateur, UtilisateurDTO.class);
	}
	public static Utilisateur convertToEntity(UtilisateurDTO utilisateurDTO)
	{
		return  modelMapper.map(utilisateurDTO, Utilisateur.class);
	}
	

}
