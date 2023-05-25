package com.api.bbmnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bbmnet.entity.CredenciaisEntity;
import com.api.bbmnet.form.CredenciaisForm;
import com.api.bbmnet.service.CredenciaisService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/credenciais")
public class CredenciaisController {

	@Autowired
	private CredenciaisService credenciaisService;
	
	@GetMapping("/getall")
	public List<CredenciaisEntity> getAllCredenciais(){
		
		return credenciaisService.findAllCredenciais();
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<CredenciaisEntity> createCredencial(@RequestBody @Valid CredenciaisForm credenciaisForm){
		
		CredenciaisEntity credencial = credenciaisService.saveCredencial(credenciaisForm);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(credencial);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCredencial(@PathVariable("id") Long id) {
		
		credenciaisService.deleteCredencialById(id);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<CredenciaisEntity> atualizarCredencial(@RequestBody CredenciaisForm credenciaisForm) {
		
		CredenciaisEntity credencialUpdated = credenciaisService.updateCredencial(credenciaisForm);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(credencialUpdated);
		
	}
	
}
