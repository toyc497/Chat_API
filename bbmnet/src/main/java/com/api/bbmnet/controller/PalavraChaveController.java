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

import com.api.bbmnet.entity.PalavraChaveEntity;
import com.api.bbmnet.form.PalavraChaveForm;
import com.api.bbmnet.service.PalavraChaveService;

@RestController
@RequestMapping("/palavraChave")
public class PalavraChaveController {

	@Autowired
	private PalavraChaveService palavraChaveService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<PalavraChaveEntity>> getAllPavrasChave(){
		
		return ResponseEntity.status(HttpStatus.OK).body(palavraChaveService.findAllPalavrasChave());
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<PalavraChaveEntity> savePalavraChave(@RequestBody PalavraChaveForm palavraForm){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(palavraChaveService.savePalavraChave(palavraForm)); 
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePalavraChave(@PathVariable("id") Long id) {
		
		palavraChaveService.deletePalavraChave(id);
		
	}
	
}
