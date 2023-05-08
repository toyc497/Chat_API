package com.api.bbmnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.EditalEntity;
import com.api.bbmnet.entity.MensagemEntity;
import com.api.bbmnet.entity.SistemaEntity;
import com.api.bbmnet.form.EditalForm;
import com.api.bbmnet.repository.EditalRepository;
import com.api.bbmnet.repository.SistemaRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;
	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	public List<EditalEntity> findAllEditais(){
		
		return editalRepository.findAll();
		
	}
	
	public EditalEntity saveEdital(EditalForm editalForm) {
		
		Optional<SistemaEntity> sistema = sistemaRepository.findById(editalForm.getIdSistema());
		
		SistemaEntity sistemaAux = null;
		
		if(sistema.isPresent()) {
			
			sistemaAux = sistema.get();
			
		}
		
		EditalEntity edital = new EditalEntity();
		edital.setChaveEdital(editalForm.getChaveEdital());
		edital.setNumeroPregao(editalForm.getNumeroPregao());
		edital.setLote(editalForm.getLote());
		edital.setSistema(sistemaAux);
		
		return editalRepository.save(edital);
		
	}
	
	public void deleteEditalById(Long id) {
		
		editalRepository.deleteById(id);
		
	}
	
	public List<MensagemEntity> getMensagensEdital(Long id) {
		
		Optional<EditalEntity> editalRequest = editalRepository.findById(id);
		
		EditalEntity editalResponse = null;
		
		if(editalRequest.isPresent()) {
			
			editalResponse = editalRequest.get();
			
		}
		
		List<MensagemEntity> mensagens = editalResponse.getMensagens();
		
		return mensagens;
		
	}
	
}
