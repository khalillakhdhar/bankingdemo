package com.bank.model.mappers;

import org.modelmapper.ModelMapper;

import com.bank.model.dto.ProfileDTO;
import com.bank.model.entities.Profile;

public class ProfileMapper {
	private static final ModelMapper modelMapper=new ModelMapper();
	public static ProfileDTO convertToDto(Profile profile)
	{
		return modelMapper.map(profile, ProfileDTO.class);
	}
	public static Profile convertToEntity(ProfileDTO profileDTO)
	{
		return  modelMapper.map(profileDTO, Profile.class);
	}
	
}
