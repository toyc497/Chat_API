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

import com.api.bbmnet.entity.MensagemEntity;
import com.api.bbmnet.form.MensagemForm;
import com.api.bbmnet.service.MensagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

	@Autowired
	private MensagemService mensagemService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<MensagemEntity>> getAllMensagens(){
		
		List<MensagemEntity> mensagens = mensagemService.findAllMensagens();
		
		return ResponseEntity.status(HttpStatus.OK).body(mensagens);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<MensagemEntity> createMensagem(@RequestBody @Valid MensagemForm mensagemForm){
		
		MensagemEntity mensagem =  mensagemService.saveMensagem(mensagemForm);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletaMensagem(@PathVariable("id") Long id) {
		
		mensagemService.deleteMensagemById(id);
		
	}
	
}
