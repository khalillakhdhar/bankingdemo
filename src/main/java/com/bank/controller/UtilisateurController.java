package com.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.dto.CompteDTO;
import com.bank.model.dto.UtilisateurDTO;
import com.bank.services.UtilisateurService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {
private final UtilisateurService utilisateurService;
@PostMapping
public ResponseEntity<UtilisateurDTO> addUtilisateur(@RequestBody @Valid UtilisateurDTO utilisateurDTO)
{
	UtilisateurDTO createdUtilisateur=utilisateurService.addOneUtilisateur(utilisateurDTO);
	return new ResponseEntity<UtilisateurDTO>(createdUtilisateur,HttpStatus.CREATED);

}
@GetMapping("/{id}")
public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable long id)
{
	return utilisateurService.getOneUtilisateur(id)
			.map(ResponseEntity::ok)
			.orElseGet(()->ResponseEntity.notFound().build());
}
@PatchMapping("/{id}")
public ResponseEntity<UtilisateurDTO> assignCompte(@PathVariable long idUser,@RequestBody @Valid CompteDTO compteDTO)
{
return new ResponseEntity<UtilisateurDTO>(utilisateurService.assignCompteToUtilisateur(idUser, compteDTO),HttpStatus.CREATED);	


}



}
