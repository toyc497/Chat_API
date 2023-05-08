package com.api.bbmnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.EditalEntity;
import com.api.bbmnet.entity.MensagemEntity;
import com.api.bbmnet.form.MensagemForm;
import com.api.bbmnet.repository.EditalRepository;
import com.api.bbmnet.repository.MensagemRepository;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private EditalRepository editalRepository;
	
	public List<MensagemEntity> findAllMensagens(){
		
		return mensagemRepository.findAll();
		
	}
	
	public MensagemEntity saveMensagem(MensagemForm mensagemForm) {
		
		Optional<EditalEntity> editalById = editalRepository.findById(mensagemForm.getIdEdital());
		
		EditalEntity edital = null;
		
		if(editalById.isPresent()) {
			edital = editalById.get();
		}
		
		MensagemEntity mensagem = new MensagemEntity();
		mensagem.setConteudo(mensagemForm.getConteudo());
		mensagem.setEdital(edital);
		
		return mensagemRepository.save(mensagem);
		
	}
	
	public void deleteMensagemById(Long id) {
		
		mensagemRepository.deleteById(id);
		
	}
	
}
