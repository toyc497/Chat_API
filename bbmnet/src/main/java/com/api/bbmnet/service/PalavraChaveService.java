package com.api.bbmnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bbmnet.entity.ColorGroupEntity;
import com.api.bbmnet.entity.PalavraChaveEntity;
import com.api.bbmnet.form.PalavraChaveForm;
import com.api.bbmnet.repository.ColorGroupRepository;
import com.api.bbmnet.repository.PalavraChaveRepository;

@Service
public class PalavraChaveService {

	@Autowired
	private PalavraChaveRepository palavraChaveRepository;
	
	@Autowired
	private ColorGroupRepository colorGroupRepository;
	
	public List<PalavraChaveEntity> findAllPalavrasChave(){
		
		return palavraChaveRepository.findAll();
		
	}
	
	public PalavraChaveEntity savePalavraChave(PalavraChaveForm palavraForm) {
		
		Optional<ColorGroupEntity> colorGroupFound = colorGroupRepository.findById(palavraForm.getIdColorGroup());
		ColorGroupEntity colorGroup = null;
		
		if(colorGroupFound.isPresent()) {
			colorGroup = colorGroupFound.get();
		}
		
		PalavraChaveEntity palavraChave = new PalavraChaveEntity();
		palavraChave.setPalavra(palavraForm.getPalavra());
		palavraChave.setBeepName(palavraForm.getBeepName());
		palavraChave.setColorGroup(colorGroup);
		
		return palavraChaveRepository.save(palavraChave);
		
	}
	
	public void deletePalavraChave(Long id) {
		
		palavraChaveRepository.deleteById(id);
		
	}
	
}
