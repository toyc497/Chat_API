package com.api.bbmnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bbmnet.entity.CredenciaisEntity;
import com.api.bbmnet.entity.EditalEntity;
import com.api.bbmnet.entity.SistemaEntity;
import com.api.bbmnet.form.SistemaForm;
import com.api.bbmnet.service.SistemaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sistema")
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<SistemaEntity>> getAllSistemas(){
		
		List<SistemaEntity> sistemas = sistemaService.findAllSistemas();
		
		return ResponseEntity.status(HttpStatus.OK).body(sistemas);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<SistemaEntity> createSistema(@RequestBody @Valid SistemaForm sistemaForm) {
		
		SistemaEntity sistemaSaved =  sistemaService.saveSistema(sistemaForm);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(sistemaSaved);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletaSistema(@PathVariable("id") long id) {
		
		sistemaService.deletaSistemaById(id);
		
	}
	
	@GetMapping("/editais/{id}")
	public ResponseEntity<List<EditalEntity>> getEditais(@PathVariable("id") Long id){
		
		List<EditalEntity> editais = sistemaService.getAllEditais(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(editais);
		
	}
	
	@GetMapping("/credenciais/{id}")
	public ResponseEntity<List<CredenciaisEntity>> getCredenciais(@PathVariable("id") Long id){
		
		List<CredenciaisEntity> credenciais = sistemaService.getAllCredenciais(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(credenciais);
		
	}
	
}
