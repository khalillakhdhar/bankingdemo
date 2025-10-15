package com.bank.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.model.dto.CompteDTO;
import com.bank.model.dto.ProfileDTO;
import com.bank.model.dto.UtilisateurDTO;
import com.bank.model.entities.Compte;
import com.bank.model.entities.Utilisateur;
import com.bank.model.mappers.CompteMapper;
import com.bank.model.mappers.ProfileMapper;
import com.bank.model.mappers.UtilisateurMapper;
import com.bank.repository.CompteRepository;
import com.bank.repository.UtilisateurRepository;
import com.bank.services.UtilisateurService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UtilisateurServiceImp implements UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final CompteRepository compteRepository; 
	
	
	@Override
	public UtilisateurDTO addOneUtilisateur(UtilisateurDTO utilisateurDTO) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=UtilisateurMapper.convertToEntity(utilisateurDTO);
		Utilisateur savedUser=utilisateurRepository.save(utilisateur);
		return UtilisateurMapper.convertToDto(savedUser);
	}

	@Override
	public Page<UtilisateurDTO> getAllUtilisateur(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Utilisateur> utilisateurs=utilisateurRepository.findAll(pageable);
		/*List<UtilisateurDTO> users=new ArrayList<UtilisateurDTO>();
		utilisateurs.forEach(user->
		
		{
			users.add(UtilisateurMapper.convertToDto(user));
		}
				);
		*/
		
		
		return utilisateurs.map(UtilisateurMapper::convertToDto);
	
	}

	@Override
	public Optional<UtilisateurDTO> getOneUtilisateur(long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findById(id).map(UtilisateurMapper::convertToDto);
	}

	@Override
	public ProfileDTO assignProfileToUtilisateur(long idUser, ProfileDTO profileDTO) {
		// TODO Auto-generated method stub
		
		Utilisateur utilisateur=utilisateurRepository.findById(idUser)
				.orElseThrow(()-> new EntityNotFoundException("Utilisateur avec Id "+idUser+" introuvable"));
		utilisateur.setProfile(ProfileMapper.convertToEntity(profileDTO));
		Utilisateur updateUtilisateur= utilisateurRepository.save(utilisateur);
		
		return profileDTO;
	}

	@Override
	public void deleteOneUtilisateur(long id) {
		// TODO Auto-generated method stub
		utilisateurRepository.deleteById(id);

	}

	@Override
	public UtilisateurDTO assignCompteToUtilisateur(long idUser, CompteDTO compteDTO) {
		// TODO Auto-generated method stub
		Utilisateur utilisateur=utilisateurRepository.findById(idUser)
				.orElseThrow(()-> new EntityNotFoundException("Utilisateur avec Id "+idUser+" introuvable"));
		Compte cpt=CompteMapper.convertToEntity(compteDTO);
		utilisateur.getComptes().add(cpt);
		return UtilisateurMapper.convertToDto(utilisateurRepository.save(utilisateur));
		
		
		
	}
	
	
	
	
	

}
