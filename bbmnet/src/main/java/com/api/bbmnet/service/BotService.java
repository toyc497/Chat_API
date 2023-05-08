package com.api.bbmnet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.EditalEntity;
import com.api.bbmnet.entity.SistemaEntity;
import com.api.bbmnet.form.BotRequestForm;
import com.api.bbmnet.repository.EditalRepository;
import com.api.bbmnet.repository.SistemaRepository;

@Service
public class BotService {

	@Autowired
	private EditalRepository editalRepository;
	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	public BotRequestForm getEditalAndCredencial(Long idEdital) {
		
		Optional<EditalEntity> editalRequest = editalRepository.findById(idEdital);
		
		EditalEntity edital = null;
		
		if(editalRequest.isPresent()) {
			
			edital = editalRequest.get();
			
		}

		Optional<SistemaEntity> sistemaRequest = sistemaRepository.findById(edital.getSistema().getId());
		
		SistemaEntity sistema = null;
		
		if(sistemaRequest.isPresent()) {
			
			sistema = sistemaRequest.get();
			
		}
		
		BotRequestForm botForm = new BotRequestForm();
		botForm.setEdital(edital);
		botForm.setCredencial(sistema.getCredenciais());
		
		return botForm;
		
	}
	
}
