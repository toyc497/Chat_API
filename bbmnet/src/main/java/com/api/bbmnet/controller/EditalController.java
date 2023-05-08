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

import com.api.bbmnet.entity.EditalEntity;
import com.api.bbmnet.entity.MensagemEntity;
import com.api.bbmnet.form.EditalForm;
import com.api.bbmnet.service.EditalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/edital")
public class EditalController {

	@Autowired
	private EditalService editalService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<EditalEntity>> getAllEditais(){
		
		List<EditalEntity> editais = editalService.findAllEditais();
		
		return ResponseEntity.status(HttpStatus.OK).body(editais);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<EditalEntity> createEdital(@RequestBody @Valid EditalForm editalForm){
		
		EditalEntity edital = editalService.saveEdital(editalForm);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(edital);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEdital(@PathVariable("id") Long id) {
		
		editalService.deleteEditalById(id);
		
	}
	
	@GetMapping("/mensagens/{id}")
	public ResponseEntity<List<MensagemEntity>> getMensagens(@PathVariable("id") Long id){
		
		List<MensagemEntity> mensagens = editalService.getMensagensEdital(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(mensagens);
		
	}
	
}
