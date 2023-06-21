package com.api.bbmnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.CredenciaisEntity;
import com.api.bbmnet.entity.SistemaEntity;
import com.api.bbmnet.form.CredenciaisForm;
import com.api.bbmnet.repository.CredenciaisRepository;
import com.api.bbmnet.repository.SistemaRepository;

@Service
public class CredenciaisService {

	@Autowired
	private CredenciaisRepository credenciaisRepository;
	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	public List<CredenciaisEntity> findAllCredenciais(){
		
		return credenciaisRepository.findAll();
		
	}
	
	public CredenciaisForm findCredencialByIdSystema(Long id) {
		
		Optional<SistemaEntity> sistemaFounded = sistemaRepository.findById(id);
		SistemaEntity sistema = null;
		
		if(sistemaFounded.isPresent()) {
			sistema = sistemaFounded.get();
		}
		
		CredenciaisEntity credencialFromDB = credenciaisRepository.searchBySystemId(sistema);
		
		CredenciaisForm credencialResult = new CredenciaisForm();
		credencialResult.setId(credencialFromDB.getId());
		credencialResult.setUsuario(credencialFromDB.getUsuario());
		credencialResult.setSenha(credencialFromDB.getSenha());
		credencialResult.setIdSistema(credencialFromDB.getSistema().getId());
		
		return credencialResult;
		
	}
	
	public CredenciaisEntity saveCredencial(CredenciaisForm credenciaisForm) {
		
		Optional<SistemaEntity> sistema = sistemaRepository.findById(credenciaisForm.getIdSistema());
		
		SistemaEntity sistemaExists = null;
		
		if(sistema.isPresent()) {
			sistemaExists = sistema.get();
		}
		
		CredenciaisEntity credencialEntity = new CredenciaisEntity();
		credencialEntity.setUsuario(credenciaisForm.getUsuario());
		credencialEntity.setSenha(credenciaisForm.getSenha());
		credencialEntity.setSistema(sistemaExists);
		
		return credenciaisRepository.save(credencialEntity);
		
	}
	
	public void deleteCredencialById(Long id) {
		
		credenciaisRepository.deleteById(id);
		
	}
	
	public CredenciaisEntity updateCredencial(CredenciaisForm credencialForm) {
		
		Optional<CredenciaisEntity> credencial = credenciaisRepository.findById(credencialForm.getId());
		
		CredenciaisEntity credencialExists = null;
		
		if(credencial.isPresent()) {
			credencialExists = credencial.get();
		}
		
		credencialExists.setUsuario(credencialForm.getUsuario());
		credencialExists.setSenha(credencialForm.getSenha());
		
		return credenciaisRepository.save(credencialExists);
		
	}
	
}
