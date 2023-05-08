package com.api.bbmnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.CredenciaisEntity;
import com.api.bbmnet.entity.EditalEntity;
import com.api.bbmnet.entity.SistemaEntity;
import com.api.bbmnet.form.SistemaForm;
import com.api.bbmnet.repository.SistemaRepository;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;
	
	public List<SistemaEntity> findAllSistemas(){
		
		return sistemaRepository.findAll();
		
	}
	
	public SistemaEntity saveSistema(SistemaForm sistemaForm) {
		
		SistemaEntity sistemaEntity = new SistemaEntity();
		sistemaEntity.setNome(sistemaForm.getNome());
		
		return sistemaRepository.save(sistemaEntity);
		
	}
	
	public void deletaSistemaById(long id) {
		
		sistemaRepository.deleteById(id);
		
	}
	
	public List<EditalEntity> getAllEditais(Long id){
		
		Optional<SistemaEntity> sistemaRequest = sistemaRepository.findById(id);
		
		SistemaEntity sistemaResponse = null;
		
		if(sistemaRequest.isPresent()) {
			sistemaResponse = sistemaRequest.get();
		}
		
		return sistemaResponse.getEditais();
		
	}
	
	public List<CredenciaisEntity> getAllCredenciais(Long id){
		
		Optional<SistemaEntity> sistemaRequest = sistemaRepository.findById(id);
		
		SistemaEntity sistemaResponse = null;
		
		if(sistemaRequest.isPresent()) {
			sistemaResponse = sistemaRequest.get();
		}
		
		return sistemaResponse.getCredenciais();
		
	}
	
}
